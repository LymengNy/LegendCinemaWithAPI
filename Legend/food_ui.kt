package com.example.yujie.Legend

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.BlurEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.yujie.R
import com.example.yujie.model.CinemaItem
import com.example.yujie.model.FoodItems
import com.example.yujie.model.foodItem
import com.example.yujie.movie_module.ComposeBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FBPage(navController: NavHostController, cinemaItems: List<CinemaItem>,vm: LegendViewModel) {
    Scaffold(
        bottomBar = { ComposeBottomBar(navController = navController, vm=vm)} ,
        topBar = {
            TopAppBar(
                title = { Text("FB Page", color = Color.White) },
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
            ) {
                // Background Image with blur effect
                AsyncImage(
                    model = "https://coolbeans.sgp1.digitaloceanspaces.com/legend-cinema-prod/40de4c72-907a-4120-b70a-cb475690f888.jpeg",
                    contentDescription = "Background Image",
                    modifier = Modifier
                        .height(800.dp)
                        .width(600.dp)
                        .graphicsLayer {
                            renderEffect = BlurEffect(radiusX = 80f, radiusY = 100f)
                        },
                    contentScale = ContentScale.Crop
                )

                // Overlay content
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.5f))
                ) {
                    AsyncImage(
                        model = "https://coolbeans.sgp1.digitaloceanspaces.com/legend-cinema-prod/40de4c72-907a-4120-b70a-cb475690f888.jpeg",
                        contentDescription = "FB Page Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Choose Cinema",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = 10.dp)
                    )

                    // List of FoodItems
                    LazyColumn {
                        items(cinemaItems) { cinemaItem ->
                            CinItem(cinemaItem = cinemaItem,navController = navController)
                        }
                    }
                }
            }
        }
    )
}
@Composable
fun CinItem(cinemaItem: CinemaItem,navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp) // Optional: Add padding around th
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable {
                navController.navigate("food")
            }// Add border
    ) {
        AsyncImage(
            model = cinemaItem.imageUrl,
            contentDescription = cinemaItem.title,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp))
                .padding(start = 10.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp) // Add padding between image and text
                .align(Alignment.CenterVertically) // Align text vertically in the center
        ) {
            Text(
                text = cinemaItem.location,
                color = Color.White,
                fontSize = 18.sp
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Filled.ArrowForwardIos,
            contentDescription = "Location icon",
            tint = Color.White,
            modifier = Modifier
                .padding(start = 20.dp, end = 10.dp)
                .align(Alignment.CenterVertically)
        // Align icon vertically in the center
        )
    }
}

//second
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodPage(
    navController: NavHostController,
    FoodItems: List<foodItem>
) {
    var addedItems by remember { mutableStateOf<List<foodItem>>(emptyList()) }

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
                        text = "F&B",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black
                )
            )
        },
        bottomBar = {
            ButtonItem(addedItems = addedItems)
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                // Background Image with blur effect
                AsyncImage(
                    model = "https://coolbeans.sgp1.digitaloceanspaces.com/legend-cinema-prod/40de4c72-907a-4120-b70a-cb475690f888.jpeg",
                    contentDescription = "Background Image",
                    modifier = Modifier
                        .height(800.dp)
                        .width(600.dp)
                        .graphicsLayer {
                            renderEffect = BlurEffect(radiusX = 80f, radiusY = 100f)
                        },
                    contentScale = ContentScale.Crop
                )

                // Overlay content
                 Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.5f))
                ){
                    AsyncImage(
                        model = "https://coolbeans.sgp1.digitaloceanspaces.com/legend-cinema-prod/40de4c72-907a-4120-b70a-cb475690f888.jpeg",
                        contentDescription = "FB Page Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    )



                    // List of FoodItems
                    LazyColumn {
                        items(FoodItems) { foodItem ->
                            Food(
                                foodItem = foodItem,
                                addedItems = addedItems,
                                onAddClick = { item ->
                                    addedItems = addedItems + item
                                },
                                onRemoveClick = { item ->
                                    addedItems = addedItems - item
                                }
                            )
                        }
                    }
                }
            }
        }
    )

}


@Composable
fun Food(
    foodItem: foodItem,
    addedItems: List<foodItem>,
    onAddClick: (foodItem) -> Unit,
    onRemoveClick: (foodItem) -> Unit
) {
    var showRemove by remember { mutableStateOf(false) }
    var itemQuantity by remember { mutableStateOf(0) }

    // Calculate the current quantity of the item in the cart
    itemQuantity = addedItems.count { it == foodItem }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        AsyncImage(
            model = foodItem.imageUrl,
            contentDescription = foodItem.Set,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(20.dp))
                .padding(10.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = foodItem.Set,
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Text(
                text = "$${foodItem.Price}",
                color = Color.Red,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.background(Color.Red.copy(alpha = 0.5f), CircleShape)



        ) {
            if (showRemove && itemQuantity > 0) {
                Icon(
                    imageVector = Icons.Filled.Remove,
                    contentDescription = "Remove icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(48.dp)

                        .padding(12.dp)
                        .clickable {
                            onRemoveClick(foodItem)
                            if (itemQuantity == 1) showRemove = false
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            // Display item quantity if the "Remove" icon is shown
            if (showRemove) {
                Text(
                    text = itemQuantity.toString(),
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(Alignment.CenterVertically)
                )
            }

            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add icon",
                tint = Color.White,
                modifier = Modifier
                    .size(48.dp)

                    .padding(12.dp)
                    .clickable {
                        onAddClick(foodItem)
                        showRemove = true
                    }
            )
        }
    }
}

@Composable
fun ButtonItem(addedItems: List<foodItem>) {
    val totalQuantity = addedItems.size
    val totalPrice = addedItems.sumOf { it.Price.toDouble() }

    BottomAppBar(
        containerColor = Color.Black
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Box with border and specified height around totalQuantity
            Box(
                modifier = Modifier
                    .border(2.dp, Color.White)
                    .fillMaxHeight()
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .wrapContentWidth()
            ) {
                Text(
                    text = "$totalQuantity",
                    color = Color.Red,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Column for Total Price with labels
            Column {
                Text(
                    text = "Summary",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    text = "\$${"%.2f".format(totalPrice)}",
                    color = Color.White,
                    fontSize = 20.sp
                )

            }
            Icon(
                Icons.Default.KeyboardArrowDown,
                contentDescription = "Location icon",
                tint = Color.White,
                modifier = Modifier.padding(start = 20.dp)
            )

            Spacer(modifier = Modifier.weight(1f)) // Push "Continue" button to the end


            Box(
                modifier = Modifier
                    .background(Color.Red.copy(alpha = 0.5f), CircleShape)
                    .padding(14.dp)
            ) {
                Text(text = "Continue", color = Color.White)
            }
        }
    }
}

//third
