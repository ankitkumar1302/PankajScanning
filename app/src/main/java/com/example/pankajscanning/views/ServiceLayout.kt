package com.example.pankajscanning.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pankajscanning.models.servicesList
import com.example.pankajscanning.ui.theme.Typography

@Composable
fun ServicesList(onClick: () -> Unit) {
    LazyRow(
        modifier = Modifier
            .padding(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 10.dp)
    ) {
        items(servicesList) { service ->
            ServiceCard(title = service.title, image = service.image)
        }
    }
}

@Composable
fun ServiceCard(title: String, image: Int) {
    Card(
        modifier = Modifier
            .width(135.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .clickable { },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE6DBDB),
            contentColor = Color(0xFF000000)
        ),
        elevation = CardDefaults.cardElevation(5.dp),
    ) {
        Column {
            Box(modifier = Modifier.height(170.dp)) {
                Image(
                    painter = painterResource(id = image), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = title,
                modifier = Modifier.padding(start = 7.dp, bottom = 2.dp),
                color = Color.Black,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = Typography.titleMedium

                /*
                TODO: 1. Correct the color of the text.
                2. Create onclick listener for the card.
                 */

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewService() {
//    ServiceCard(title = "Pathology", image =R.drawable.pathology)
    ServicesList {}
}