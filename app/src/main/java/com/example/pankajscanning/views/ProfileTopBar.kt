package com.example.pankajscanning.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pankajscanning.R
import com.example.pankajscanning.ui.theme.White
import com.example.pankajscanning.ui.theme.background

@Composable
fun CustomTopBar(name: String) {

    Surface(elevation = 4.dp) {
        Row(
            modifier = Modifier
                .background(background)
                .padding(8.dp)
                .fillMaxWidth()
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = name,
                fontSize = 18.sp,
                style = MaterialTheme.typography.h6,
                color = White,
                modifier = Modifier.padding(top = 20.dp, bottom = 15.dp)
            )
        }
    }

}

@Preview
@Composable
private fun PreviewCustomTopBar() {
    CustomTopBar(stringResource(id = R.string.profile))
}