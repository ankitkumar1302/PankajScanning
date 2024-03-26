package com.example.pankajscanning.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pankajscanning.R
import com.example.pankajscanning.ui.theme.Dark
import com.example.pankajscanning.ui.theme.Orange
import com.example.pankajscanning.ui.theme.background
import com.example.pankajscanning.views.ServiceCardForServiceScreen

@Composable
fun ServiceScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark)
    ) {
        Box {
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
        Box {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = { navController.navigateUp() },
                    modifier = Modifier
                        .padding(15.dp)
                        .background(
                            background.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(25.dp),
                        )
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        Modifier.size(40.dp),
                        tint = Color.White
                    )
                }
                Text(
                    text = stringResource(id = R.string.our_services),
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                    ),
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(80.dp))
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ServiceCardForServiceScreen(image = R.drawable.pathology)
        Text(
            text = "The various departments of the lab are fully equipped with the" +
                    " latest state of the art equipment's " +
                    "used in performing the tests.",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .padding(start = 35.dp, top = 17.dp, end = 25.dp)
                .align(alignment = Alignment.CenterHorizontally),
            color = Color.White.copy(alpha = 0.6f)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Hematology", style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Left
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 30.dp),
            color = Orange
        )
        Text(
            text = "The Hematology Department is equipped with fully automated high" +
                    " end cell counters and various other instruments for Routine as well" +
                    " as Specialised Hematology testing.",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start
            ),
            modifier = Modifier
                .padding(start = 30.dp, top = 15.dp, end = 5.dp)
                .align(alignment = Alignment.CenterHorizontally),
            color = Color.White.copy(alpha = .8f)
        )
        Spacer(modifier = Modifier.height(35.dp))
        Text(
            text = "Clinical Biochemistry", style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Left
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 30.dp),
            color = Orange
        )
        Text(
            text = "The Biochemistry Department is equipped " +
                    "with multiple fully automated latest instruments.",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start
            ),
            modifier = Modifier
                .padding(start = 30.dp, top = 15.dp, end = 5.dp)
                .align(alignment = Alignment.CenterHorizontally),
            color = Color.White.copy(alpha = .8f)
        )

    }

}

/*
TODO 1 -> Create onClick for each services and navigate to the respective screen.
TODO 2 -> Create splash screen and Login/Register screen.
 */


@Preview()
@Composable
private fun PreviewService() {
    ServiceScreen(navController = rememberNavController())
}





