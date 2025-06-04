package com.oleg.sokolov.tea.android

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun <State : Any, Message : Any, Dependencies : Any> TeaScreen(
    viewModel: TeaViewModel<State, Message, Dependencies>,
    content: @Composable (TeaViewModel<State, Message, Dependencies>, State) -> Unit
) {
    val state = viewModel.state.collectAsState().value
    Log.v("TEA", "Rendering state: $state")
    content(viewModel, state)
}