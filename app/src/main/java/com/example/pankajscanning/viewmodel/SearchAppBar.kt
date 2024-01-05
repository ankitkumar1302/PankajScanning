package com.example.pankajscanning.viewmodel

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    var query by remember { mutableStateOf("") }

    TopAppBar(
        title = {
            TextField(
                value = query,
                onValueChange = { newQuery ->
                    query = newQuery
                    onQueryChange(newQuery)
                },
                placeholder = { Text("Search") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { onSearch() }),
                singleLine = true
            )
        },
        actions = {
            IconButton(onClick = { onSearch() }) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
        }
    )
}