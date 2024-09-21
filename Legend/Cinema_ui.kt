package com.example.yujie.Legend

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.yujie.model.CinemaItem
import com.example.yujie.model.cinemaItems
import com.example.yujie.movie_module.ComposeBottomBar


@Composable
fun CinemaPage(navController: NavHostController, vm: LegendViewModel) {
    var searchQuery by remember { mutableStateOf("") }

    // Filter cinemaItems based on searchQuery
    val filteredCinemaItems by remember(searchQuery) {
        derivedStateOf {
            cinemaItems.filter {
                it.location.contains(searchQuery, ignoreCase = true)
            }
        }
    }
    Scaffold(
        bottomBar = { ComposeBottomBar(navController = navController, vm = vm) }, // Pass navController and vm
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black) // Set the background color to black
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black) // Set the background color to black
                ) {
                    Text(
                        text = "Cinema",
                        fontSize = 20.sp,
                        color = Color.White, // Set text color to white for better contrast
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(16.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 56.dp)
                            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)) // Gray border
                            .background(Color.Black) // Black background
                    ) {
                        TextField(
                            value = searchQuery,
                            onValueChange = { query -> searchQuery = query },
                            placeholder = {
                                Text(
                                    "Search...",
                                    color = Color.Gray
                                )
                            }, // Gray placeholder text
                            colors = TextFieldDefaults.colors(
                                focusedTextColor = Color.White, // Text color when focused
                                unfocusedTextColor = Color.White, // Text color when not focused
                                focusedContainerColor = Color.Black, // Background color when focused
                                unfocusedContainerColor = Color.Black, // Background color when not focused
                                focusedIndicatorColor = Color.Transparent, // Remove the default indicator when focused
                                unfocusedIndicatorColor = Color.Transparent, // Remove the default indicator when not focused
                                cursorColor = Color.White // Cursor color
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    modifier = Modifier.background(Color.Black) // Set the background color to black
                ) {
                    items(filteredCinemaItems) { item ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                                .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
                                .background(Color.Black) // Set the background color to black
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp) // Padding between the border and content
                            ) {
                                // Image
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp) // Adjust height as needed
                                        .background(
                                            MaterialTheme.colorScheme.surface,
                                            RoundedCornerShape(8.dp)
                                        )
                                ) {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data(item.imageUrl)
                                            .crossfade(true)
                                            .build(),
                                        contentDescription = "Movie Image",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                            .clickable {
                                                navController.navigate("detail_cinema/${item.location}")
                                            },
                                    )
                                }

                                // Texts below the image
                                Column(
                                    modifier = Modifier
                                        .padding(top = 8.dp)
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = item.location,
                                        fontSize = 20.sp,
                                        color = Color.White // Set text color to gray for better contrast
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(), // Optional: Adjust padding to fit your layout
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.LocationOn, // Use your desired icon here
                                            contentDescription = "Location icon",
                                            tint = Color.Red, // Match the icon color to the text color for consistency
                                            modifier = Modifier.padding(end = 2.dp) // Add some spacing between the icon and text
                                        )
                                        Text(
                                            text = item.title,
                                            fontSize = 16.sp,
                                            color = Color.White, // Set text color to white for better contrast
                                            modifier = Modifier.padding(bottom = 4.dp)
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
