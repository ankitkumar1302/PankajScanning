package com.example.pankajscanning.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
    var query = remember {
        mutableStateOf("")
    }
    var active = remember {
        mutableStateOf(false)
    }
    SearchBar(
        query = query.value,
        onQueryChange = {
            query.value = it
        },
        onSearch = { newQuery ->
            println("Performing search on query: $newQuery)")
        },
        active = false,
        onActiveChange = {
            active = mutableStateOf(it)
        },
        modifier = Modifier
            .fillMaxWidth(),
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
        tonalElevation = 2.dp
    ) {

    }
}


@Preview(showSystemUi = true)
@Composable
private fun PreviewSearchScreen() {
    Box(modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp), Alignment.TopCenter) {
        CustomSearch()
    }
}