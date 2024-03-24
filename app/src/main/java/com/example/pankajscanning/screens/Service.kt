package com.example.pankajscanning.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pankajscanning.R
import com.example.pankajscanning.ui.theme.Dark
import com.example.pankajscanning.ui.theme.background


@Composable
fun ServiceScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.pathology),
                contentDescription = "Service",
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(0.5f)
                    .height(550.dp),
                contentScale = ContentScale.Crop
            )
        }
        val pxValueTarget = with(LocalDensity.current) { 500.dp.toPx() }
        Box(
            modifier = Modifier
                .height(100.dp)
                .background(
                    Brush.linearGradient(
                        listOf(Color.Transparent, Dark),
                        start = Offset(0f, 0f),
                        end = Offset(0f, pxValueTarget)
                    )
                )
        )



    }
}

@Preview
@Composable
private fun PreviewService() {
    ServiceScreen()
}
