package com.example.pankajscanning.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pankajscanning.R

@Composable
fun MySubscriptionsScreen() {
    Text(text = stringResource(id = R.string.my_subscriptions), modifier = Modifier.fillMaxSize())
}