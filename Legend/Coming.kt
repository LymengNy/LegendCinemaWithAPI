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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.example.yujie.movie_module.MonthBox
import com.example.yujie.movie_module.composeTopBar
import kotlinx.coroutines.delay

@Composable
fun ComingSoonPage(vm: LegendViewModel, navController: NavController) {

    LaunchedEffect(Unit) {
        vm.getResultList()
    }

    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp.dp
    val halfScreenHeight = screenHeightDp / 3
    var expanded by remember { mutableStateOf(false) }

    val scrollState = rememberLazyListState()
    LaunchedEffect(scrollState) {
        while (true) {
            delay(5000) // Wait for 5 seconds
            val currentIndex = scrollState.firstVisibleItemIndex
            val lastIndex = vm.resultList.size - 1

            if (currentIndex < lastIndex) {
                // Scroll to the next item
                scrollState.animateScrollToItem(currentIndex + 1)
            } else {
                // Scroll back to the start
                scrollState.animateScrollToItem(0)
            }
        }
    }

    Scaffold(
        topBar = { composeTopBar(navController = navController, vm) },
        bottomBar = { ComposeBottomBar(navController = navController, vm) }
    ) { paddingValues ->
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
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "ALL Cinemas",
                                        color = Color.White,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.weight(1f)
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
                            LazyRow(
                                state = scrollState,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(500.dp)
                                    .padding(10.dp)
                            ) {
                                items(vm.resultList.take(8)) { element ->
                                    Box(
                                        modifier = Modifier
                                            .padding(end = 10.dp)
                                            .aspectRatio(3f / 4f)
                                            .clickable {
                                                navController.navigate("detail/${element.id}")
                                            }
                                    ) {
                                        Box(modifier = Modifier.fillMaxSize()) {
                                            Surface(
                                                modifier = Modifier.fillMaxSize(),
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
                                            Icon(
                                                imageVector = Icons.Default.PlayArrow,
                                                contentDescription = "Play",
                                                modifier = Modifier
                                                    .align(Alignment.Center)
                                                    .size(48.dp)
                                                    .background(
                                                        Color.Black.copy(alpha = 0.5f),
                                                        CircleShape
                                                    )
                                                    .padding(8.dp),
                                                tint = Color.White
                                            )
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(16.dp),
                                            contentAlignment = Alignment.BottomStart
                                        ) {
                                            Column {
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
                            Spacer(modifier = Modifier.height(16.dp))
                        }

                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(
                                            Color(0xFF292829),
                                            shape = RoundedCornerShape(70.dp)
                                        )
                                        .border(
                                            1.dp,
                                            Color.Black,
                                            shape = RoundedCornerShape(70.dp)
                                        )
                                        .padding(8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

                                    val nowShowingTextColor = if (currentRoute == "home") Color.Red else Color.White
                                    val comingSoonTextColor = if (currentRoute == "coming_soon") Color.Red else Color.White

                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(4.dp)
                                            .clickable { navController.navigate("home") },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "Now Showing",
                                            fontSize = 14.sp,
                                            color = nowShowingTextColor,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }

                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(4.dp)
                                            .clickable { navController.navigate("coming_soon") },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "Coming Soon",
                                            fontSize = 14.sp,
                                            color = comingSoonTextColor,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                MonthBox(month = "August")
                                MonthBox(month = "September")
                                MonthBox(month = "October")
                                MonthBox(month = "November")
                                MonthBox(month = "December")
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

                        // Reverse the list and then chunk it into rows
                        val reversedItems = vm.resultList.reversed()

                        items(reversedItems.chunked(2)) { rowItems ->
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
}
