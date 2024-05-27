package com.example.pankajscanning.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pankajscanning.R

@Composable
fun CartScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.cart))
    }
}
