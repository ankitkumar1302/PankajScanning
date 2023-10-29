package com.example.pankajscanning.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pankajscanning.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun HomeScreen() {
    val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,

        )

    val pagerState = rememberPagerState(pageCount = images.size)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.wrapContentSize()
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(26.dp)
            ) { currentpage ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp).padding(5.dp)
//                        .clip(shape = RoundedCornerShape(16.dp))
                        ,
                    elevation = CardDefaults.cardElevation(4.dp),
                    ) {
                    Image(
                        painter = painterResource(id = images[currentpage]),
                        contentDescription = "Images",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

            }

        }
    }
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun HomeScreenPreview() {
    HomeScreen()
}











