package com.example.yujie.model



data class foodItem(
    val imageUrl: String,
    val Set: String,
    val Price: Float
)

val FoodItems = listOf(
    foodItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/Concessions/97101",
        Set = "Combo 1",
        Price = 5.00f
    ),
    foodItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/Concessions/97102",
        Set = "Combo 2",
        Price = 4.50f
    ),
    foodItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/Concessions/97103",
        Set = "Combo 3",
        Price = 4.80f
    ),
    foodItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/Concessions/97104",
        Set = "Combo 4",
        Price = 5.50f
    ),
    foodItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/Concessions/97105",
        Set = "Combo 5",
        Price = 6.50f
    ),
    foodItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/Concessions/97106",
        Set = "Combo 6",
        Price = 6.50f
    )
)






