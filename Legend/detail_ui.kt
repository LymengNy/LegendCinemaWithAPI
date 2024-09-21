package com.example.yujie.Legend

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.yujie.model.cinemaItems
import com.example.yujie.movie_module.DateBox

import androidx.compose.ui.platform.LocalConfiguration
import com.example.yujie.model.cinemas


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPageLegend(vm: LegendViewModel, nc: NavController, movieId: Int) {
    var expanded by remember { mutableStateOf(false) }
    LaunchedEffect(movieId) {
        vm.getResultList() // Optionally fetch again, depending on how data is managed
    }

    val movie = vm.resultList.find { it.id == movieId }
    val isLoading = vm.isLoading
    val errorMessage = vm.errorMessage

    // Calculate the screen height
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp.dp
    val halfScreenHeight = screenHeightDp / 2

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            contentPadding = PaddingValues(bottom = halfScreenHeight) // Add bottom padding here
        ) {
            when {
                isLoading -> {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .background(Color.Black)
                        )
                    }
                }

                errorMessage.isNotEmpty() -> {
                    item {
                        Text(
                            text = "Error: $errorMessage",
                            modifier = Modifier.padding(16.dp),
                            color = Color.White
                        )
                    }
                }

                movie != null -> {
                    item {
                        Column {
                            // Image
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color.Gray)
                            ) {
                                // AsyncImage for the movie poster
                                AsyncImage(
                                    model = movie.fullPosterPath(),
                                    contentDescription = "Movie Poster",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )

                                // Navigation Icon
                                IconButton(
                                    onClick = { nc.popBackStack() },
                                    modifier = Modifier
                                        .align(Alignment.TopStart)
                                        .padding(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.ArrowBack,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(48.dp)
                                            .background(Color.Black.copy(alpha = 0.5f), CircleShape)
                                            .padding(12.dp),
                                        tint = Color.White
                                    )
                                }

                                // Play Icon
                                IconButton(
                                    onClick = { /* Handle Play Action */ },
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(16.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = "Play",
                                        modifier = Modifier
                                            .size(64.dp)
                                            .background(Color.Red.copy(alpha = 0.5f), CircleShape)
                                            .padding(12.dp),
                                        tint = Color.White
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))
                            Column(modifier = Modifier.padding(start = 8.dp)) {
                                // Title
                                Text(
                                    movie.title,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontSize = 24.sp,
                                    color = Color.White
                                )

                                // Details
                                Spacer(modifier = Modifier.height(10.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Movie,
                                        contentDescription = "Genre icon",
                                        tint = Color.Red,
                                        modifier = Modifier.padding(end = 2.dp)
                                    )
                                    Text(
                                        "Genre: Horror",
                                        fontSize = 16.sp,
                                        color = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.AccessTime,
                                        contentDescription = "Duration icon",
                                        tint = Color.Red,
                                        modifier = Modifier.padding(end = 2.dp)
                                    )
                                    Text(
                                        "Duration: 1h 35mins",
                                        fontSize = 16.sp,
                                        color = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.CreditCard,
                                        contentDescription = "Release icon",
                                        tint = Color.Red,
                                        modifier = Modifier.padding(end = 2.dp)
                                    )
                                    Text(
                                        "Release : ${movie.releaseDate}",
                                        fontSize = 16.sp,
                                        color = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.RemoveRedEye,
                                        contentDescription = "Classification icon",
                                        tint = Color.Red,
                                        modifier = Modifier.padding(end = 2.dp)
                                    )
                                    Text(
                                        "Classification:NC15: Horror",
                                        fontSize = 16.sp,
                                        color = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))
                                Text(
                                    "${movie.overview}",
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { expanded = !expanded }
                                .background(Color(0xFF292829), shape = RoundedCornerShape(8.dp))
                                .border(
                                    2.dp,
                                    Color.White,
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(), // Ensure the row takes up the full width
                                verticalAlignment = Alignment.CenterVertically // Align items vertically in the center
                            ) {
                                Text(
                                    text = "ALL Cinemas",
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.weight(1f) // Ensure text takes up remaining space
                                )
                                Icon(
                                    imageVector = Icons.Filled.ArrowForwardIos,
                                    contentDescription = "Location icon",
                                    tint = Color.White,
                                    modifier = Modifier.padding(start = 20.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            DateBox(
                                dayOfWeek = "Today",
                                day = 8,
                                month = "Aug",
                                borderColor = Color.Red
                            )
                            DateBox(dayOfWeek = "Fri", day = 9, month = "Aug")
                            DateBox(dayOfWeek = "Sat", day = 10, month = "Aug")

                        }
                    }

                    //at it here ..
                    items(cinemas) { cinema ->
                        ExpandableCinemaView(cinema)
                    }
                }

                else -> {
                    item {
                        Text(
                            "Movie not found",
                            modifier = Modifier.padding(16.dp),
                            color = Color.White
                        )
                    }
                }
            }
        }


        // Animated Box at the middle of the screen
        AnimatedVisibility(
            visible = expanded,
            enter = slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(durationMillis = 300)
            ),
            exit = slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(durationMillis = 300)
            )
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .offset(y = halfScreenHeight) // Position box at middle of screen
                    .background(Color(0xFF292829), shape = RoundedCornerShape(20.dp))
                    .border(
                        1.dp,
                        Color.Black,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(16.dp)
            ) {
                Column {

                    Text(
                        text = "ALL Cinema",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 6.dp)
                    )

                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            Column {
                                cinemaItems.forEach { cinemaItem ->

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Icon(
                                            imageVector = Icons.Filled.LocationOn,
                                            contentDescription = "Location icon",
                                            tint = Color.Red,
                                            modifier = Modifier.padding(end = 8.dp)
                                        )

                                        Text(
                                            text = cinemaItem.location,
                                            color = Color.White,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold
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
}
