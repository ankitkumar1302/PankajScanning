package com.example.pankajscanning.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.pankajscanning.R

@Composable
fun MyOrdersScreen() {
    Text(text = stringResource(id = R.string.my_orders))
}