package com.example.pankajscanning.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pankajscanning.R
import com.example.pankajscanning.ui.theme.Red
import com.example.pankajscanning.ui.theme.White
import com.example.pankajscanning.ui.theme.background

@Composable
fun SignUpScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(top = 180.dp)
                    .height(170.dp)
                    .width(70.dp)
            )
            Spacer(modifier = Modifier.height(90.dp))
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(50.dp))
                .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Red,
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Sign Up", style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                        letterSpacing = 0.12.sp,
                        fontStyle = FontStyle.Normal
                    )
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "I already have an account? ",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFF92929D),
                        letterSpacing = 0.12.sp,
                        fontStyle = FontStyle.Normal
                    )
                )
                Text(
                    text = "Login", style = TextStyle(
                        fontSize = 16.sp,
                        color = Red,
                        letterSpacing = 0.12.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .padding(2.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = true)
                        ) {
                            /*TODO*/
                        }
                )
            }
            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 62.dp, end = 8.dp),
                    color = White.copy(alpha = 0.1f)
                )
                Text(
                    text = "Or Sign up with",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFF92929D),
                        letterSpacing = 0.12.sp,
                        fontStyle = FontStyle.Normal,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.weight(1f)
                )
                Divider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 62.dp, start = 8.dp),
                    color = White.copy(alpha = 0.1f)
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = true)
                        ) { /*TODO*/ }
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_apple),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = true)
                        ) { /*TODO*/ }
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = true)
                        ) { /*TODO*/ }
                )

            }


        }
    }


}

@Preview
@Composable
private fun PreviewSignUpScreen() {
    SignUpScreen()
}