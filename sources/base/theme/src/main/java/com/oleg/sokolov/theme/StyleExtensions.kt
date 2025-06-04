package com.oleg.sokolov.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

val TextStyle.grey get() = copy(color = BaseLightPalette.tagColor)
val TextStyle.accent get() = copy(color = BaseLightPalette.accentColor)
val TextStyle.white get() = copy(color = BaseLightPalette.whiteColor)
val TextStyle.dark get() = copy(color = BaseLightPalette.darkColor)

val TextStyle.bold get() = copy(fontWeight = FontWeight.Bold)
val TextStyle.semiBold get() = copy(fontWeight = FontWeight.SemiBold)
val TextStyle.medium get() = copy(fontWeight = FontWeight.Medium)
