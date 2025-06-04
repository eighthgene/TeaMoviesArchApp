package com.oleg.sokolov.common.core.navigation

import android.os.Parcelable
import androidx.navigation.NavOptions
import kotlinx.coroutines.flow.StateFlow



interface Router {

  val navActions: StateFlow<NavigationAction?>

  fun navigate(navAction: NavigationAction?)

}

interface NavigationAction {
  val destination: String
  val parcelableArguments: Map<String, Parcelable>
    get() = emptyMap()                              // No parcelable arguments as default
  val navOptions: NavOptions
    get() = NavOptions.Builder().build()            // No NavOptions as default
}


