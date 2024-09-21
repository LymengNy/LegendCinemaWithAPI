package com.example.yujie.model

data class Cinema(
    val name: String,
    val movies: List<Movie>
)

data class Movie(
    val format: String,
    val language: List<String>,
    val showTimes: List<String>
)
val cinemas = listOf(
    Cinema(
        name = "Legend Olympia",
        movies = listOf(
            Movie(
                format = "2D",
                language = listOf("ENG", "KH"),
                showTimes = listOf("11:15 PM","1:00 PM","03:50 PM", "07:40 PM", "09:45 PM")
            )
        )
    ),
    Cinema(
        name = "Legend Eden Garden",
        movies = listOf(
            Movie(
                format = "2D",
                language = listOf("ENG", "KH"),
                showTimes = listOf("10:00 AM", "01:50 PM", "03:50 PM","07:50 PM")
            )
        )
    ),
    Cinema(
        name = "Legend K Mall",
        movies = listOf(
            Movie(
                format = "2D",
                language = listOf("ENG", "KH"),
                showTimes = listOf("10:30 AM", "01:50 PM","07:50 PM")
            )
        )
    ),
    Cinema(
        name = "Legend Meanchey",
        movies = listOf(
            Movie(
                format = "2D",
                language = listOf("ENG", "KH"),
                showTimes = listOf("10:00 AM", "01:50 PM", "03:50 PM","07:50 PM")
            )
        )
    ),
    Cinema(
        name = "Legend Midtown Mall",
        movies = listOf(
            Movie(
                format = "2D",
                language = listOf("ENG", "KH"),
                showTimes = listOf("10:00 AM", "01:50 PM", "03:50 PM","07:50 PM")
            )
        )
    ),
    Cinema(
        name = "Legend Noro Mall",
        movies = listOf(
            Movie(
                format = "2D",
                language = listOf("ENG", "KH"),
                showTimes = listOf("10:00 AM", "01:50 PM", "03:50 PM","07:50 PM")
            )
        )
    ),
    Cinema(
        name = "Legend Exchange Square",
        movies = listOf(
            Movie(
                format = "2D",
                language = listOf("ENG", "KH"),
                showTimes = listOf("11:00 AM", "12:50 PM", "01:50 PM","04:50 PM")
            )
        )
    ),
    Cinema(
        name = "Legend Siem Reap",
        movies = listOf(
            Movie(
                format = "2D",
                language = listOf("ENG", "KH"),
                showTimes = listOf("11:30 AM", "02:50 PM", "05:50 PM","06:20 PM")
            )
        )
    ),

)
