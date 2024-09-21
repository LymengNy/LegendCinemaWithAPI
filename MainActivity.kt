package com.example.yujie



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.yujie.JaneShop.ShopScaffold
import com.example.yujie.JaneShop.ShopViewModel

import com.example.yujie.Legend.LegendViewModel
import com.example.yujie.Major.MajorScaffold
import com.example.yujie.Major.MajorViewModel
import com.example.yujie.ecommerce.CartPage
import com.example.yujie.ecommerce.CartViewModel
import com.example.yujie.ecommerce.DeliveryPage
import com.example.yujie.ecommerce.FavoritePage
import com.example.yujie.ecommerce.FavoriteViewModel
import com.example.yujie.ecommerce.FirstPage


import com.example.yujie.movie_module.LegendScaffold
import com.example.yujie.screens.FoodViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AsyncApp()
        }
    }
}




@Preview(showSystemUi = true)
@Composable
fun AsyncApp() {
    // Create a mock LegendViewModel for preview purposes
    val vm = LegendViewModel()
    // Create a NavHostController
    val navController = rememberNavController()
    // Call LegendScaffold with these parameters
    LegendScaffold(vm, navController, vm)
}





