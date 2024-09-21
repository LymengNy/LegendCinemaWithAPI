package com.example.yujie.Legend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.yujie.R
import com.example.yujie.movie_module.ComposeBottomBar
import com.example.yujie.ui.theme.Black2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingPage(navController: NavHostController, vm: LegendViewModel) {
    Scaffold(
        bottomBar = { ComposeBottomBar(navController = navController, vm=vm)} ,
        topBar = {

            TopAppBar(
                title = { Text("Accounts", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                ),
                actions = {
                    IconButton(onClick = { navController.navigate("userScreenRoute") }) { // Replace "userScreenRoute" with your actual route
                        Icon(
                            imageVector = Icons.Default.Person, // Use your desired icon
                            contentDescription = "Settings",
                            tint = Color.White
                        )
                    }
                }

            )
        },

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.Black)
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "Tickets", color = Color.White)
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(Color(0xFF292829))
                            .padding(horizontal = 16.dp, vertical = 8.dp) // Adjust padding for better alignment
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(), // Make sure the Row takes the full size of the Box
                            horizontalArrangement = Arrangement.SpaceBetween, // Spread content across the Row
                            verticalAlignment = Alignment.CenterVertically // Align items vertically to the center
                        ) {
                            Text(
                                text = "Purchase",
                                color = Color.White
                            )
                            Icon(
                                Icons.Default.ArrowForwardIos, // Replace with your icon resource
                                contentDescription = "Icon Description",
                                tint = Color.White
                            )
                        }
                    }
                }

                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "Languages", color = Color.White)
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(Color(0xFF292829))
                            .padding(horizontal = 16.dp, vertical = 8.dp) // Adjust padding for better alignment
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(), // Make sure the Row takes the full size of the Box
                            horizontalArrangement = Arrangement.SpaceBetween, // Spread content across the Row
                            verticalAlignment = Alignment.CenterVertically // Align items vertically to the center
                        ) {
                            Text(
                                text = "English",
                                color = Color.White
                            )

                            Icon(
                                Icons.Default.ArrowForwardIos, // Replace with your icon resource
                                contentDescription = "Icon Description",
                                tint = Color.White
                            )
                        }
                    }
                }

                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "Account", color = Color.White)
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(Color(0xFF292829))
                            .padding(horizontal = 16.dp, vertical = 8.dp) // Adjust padding for better alignment
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(), // Make sure the Row takes the full size of the Box
                            horizontalArrangement = Arrangement.SpaceBetween, // Spread content across the Row
                            verticalAlignment = Alignment.CenterVertically // Align items vertically to the center
                        ) {

                            Text(
                                text = "Change Password",
                                color = Color.White
                            )
                            Icon(
                                Icons.Default.ArrowForwardIos, // Replace with your icon resource
                                contentDescription = "Icon Description",
                                tint = Color.White
                            )
                        }
                    }
                }

                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "What's new?", color = Color.White)
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(Color(0xFF292829))
                            .padding(horizontal = 16.dp, vertical = 8.dp) // Adjust padding for better alignment
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(), // Make sure the Row takes the full size of the Box
                            horizontalArrangement = Arrangement.SpaceBetween, // Spread content across the Row
                            verticalAlignment = Alignment.CenterVertically // Align items vertically to the center
                        ) {
                            Text(
                                text = "New & Activity",
                                color = Color.White
                            )
                            Icon(
                                Icons.Default.ArrowForwardIos, // Replace with your icon resource
                                contentDescription = "Icon Description",
                                tint = Color.White
                            )
                        }
                    }
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(text = "Notification", color = Color.White)
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(Color(0xFF292829))
                                .padding(horizontal = 16.dp, vertical = 8.dp) // Adjust padding for better alignment
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(), // Make sure the Row takes the full size of the Box
                                horizontalArrangement = Arrangement.SpaceBetween, // Spread content across the Row
                                verticalAlignment = Alignment.CenterVertically // Align items vertically to the center
                            ) {
                                Text(
                                    text = "Notification",
                                    color = Color.White
                                )
                                Icon(
                                    Icons.Default.ArrowForwardIos, // Replace with your icon resource
                                    contentDescription = "Icon Description",
                                    tint = Color.White
                                )
                            }
                        }
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(text = "About us", color = Color.White)
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(Color(0xFF292829))
                                    .padding(horizontal = 16.dp, vertical = 8.dp) // Adjust padding for better alignment
                            ) {
                                Column {


                                    Row(
                                        modifier = Modifier.fillMaxSize(), // Make sure the Row takes the full size of the Box
                                        horizontalArrangement = Arrangement.SpaceBetween, // Spread content across the Row
                                        verticalAlignment = Alignment.CenterVertically // Align items vertically to the center
                                    ) {
                                        Text(
                                            text = "about us",
                                            color = Color.White
                                        )
                                        Icon(
                                            Icons.Default.ArrowForwardIos, // Replace with your icon resource
                                            contentDescription = "Icon Description",
                                            tint = Color.White
                                        )
                                    }
                                    Row(
                                        modifier = Modifier.fillMaxSize(), // Make sure the Row takes the full size of the Box
                                        horizontalArrangement = Arrangement.SpaceBetween, // Spread content across the Row
                                        verticalAlignment = Alignment.CenterVertically // Align items vertically to the center
                                    ) {
                                        Text(
                                            text = "About us",
                                            color = Color.White
                                        )
                                        Icon(
                                            Icons.Default.ArrowForwardIos, // Replace with your icon resource
                                            contentDescription = "Icon Description",
                                            tint = Color.White
                                        )
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    )
}
