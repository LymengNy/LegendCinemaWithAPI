package com.example.yujie.Legend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.yujie.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun User(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Profile", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    TextButton(onClick = { /* Handle Save action here */ }) {
                        Text("Save", color = Color.White, fontSize = 18.sp)
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)

                    .background(Color.Black)
            ) {
                // Profile Picture Section
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(24.dp)
                ) {
                    AsyncImage(
                        model = "https://cdn-icons-png.flaticon.com/512/10337/10337609.png", // Replace with your profile icon resource
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(Color.Gray)
                    )
                    IconButton(
                        onClick = { /* TODO: Implement profile picture change */ },
                        modifier = Modifier
                            .size(32.dp)
                            .align(Alignment.BottomEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CameraAlt, // Use a default icon or replace with a custom one
                            contentDescription = "Change Profile Picture",
                            tint = Color.White
                        )
                    }
                }
                Text(
                    text = "Set New Profile Picture",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Personal Information Section
                Text("Personal Information", color = Color.White, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = "NY",

                    onValueChange = {},
                    label = { Text("First Name", color = Color.White) },
                    leadingIcon = {
                        Icon(Icons.Default.Person, contentDescription = "First Name")
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = Color.White,

                        containerColor = Color.Transparent
                    ),
                    textStyle = TextStyle(color = Color.White),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = "LYMENG",
                    onValueChange = {},
                    label = { Text("Last Name", color = Color.White) },
                    leadingIcon = {
                        Icon(Icons.Default.Person, contentDescription = "Last Name")
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = Color.White,

                        containerColor = Color.Transparent
                    ),
                    textStyle = TextStyle(color = Color.White),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = "Ny lymeng",
                    onValueChange = {},
                    label = { Text("Username", color = Color.White) },
                    leadingIcon = {
                        Icon(Icons.Default.Person, contentDescription = "Username")
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = Color.White,

                        containerColor = Color.Transparent
                    ),
                    textStyle = TextStyle(color = Color.White),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = "10-10-2004",
                    onValueChange = {},
                    label = { Text("Date of Birth", color = Color.White) },
                    leadingIcon = {
                        Icon(Icons.Default.CalendarToday, contentDescription = "Date of Birth")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = Color.White,

                        containerColor = Color.Transparent
                    ),
                    textStyle = TextStyle(color = Color.White),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Contact Information Section
                Text("Contact Information", color = Color.White, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = "meng@gmail.com",
                    onValueChange = {},
                    label = { Text("Email Address", color = Color.White) },
                    leadingIcon = {
                        Icon(Icons.Default.Email, contentDescription = "Email")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = Color.White,

                        containerColor = Color.Transparent
                    ),
                    textStyle = TextStyle(color = Color.White),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = "85578522544",
                        onValueChange = {},
                        label = { Text("Phone Number", color = Color.White) },
                        leadingIcon = {
                            Icon(Icons.Default.Phone, contentDescription = "Phone")
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.Gray,
                            cursorColor = Color.White,

                            containerColor = Color.Transparent
                        ),
                        textStyle = TextStyle(color = Color.White),
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(onClick = { /* TODO: Handle Change Number */ }) {
                        Text("Change", color = MaterialTheme.colorScheme.error)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Delete Account Section
                TextButton(onClick = { /* TODO: Implement Delete Account */ }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text("Delete Account", color = Color.White)
                }
            }
        }
    )
}
