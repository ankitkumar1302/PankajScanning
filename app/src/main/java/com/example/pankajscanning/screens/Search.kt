package com.example.pankajscanning.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pankajscanning.R
import com.example.pankajscanning.ui.theme.onBackground

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearch() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(), Alignment.TopCenter
    ) {
        val query = remember {
            mutableStateOf("")
        }
        val active = remember {
            mutableStateOf(false)
        }
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            query = query.value,
            onQueryChange = {
                query.value = it
            },
            onSearch = { newQuery ->
                println("Performing search on query: $newQuery)")
            },
            active = active.value,
            onActiveChange = {
                active.value = true
            },
            placeholder = { Text(text = "Search") },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = "Close"
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                    tint = Color.White
                )
            },
            shadowElevation = 5.dp,
            colors = SearchBarDefaults.colors(
                onBackground,
            ),
            shape = RoundedCornerShape(30.dp),
            tonalElevation = 5.dp,
        ) {

        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewSearchScreen() {
    CustomSearch()
}
