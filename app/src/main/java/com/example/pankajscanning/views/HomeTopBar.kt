package com.example.pankajscanning.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.example.pankajscanning.R
import com.example.pankajscanning.Screen
import com.example.pankajscanning.ui.theme.Typography
import com.example.pankajscanning.ui.theme.background
import com.example.pankajscanning.ui.theme.onBackground
import com.example.pankajscanning.ui.theme.primaryTextColor
import com.example.pankajscanning.ui.theme.secondaryBackground
import com.example.pankajscanning.ui.theme.secondaryTextColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableInteractionSource")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
//    avatarModel: String,
    onOpenCart: () -> Unit,
    onOpenDrawer: () -> Unit,
    currentDestination: NavBackStackEntry?
) {
    when (currentDestination?.destination?.route) {
        Screen.Search.route -> {
            CustomSearch()
        }
        Screen.Profile.route -> {
            ProfileTopBar()
        }
        else -> {
            Surface(elevation = 4.dp) {
                Row(
                    modifier = Modifier
                        .background(background)
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(56.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),

                    ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp)
                            .clickable(
                                interactionSource = MutableInteractionSource(),
                                indication = rememberRipple(bounded = false)
                            ) { onOpenDrawer() },
                    ) {
                        //            Icon(
                        //                painterResource(id = R.drawable.ic_menu),
                        ////                imageVector = Icons.Filled.,
                        //                contentDescription = "Menu",
                        //                Modifier
                        //                    .align(Alignment.Center)
                        //                    .requiredSize(35.dp),
                        //                tint = primaryTextColor
                        //            )
                        Image(
                            painter = painterResource(id = R.drawable.man),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .requiredSize(40.dp)
                                .align(Alignment.Center)
                        )
                        //            val avatarModel ="https://www.google.com/images/branding/googlelogo/2x/googlelogo_light_color_92x30dp.png"
                        //            AsyncImage(
                        //                modifier = Modifier
                        //                    .requiredSize(44.dp)
                        //                    .clip(CircleShape)
                        //                    .align(Alignment.Center),
                        //                model = avatarModel,
                        //                contentDescription = null,
                        //                contentScale = ContentScale.Crop
                        //            )
                    }
                    Row(
                        modifier = Modifier
                            .weight(4f)
                            .height(44.dp)
                            .background(onBackground, RoundedCornerShape(50)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Pankaj Scanning & " +
                                    "Pathology " +
                                    "Research Center",
                            fontSize = Typography.bodyLarge.fontSize,
                            fontWeight = Typography.bodyLarge.fontWeight,
                            color = secondaryTextColor, textAlign = TextAlign.Center,
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp)
                            .clickable(
                                interactionSource = MutableInteractionSource(),
                                indication = rememberRipple(bounded = false)
                            )
                            { onOpenCart() },
                    ) {
                        Icon(
                            modifier = Modifier
                                .requiredSize(30.dp)
                                .align(Alignment.Center),
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = null,
                            tint = primaryTextColor,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    HomeTopBar(onOpenCart = {}, onOpenDrawer = {}, currentDestination = null)
}