package com.example.pankajscanning.screens

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun LocationScreen() {
    val webViewClient = remember {
        WebViewClient()
    }

    val coroutineScope = rememberCoroutineScope()
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                this.webViewClient = webViewClient
                this.settings.javaScriptEnabled = true

                // Use coroutines to load the URL asynchronously
                coroutineScope.launch {
                    this@apply.loadUrl("https://www.pankajscanningandpathology.com/locations")
                }
            }
        }
    )
}
/*
TODO: Create a location screen that will show the location of the user on the map.
TODO: Use the Google Maps API to show the location of the user or the lab.
NOTE: I have to talk because I not have card to purchase the APIs.

 */

@Preview
@Composable
private fun PreviewLocationScreen() {
    LocationScreen()
}