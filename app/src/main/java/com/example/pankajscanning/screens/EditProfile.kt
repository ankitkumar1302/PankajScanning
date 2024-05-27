package com.example.pankajscanning.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pankajscanning.R
import com.example.pankajscanning.ui.theme.BlueAccent
import com.example.pankajscanning.ui.theme.LightBlueAccent
import com.example.pankajscanning.ui.theme.White
import com.example.pankajscanning.ui.theme.background

@Composable
fun EditProfileScreen() {
    var text by remember { mutableStateOf("") }
    var emailAddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    val focusRequesters = remember { List(4) { FocusRequester() } }
    val scrollState = rememberScrollState()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .imePadding(), color = background
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .verticalScroll(scrollState)

        ) {

            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(id = R.drawable.man),
                contentDescription = null,
                modifier = Modifier
                    .size(72.dp)
                    .shadow(
                        elevation = 20.dp,
                        spotColor = Color(0x0F000000),
                        ambientColor = Color(0x0F000000)
                    )
            )
            Text(
                text = "Tiffany",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                    letterSpacing = 0.12.sp,
                ),
                modifier = Modifier.padding(top = 20.dp)
            )
            Text(
                text = "Tiffanyjearsey@gmail.com",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFB1B1B1),
                ),
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                modifier = Modifier
                    .focusRequester(focusRequesters[0])
                    .padding(top = 15.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = text,
                onValueChange = { newText -> text = newText },
                maxLines = 1,
                label = {
                    Text(
                        text = "Full Name",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = White.copy(alpha = .5f),
                            letterSpacing = 0.12.sp,
                        ),
                        maxLines = 1
                    )
                },
                shape = RoundedCornerShape(50.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,  // Set the color of the text
                    cursorColor = BlueAccent,  // Set the color of the cursor
                    focusedBorderColor = BlueAccent,  // Set the color of the border when the text field is focused
                    unfocusedBorderColor = White.copy(alpha = .5f),  // Set the color of the border when the text field is not focused
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusRequesters[1].requestFocus()
                }),
            )
            OutlinedTextField(
                modifier = Modifier
                    .focusRequester(focusRequesters[1])
                    .padding(top = 15.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = emailAddress,
                onValueChange = { newText -> emailAddress = newText },
                maxLines = 1,
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
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = {
                    focusRequesters[2].requestFocus()
                }),

            )
            OutlinedTextField(
                modifier = Modifier
                    .focusRequester(focusRequesters[2])
                    .padding(top = 15.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = password,
                onValueChange = { newText -> password = newText },
                maxLines = 1,
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
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = {
                    focusRequesters[3].requestFocus()
                }),
                visualTransformation = PasswordVisualTransformation(),
            )
            OutlinedTextField(
                modifier = Modifier
                    .focusRequester(focusRequesters[3])
                    .padding(top = 15.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = phoneNumber,
                onValueChange = { newText -> phoneNumber = newText },
                maxLines = 1,
                label = {
                    Text(
                        text = "Phone Number",
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
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusRequesters[4].freeFocus()
                }),
                )
            //Button
            Button(
                modifier = Modifier
                    .padding(start = 20.dp, top = 45.dp, end = 20.dp)
                    .fillMaxWidth()
                    .size(56.dp)
                    .clip(RoundedCornerShape(50.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = LightBlueAccent,
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Save Changes",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = White,
                        letterSpacing = 0.12.sp,
                    )
                )
            }
            Spacer(modifier =Modifier.height(200.dp))
        }
    }
}

@Preview
@Composable
private fun PreviewEditProfileScreen() {
    EditProfileScreen()
}