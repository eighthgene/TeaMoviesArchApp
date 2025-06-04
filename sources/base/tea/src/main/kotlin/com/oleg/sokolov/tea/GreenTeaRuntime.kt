package com.oleg.sokolov.tea

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

class TeaRuntime<State : Any, Message : Any, Dependencies : Any>(
    init: () -> Update<State, Message, Dependencies>,
    private val update: (Message, State) -> Update<State, Message, Dependencies>,
    private val dependencies: Dependencies,
    private val runtimeContext: CoroutineContext = Dispatchers.Main,
    private val renderContext: CoroutineContext = Dispatchers.Main,
    private val commandContext: CoroutineContext = Dispatchers.IO,
    exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable -> throw throwable }
) : CoroutineScope {

  override val coroutineContext: CoroutineContext = runtimeContext + SupervisorJob() + exceptionHandler

  private val stateListeners = mutableListOf<((State) -> Unit)>()

  private var currentState: State

  init {
    val initial = init()
    currentState = initial.state
    step(initial)
  }

  fun listenState(listener: (State) -> Unit) {
    stateListeners.add(listener)
    listener(currentState)
  }

  fun dispatch(Message: Message) {
    if (isActive) {
      // We use current state for update exactly because we don't want to play message on the outdated information
      launch(runtimeContext) { step(update(Message, currentState)) }
    }
  }

  private fun step(next: Update<State, Message, Dependencies>) {
    val renderState = next.state
    currentState = renderState

    launch(renderContext) {
      stateListeners.notifyAll(renderState)
    }

    next.commands.forEach { effekt ->
      launch(commandContext) {
        effekt.run(this, dependencies)?.collect {
          dispatch(it)
        }
      }
    }
  }

  private fun <T> List<(T) -> Unit>.notifyAll(value: T) = forEach { listener -> listener.invoke(value) }
}
