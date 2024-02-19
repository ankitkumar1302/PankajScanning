package com.example.pankajscanning.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pankajscanning.R
import com.example.pankajscanning.models.sliderImages
import com.example.pankajscanning.ui.theme.Typography
import com.example.pankajscanning.views.ServicesList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable()
fun HomeScreen() {
    val sliderImagesList = sliderImages
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        sliderImagesList.size
    }
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.animateScrollToPage(nextPage)
        }
    }
        Column(
        modifier = Modifier
            .fillMaxSize(),
//            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.wrapContentSize()
        ) {
            HorizontalPager(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 15.dp)
                    .wrapContentSize(),
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 17.dp),
            ) { page ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp)
                        .padding(5.dp)
                        .graphicsLayer {
                            val pageOffset = (
                                    (pagerState.currentPage - page) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        },
                    elevation = CardDefaults.cardElevation(5.dp),
                ) {
                    Image(
//                        painter = painterResource(id = images[page]),
                        painter = painterResource(id = sliderImagesList[page].imageResId),
                        contentDescription = "Images",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            IconButton(
                onClick = {
                    val nextPage = pagerState.currentPage + 1
                    if (nextPage < sliderImagesList.size) {
                        scope.launch {
                            pagerState.scrollToPage(nextPage)
                        }
                    }
                },
                modifier = Modifier
                    .padding(30.dp)
                    .size(48.dp)
                    .align(Alignment.CenterEnd)
                    .clip(CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.LightGray
                )
            }
            IconButton(
                onClick = {
                    val prevPage = pagerState.currentPage - 1
                    if (prevPage >= 0) {
                        scope.launch {
                            pagerState.scrollToPage(prevPage)
                        }
                    }
                },
                modifier = Modifier
                    .padding(30.dp)
                    .size(48.dp)
                    .align(Alignment.CenterStart)
                    .clip(CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.LightGray
                )
            }
        }
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
        Text(
            text = stringResource(id = R.string.our_services),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 17.dp, top = 10.dp),

            fontSize = 20.sp,
            style = Typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            ServicesList(onClick = {})
        }
    }
}

@Composable
@Preview()
fun HomeScreenPreview() {
    HomeScreen()
}


fun lerp(start: Float, stop: Float, fraction: Float): Float {
    return (1 - fraction) * start + fraction * stop
}







