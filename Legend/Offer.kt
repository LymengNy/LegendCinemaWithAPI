package com.example.yujie.Legend

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.yujie.model.OfferItem
import com.example.yujie.model.OfferItems
import com.example.yujie.movie_module.ComposeBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferPage(navController: NavHostController, offerItems: List<OfferItem>,vm: LegendViewModel) {
    Scaffold(
        bottomBar = { ComposeBottomBar(navController = navController, vm=vm)} ,
        topBar = {
            TopAppBar(
                title = { Text("Offer Page", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                )
            )
        },



        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color.Black)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.5f))
                ) {
                    item {
                        AsyncImage(
                            model = "https://coolbeans.sgp1.digitaloceanspaces.com/legend-cinema-prod/643b9a61-bee9-4b02-86b9-5eb6c3765bf7.jpeg",
                            contentDescription = "FB Page Image",
                            modifier = Modifier
                                .height(200.dp)
                                .width(500.dp)
//                                .align(Alignment.CenterHorizontally)
                        )



                        Text(
                            text = "Choose Cinema",
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier
//                                .align(Alignment.Start)
                                .padding(start = 10.dp)
                        )
                    }

                    items(offerItems) { offerItem ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                                .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
                                .background(Color.Black)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp)
                                        .background(Color.Gray, RoundedCornerShape(8.dp))
                                ) {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data(offerItem.imageUrl)
                                            .crossfade(true)
                                            .build(),
                                        contentDescription = "Movie Image",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .padding(top = 8.dp)
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = offerItem.title,
                                        fontSize = 20.sp,
                                        color = Color.White
                                    )

                                }
                            }
                        }
                    }
                }
            }
        }
    )
}
