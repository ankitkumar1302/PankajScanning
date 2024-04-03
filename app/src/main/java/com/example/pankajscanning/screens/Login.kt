package com.example.pankajscanning.screens

import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }


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
                modifier = Modifier.padding(top = 45.dp)
            )
            Text(
                text = "Welcome back! Please enter \n your details.",
                style = TextStyle(
                    fontSize = 14.sp,
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
                    .padding(20.dp)
                    .fillMaxWidth(),
                value = text,
                onValueChange = { newText -> text = newText },
                label = {
                    Text(
                        text = "Email Address",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = White.copy(alpha = .5f),
                            letterSpacing = 0.12.sp,
                        ),
                    )
                },
                shape = RoundedCornerShape(50.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,  // Set the color of the text
                    cursorColor = BlueAccent,  // Set the color of the cursor
                    focusedBorderColor = BlueAccent,  // Set the color of the border when the text field is focused
                    unfocusedBorderColor = White.copy(alpha = .5f),  // Set the color of the border when the text field is not focused
                    ),

                )
            OutlinedTextField(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                value = password,
                onValueChange = { newPassword -> password = newPassword },
                label = {
                    Text(
                        text = "Password",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = White.copy(alpha = .5f),
                            letterSpacing = 0.12.sp,
                        ),
                    )
                },
                shape = RoundedCornerShape(50.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,  // Set the color of the text
                    cursorColor = BlueAccent,  // Set the color of the cursor
                    focusedBorderColor = BlueAccent,  // Set the color of the border when the text field is focused
                    unfocusedBorderColor = White.copy(alpha = .5f),  // Set the color of the border when the text field is not focused
                ),
                trailingIcon = {
                    Box(modifier = Modifier.padding(end = 15.dp)) {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                tint = White.copy(alpha = .5f)
                            )
                        }
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Text(
                    text = "Forgot Password?",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF12CDD9),

                        letterSpacing = 0.12.sp,
                    ),
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable {

                        }
                )
            }
            Button(
                modifier = Modifier
                    .padding(start = 20.dp, top = 45.dp, end = 20.dp)
                    .fillMaxWidth()
                    .size(56.dp)
                    .clip(RoundedCornerShape(50.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = BlueAccent,
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Login",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = White,
                        letterSpacing = 0.12.sp,
                    )
                )
            }
        }
    }

}

@Preview
@Composable
private fun PreviewLoginScreen() {
    LoginScreen()
}