package com.example.yujie.Legend

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.yujie.model.Cinema
import com.example.yujie.model.cinemas
import okhttp3.internal.wait

//@Composable
//fun NowShowingPage(navController: NavHostController) {
//    Scaffold(
//        topBar = { Text("Now Showing") }
//    ) { paddingValues ->
//        LazyColumn(contentPadding = paddingValues) {
//            items(cinemas) { cinema ->
//                ExpandableCinemaView(cinema)
//            }
//        }
//    }
//}
@Composable
fun ExpandableCinemaView(cinema: Cinema) {
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically // Aligns text and icon vertically centered
        ) {
            Text(
                text = cinema.name,
                fontSize = 25.sp,
                color = Color.White,
                modifier = Modifier.weight(1f) // Take up the remaining space
            )
            Icon(
                imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = if (expanded) "Collapse" else "Expand",
                tint = Color.White
            )
        }
        AnimatedVisibility(visible = expanded) {
            Column {
                cinema.movies.forEach { movie ->
                    Text(
                        text = " ${movie.format}",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    Text(
                        text = " ${movie.language.joinToString("|")}",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                        movie.showTimes.forEach { time ->
                            ShowTimeChip(time = time)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ShowTimeChip(time: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(20.dp))
            .border(1.dp, Color.White, RoundedCornerShape(20.dp))

 ) {
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(100.dp)
//               .padding(horizontal = 10.dp, vertical = 4.dp)
                .background(Color(0xFF292829), shape = RoundedCornerShape(20.dp))

        ) {
            Text(
                text = time, fontSize = 16.sp, color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}



