package com.oleg.sokolov.search.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oleg.sokolov.search.R
import com.oleg.sokolov.theme.MoviesArchTheme

@Composable
fun SearchBar(
  text: String,
  onSearchTextChanged: (String) -> Unit,
  onClearTextClicked: () -> Unit,
  isLoading: Boolean,
  modifier: Modifier = Modifier
) {
  val hint = stringResource(id = R.string.search_hint_query)
  Card(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 4.dp),
    shape = RoundedCornerShape(20.dp),
    elevation = 16.dp
  ) {
    TextField(
      value = text,
      textStyle = MoviesArchTheme.typography.title1,
      onValueChange = onSearchTextChanged,
      placeholder = {
        Text(
          text = hint,
          color = MoviesArchTheme.colors.primaryTextHint,
          style = MoviesArchTheme.typography.title1
        )
      },
      trailingIcon = {
        IconButton(
          onClick = onClearTextClicked,
          enabled = !isLoading
        ) {
          if (isLoading) {
            CircularProgressIndicator(
              modifier = Modifier.size(20.dp),
              color = MoviesArchTheme.colors.accentColor
            )
          } else {
            if (text.isEmpty()) {
              Icon(
                painter = painterResource(id = R.drawable.ic_search),
                "Search icon",
                tint = MoviesArchTheme.colors.darkColor
              )
            } else {
              Icon(
                Icons.Default.Clear,
                "Search icon",
                tint = MoviesArchTheme.colors.darkColor
              )
            }
          }
        }
      },
      singleLine = true,
      colors = TextFieldDefaults.textFieldColors(
        textColor = MoviesArchTheme.colors.darkColor,
        backgroundColor = MoviesArchTheme.colors.reverseBackground,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
      )
    )
  }
}

@Composable
@Preview
fun SearchBarPreviewDark() {
  MoviesArchTheme(darkTheme = true) {
    SearchBar(text = "abc", onSearchTextChanged = {}, onClearTextClicked = { }, isLoading = false)
  }
}

@Composable
@Preview
fun SearchBarPreviewWhite() {
  MoviesArchTheme(darkTheme = false) {
    SearchBar(text = "abc", onSearchTextChanged = {}, onClearTextClicked = { }, isLoading = false)
  }
}

@Composable
@Preview
fun SearchBarEmptyDarkPreview() {
  MoviesArchTheme(darkTheme = false) {
    SearchBar(text = "", onSearchTextChanged = {}, onClearTextClicked = { }, isLoading = false)
  }
}

@Composable
@Preview
fun SearchBarEmptyWhitePreview() {
  MoviesArchTheme(darkTheme = false) {
    SearchBar(text = "", onSearchTextChanged = {}, onClearTextClicked = { }, isLoading = false)
  }
}
