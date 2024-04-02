package com.example.pankajscanning.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pankajscanning.R
import com.example.pankajscanning.Screen
import com.example.pankajscanning.ui.theme.BlueAccent
import com.example.pankajscanning.ui.theme.Red
import com.example.pankajscanning.ui.theme.White
import com.example.pankajscanning.ui.theme.background

@Composable
fun ProfileScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
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
                                onClick = {
                                    navController.navigate(
                                        Screen.EditProfile.route//change to edit profile screen
                                    )
                                },
                                modifier = Modifier
                                    .padding(5.dp)

                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_reprofile),
                                    contentDescription = "Re Edit Profile",
                                    Modifier.size(25.dp),
                                    tint = BlueAccent
                                )
                            }
                        }
                    }
                }
            }
            // Account Block
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
                                    start = 20.dp,
                                    bottom = 10.dp
                                )
                        )
                        {
                            Text(
                                text = "Account",
                                color = White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(
                                    top = 20.dp,
                                )
                            )
                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp, bottom = 5.dp, end = 15.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .clickable { }

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_member),
                                    contentDescription = "Profile",
                                    modifier = Modifier
                                        .size(30.dp),
                                )
                                Text(
                                    text = "Member",
                                    color = White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start = 15.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                IconButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
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
                                    end = 30.dp
                                )
                            )

                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp, bottom = 5.dp, end = 15.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .clickable { }

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_change_password),
                                    contentDescription = "Profile",
                                    modifier = Modifier
                                        .size(30.dp),
                                )
                                Text(
                                    text = "Change Password",
                                    color = White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start = 15.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                IconButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
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


            // More Block
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
                                    start = 20.dp,
                                    bottom = 10.dp
                                )
                        )
                        {
                            Text(
                                text = "More",
                                color = White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(
                                    top = 20.dp,
                                )
                            )
                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp, bottom = 5.dp, end = 15.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .clickable { }

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_profile),
                                    contentDescription = "Profile",
                                    modifier = Modifier
                                        .size(30.dp),
                                )
                                Text(
                                    text = "Legal & Policies",
                                    color = White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start = 15.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                IconButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
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
                                    end = 30.dp
                                )
                            )

                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp, bottom = 5.dp, end = 15.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .clickable { }

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_help_support),
                                    contentDescription = "Profile",
                                    modifier = Modifier
                                        .size(25.dp),
                                )
                                Text(
                                    text = "Change Password",
                                    color = White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start = 15.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                IconButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
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
                                    end = 30.dp
                                )
                            )

                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp, bottom = 5.dp, end = 15.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .clickable { }

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_about_us),
                                    contentDescription = "Profile",
                                    modifier = Modifier
                                        .size(30.dp),
                                )
                                Text(
                                    text = "About Us",
                                    color = White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start = 15.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                IconButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
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


            Spacer(modifier = Modifier.height(15.dp))



            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = background
                ),
                modifier = Modifier
                    .padding(top = 5.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(25.dp))
                    .height(55.dp)
                    .border(
                        1.dp,
                        shape = RoundedCornerShape(25.dp),
                        color = Red
                    ),
            ) {
                Text(
                    text = "Log Out",
                    color = Red,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewProfileScreen() {
    ProfileScreen(navController = rememberNavController())
}