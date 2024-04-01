package com.example.pankajscanning.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pankajscanning.ui.theme.BlueAccent
import com.example.pankajscanning.ui.theme.White
import com.example.pankajscanning.ui.theme.background

@Composable
fun LoginScreen() {

    var text by remember { mutableStateOf("") }
    Surface(modifier = Modifier.fillMaxSize(), color = background) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Hi, User",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                    letterSpacing = 0.12.sp,
                ),
                modifier = Modifier.padding(top = 50.dp)
            )
            Text(
                text = "Welcome back! Please enter \n your details.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500),
                    color = White.copy(alpha = .5f),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.12.sp,
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.height(125.dp))

            OutlinedTextField(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                value = text,
                onValueChange = {},
                label = {
                    Text(
                        text = "Email",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = White.copy(alpha = .5f),
                            letterSpacing = 0.12.sp,
                        )
                    )
                },
                shape = RoundedCornerShape(50.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,  // Set the color of the text
                    cursorColor = BlueAccent,  // Set the color of the cursor
                    focusedBorderColor = White,  // Set the color of the border when the text field is focused
                    unfocusedBorderColor = White.copy(alpha = .5f),  // Set the color of the border when the text field is not focused
                )


            )


        }
    }

}

@Preview
@Composable
private fun PreviewLoginScreen() {
    LoginScreen()
}