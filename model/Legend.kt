package com.example.yujie.model

data class CinemaItem(
    val imageUrl: String,
    val location: String,
    val title: String,
    val address: String,
    val time: String,
    val number:Int

)

val cinemaItems = listOf(
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000009",
        location = "Legend K Mall",
        title = "2nd floor, K Mall",
        address="Veng Sreng Blvd",
        time="09:30 - 22:30",
        number=5
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000006",
        location = "Legend Meanchey",
        title = "3rd Floor of New Steung Mean Chey market",
        address="Veng Sreng Blvd , Sangkat Steung Mean Chey, Khan Mean Chey",
        time="09:30 - 22:30",
        number=5
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000008",
        location = "Legend Midtown Mall",
        title = "1st Floor Midtown Mall",
        address="St. 2004 Corner 13B",
        time="09:30 - 22:30",
        number=4
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000013",
        location = "Legend Chipmong 271 ",
        title = "3rd Floor, Chip Mong Mega Mall",
        address="St271, Phum Prek Ta Nu, Sangkat Chak Angrae Leu, Khan Mean Chey",
        time="09:30 - 22:30",
        number=7
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000011",
        location = "Legend Olympia",
        title = "6th Floor,The Olympia Mall",
        address="Monireth Blvd(217),Sangkat Veal Vong Khan 7 Makara",
        time="09:30 - 22:30",
        number=7
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000014",
        location = "Legend Eden",
        title = "City Center Boulevard, Sangkat Srah Chak",
        address="Khan Daun Penh,\n",
        time="09:30 - 22:30",
        number=8
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000007",
        location = "Legend Noro Mall",
        title = "5th floor, Chip Mong Noro Mall",
        address="Preah Norodom Blvd (41)",
        time="09:30 - 22:30",
        number=3
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000004",
        location = "Legend Toul Kork",
        title = "TK Avenue Mall, Street 315",
        address="Sangkat Beongkok 1, Khan Toul Kork",
        time="09:30 - 22:30",
        number=3
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000005",
        location = "Legend Exchange Square",
        title = "Street 106, Corner of Street 61",
        address="Sangkat Wat Phnom",
        time="09:30 - 22:30",
        number=4
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000010",
        location = "Legend SenSok",
        title = "4th Floor, Chip Mong SenSok Mal",
        address="Okhna Mong Reththey street, Khan Sen Sok",
        time="09:30 - 22:30",
        number=5
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000012",
        location = "Legend Cinema Sihanoukville",
        title = "PGB-5-021, 4th Floor of Prince",
        address="PGB-5-021, 4th Floor of Prince ,Sihanoukville\n",
        time="09:30 - 22:30",
        number=4
    ),
    CinemaItem(
        imageUrl = "https://tickets.legend.com.kh/CDN/media/entity/get/CinemaGallery/0000000001",
        location = "Legend Siem Reap",
        title = "Level 3, The Heritage Walk, Corner of National Road 6 and Oum Chhay Street",
        address="Svay Dongkoum Commune, Krong Siem Reap",
        time="09:30 - 22:30",
        number=5
    )
)
