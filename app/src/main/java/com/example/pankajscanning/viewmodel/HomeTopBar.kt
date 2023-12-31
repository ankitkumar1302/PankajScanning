package com.example.pankajscanning.viewmodel

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pankajscanning.R
import com.example.pankajscanning.ui.theme.Typography
import com.example.pankajscanning.ui.theme.background
import com.example.pankajscanning.ui.theme.onBackground
import com.example.pankajscanning.ui.theme.primaryTextColor
import com.example.pankajscanning.ui.theme.secondaryTextColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
//    avatarModel: String,
    onOpenCart: () -> Unit,
    onOpenDrawer: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(background, RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp))
            .padding(8.dp)
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .clickable { onOpenDrawer() },
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                Modifier
                    .clip(CircleShape)
                    .align(Alignment.Center)
                    .requiredSize(44.dp),
//                contentScale = ContentScale.Crop
            )
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

            Spacer(modifier = Modifier.width(8.dp))

//            Icon(
//                modifier = Modifier
//                    .size(24.dp),
//                imageVector = Icons.Rounded.Search,
//                contentDescription = null,
//                tint = secondaryTextColor
//            )
//
            Text(
                text = "Pankaj Scanning & Pathology\n" +
                        "Research Center",
                fontSize = Typography.bodyLarge.fontSize,
                fontWeight = Typography.bodyLarge.fontWeight,
                color = secondaryTextColor
            )

        }

        Box(
            modifier = Modifier
                .weight(1f)
                .clickable { onOpenCart() },
        ) {
            Icon(
                modifier = Modifier
                    .requiredSize(44.dp)
                    .padding(6.dp)
                    .align(Alignment.Center),
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = null,
                tint = primaryTextColor,
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    HomeTopBar(onOpenCart = {}) {
    }
}
