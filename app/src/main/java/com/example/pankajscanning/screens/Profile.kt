package com.example.pankajscanning.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pankajscanning.R
import com.example.pankajscanning.ui.theme.BlueAccent
import com.example.pankajscanning.ui.theme.White
import com.example.pankajscanning.ui.theme.background

@Composable
fun ProfileScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .border(
                            0.5.dp,
                            shape = RoundedCornerShape(15.dp),
                            color = White.copy(alpha = 0.1f)
                        ),
                    elevation = 10.dp,
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .background(color = background),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .size(250.dp)
                                .padding(start = 30.dp, end = 15.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.man),
                                contentDescription = "profile image",
                                Modifier.size(55.dp)
                            )
                            Column(
                                modifier = Modifier
                                    .padding(15.dp)
                                    .align(Alignment.CenterVertically)
                            ) {
                                Text(
                                    text = "UserName",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = White,
                                    modifier = Modifier
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "email@example.com",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = White.copy(alpha = 0.5f)
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .padding(5.dp)

                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_reprofile),
                                    contentDescription = "Re Edit Profile",
                                    Modifier.size(30.dp),
                                    tint = BlueAccent
                                )
                            }
                        }
                    }
                }
            }

            Box(modifier = Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .border(
                            0.5.dp,
                            shape = RoundedCornerShape(15.dp),
                            color = White.copy(alpha = 0.1f)
                        ),
                    elevation = 10.dp,
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(color = background)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(
                                    start = 30.dp,
                                    top = 20.dp,
                                    bottom = 20.dp
                                )
                        )
                        {
                            Text(
                                text = "Account",
                                color = White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp,
                                modifier = Modifier
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 15.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_member),
                                    contentDescription = "Profile",
                                    modifier = Modifier
                                        .padding(top = 25.dp, bottom = 5.dp, end = 5.dp)
                                        .size(30.dp),
                                )
                                Text(
                                    text = "Member",
                                    color = White,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(
                                            top = 25.dp,
                                            bottom = 5.dp,
                                            start = 10.dp
                                        ),
                                    fontWeight = FontWeight.Normal
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                IconButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .padding(top = 22.dp, bottom = 5.dp, end = 10.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                        contentDescription = null,
                                        Modifier.size(40.dp),
                                        tint = BlueAccent
                                    )
                                }

                            }

                            Divider(
                                color = White.copy(alpha = 0.1f),
                                modifier = Modifier.padding(
                                    top = 10.dp, end = 30.dp
                                )
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 15.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_change_password),
                                    contentDescription = "Profile",
                                    modifier = Modifier
                                        .padding(top = 25.dp, bottom = 5.dp, end = 5.dp)
                                        .size(30.dp),
                                )
                                Text(
                                    text = "Change Password",
                                    color = White,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(
                                            top = 25.dp,
                                            bottom = 5.dp,
                                            start = 10.dp
                                        ),
                                    fontWeight = FontWeight.Normal
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                IconButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .padding(top = 22.dp, bottom = 5.dp, end = 10.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                        contentDescription = null,
                                        Modifier.size(40.dp),
                                        tint = BlueAccent
                                    )
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}

@Preview
@Composable
private fun PreviewProfileScreen() {
    ProfileScreen()
}