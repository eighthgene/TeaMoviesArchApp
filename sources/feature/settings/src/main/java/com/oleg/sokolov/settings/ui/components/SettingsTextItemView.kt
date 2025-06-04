package com.oleg.sokolov.settings.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oleg.sokolov.theme.MoviesArchTheme

@Composable
fun SettingsTextItemView(
    modifier: Modifier = Modifier,
    title: String,
    value: String
) {
    Card(
        backgroundColor = MoviesArchTheme.colors.secondaryBackground,
        elevation = 8.dp,
        modifier = modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 20.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp),
                text = title,
                maxLines = 1,
                color = MoviesArchTheme.colors.primaryText,
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier
                    .padding(start = 4.dp, end = 8.dp),
                text = value,
                color = MoviesArchTheme.colors.accentColor,
            )

        }
    }
}