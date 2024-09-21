package com.example.yujie.Legend

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchPage(
    navController: NavController,
    viewModel: LegendViewModel,
    movies: List<MovieResults>
) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredMovies by remember(searchQuery) {
        derivedStateOf {
            movies.filter { movie ->
                movie.title.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Rounded.ArrowBackIosNew,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                title = {
                    Text(
                        text = "Search",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black // Set background color to black
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize() // Fill the entire available space
                .background(Color.Black) // Black background for the whole screen
                .padding(paddingValues) // Ensure content is not obscured by the TopAppBar
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp) // Adjust padding if necessary
                        .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)) // Gray border
                        .background(Color.Black) // Black background for the search box
                ) {
                    TextField(
                        value = searchQuery,
                        onValueChange = { query -> searchQuery = query },
                        placeholder = { Text("Search...", color = Color.Gray) }, // Gray placeholder text
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

                // Show movie results only when there is a search query
                if (searchQuery.isNotEmpty()) {
                    if (filteredMovies.isEmpty()) {
                        Text(
                            text = "No results found.",
                            color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                    } else {
                        LazyColumn(modifier = Modifier.padding(16.dp)) {
                            items(filteredMovies) { movie ->
                                MovieItem(movie,navController)
                            }
                        }
                    }
                }
            }
        }

    }
}
@Composable
fun MovieItem(movie: MovieResults, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                navController.navigate("detail/${movie.id}")
            }
    ) {
        AsyncImage(
            model = movie.fullPosterPath(),
            contentDescription = movie.title,
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = movie.title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = movie.releaseDate,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}
