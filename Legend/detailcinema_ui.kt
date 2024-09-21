package com.example.yujie.Legend


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage
import com.example.yujie.model.cinemaItems
import com.example.yujie.movie_module.ComposeBottomBar
import com.example.yujie.movie_module.DateBox
import com.example.yujie.movie_module.composeTopBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailCinema(navController: NavController, location: String, vm: LegendViewModel) {

    // Trigger API call when the composable is launched
    LaunchedEffect(Unit) {
        vm.getResultList()  // Fetch movies when the screen opens
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
                        text = location,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black
                )
            )
        },

        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(paddingValues)
            ) {
                when {
                    vm.isLoading -> {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    vm.errorMessage.isNotEmpty() -> {
                        Text(
                            text = vm.errorMessage,
                            color = Color.Red,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    vm.resultList.isEmpty() -> {
                        Text(
                            text = "No results found",
                            color = Color.White,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    else -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            item {
                                AsyncImage(
                                    model = "https://coolbeans.sgp1.digitaloceanspaces.com/legend-cinema-prod/94e21faa-c816-4d90-90f5-cb5389a80f93.png",
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.Black.copy(alpha = 0.5f)),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            item {
                                // Now Showing and Coming Soon buttons
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 16.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .border(
                                                1.dp,
                                                Color.Black,
                                                shape = RoundedCornerShape(70.dp)
                                            )
                                            .padding(8.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

                                        val isShowingSelected = currentRoute?.startsWith("detail_cinema/") == true
                                        val isDetailSelected = currentRoute?.startsWith("de_cinema/") == true

                                        val showingTextColor = if (isShowingSelected) Color.White else Color.Gray
                                        val detailTextColor = if (isDetailSelected) Color.White else Color.Gray

                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .padding(4.dp)
                                                .clickable { navController.navigate("detail_cinema/$location") },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "Now Showing",
                                                fontSize = 14.sp,
                                                color = showingTextColor,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }

                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .padding(4.dp)
                                                .clickable { navController.navigate("de_cinema/$location") },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "Detail",
                                                fontSize = 14.sp,
                                                color = detailTextColor,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }

                                // DateBox row
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    DateBox(dayOfWeek = "Today", day = 8, month = "Aug")
                                    DateBox(dayOfWeek = "Fri", day = 9, month = "Aug")
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                Text(
                                    text = "ALL Showing",
                                    fontSize = 18.sp,
                                    color = Color.White,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 8.dp)
                                )
                            }

                            // Movie list with two columns per row
                            items(vm.resultList.chunked(2)) { rowItems ->
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    for (element in rowItems) {
                                        Column(
                                            modifier = Modifier
                                                .weight(1f)
                                                .padding(4.dp)
                                        ) {
                                            Surface(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clickable {
                                                        navController.navigate("detail/${element.id}")
                                                    },
                                                shape = RoundedCornerShape(8.dp),
                                                color = Color.LightGray
                                            ) {
                                                AsyncImage(
                                                    model = element.fullPosterPath(),
                                                    contentDescription = "Poster for ${element.title}",
                                                    modifier = Modifier.aspectRatio(3f / 4f),
                                                    contentScale = ContentScale.Crop
                                                )
                                            }

                                            Spacer(modifier = Modifier.height(8.dp))

                                            Text(
                                                text = element.releaseDate,
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                            Text(
                                                text = element.title,
                                                fontSize = 16.sp,
                                                color = Color.White
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
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DePage(navController: NavController, location: String, vm: LegendViewModel) {

    // Trigger API call when the composable is launched
    LaunchedEffect(Unit) {
        vm.getResultList()  // Fetch movies when the screen opens
    }

    // Find the cinema item with the matching location
    val selectedCinemaItem = cinemaItems.find { it.location == location }

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
                        text = location,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black
                )
            )
        },

        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(paddingValues)
            ) {
                when {
                    vm.isLoading -> {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    vm.errorMessage.isNotEmpty() -> {
                        Text(
                            text = vm.errorMessage,
                            color = Color.Red,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    selectedCinemaItem == null -> {
                        Text(
                            text = "No results found",
                            color = Color.White,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    else -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            item {
                                AsyncImage(
                                    model = selectedCinemaItem.imageUrl,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.Black.copy(alpha = 0.5f)),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            item {
                                // Now Showing and Coming Soon buttons
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 16.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .border(
                                                1.dp,
                                                Color.Black,
                                                shape = RoundedCornerShape(70.dp)
                                            )
                                            .padding(8.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

                                        val isShowingSelected = currentRoute?.startsWith("detail_cinema/") == true
                                        val isDetailSelected = currentRoute?.startsWith("de_cinema/") == true

                                        val showingTextColor = if (isShowingSelected) Color.White else Color.Gray
                                        val detailTextColor = if (isDetailSelected) Color.White else Color.Gray

                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .padding(4.dp)
                                                .clickable { navController.navigate("detail_cinema/${location}") },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "Now Showing",
                                                fontSize = 14.sp,
                                                color = showingTextColor,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }

                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .padding(4.dp)
                                                .clickable { navController.navigate("de_cinema/${location}") },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "Detail",
                                                fontSize = 14.sp,
                                                color = detailTextColor,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }
                            }

                            item {
                                selectedCinemaItem?.let { item ->
                                    Column {
                                        Text(text = "Number of Halls", color = Color.Gray, fontSize = 20.sp)
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(text =  "${item.number}", color = Color.White, fontSize = 20.sp)
                                        Spacer(modifier = Modifier.height(15.dp))
                                        Text(text = "Opening Hour", color = Color.Gray, fontSize = 20.sp)
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(text = item.time, color = Color.White, fontSize = 20.sp)
                                        Spacer(modifier = Modifier.height(15.dp))
                                        Text(text = "Address", color = Color.Gray, fontSize = 20.sp)
                                        Spacer(modifier = Modifier.height(10.dp))
                                        Text(text = item.address, color = Color.White, fontSize = 20.sp)
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
