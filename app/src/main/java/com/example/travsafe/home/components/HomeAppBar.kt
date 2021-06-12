package com.example.travsafe.home.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeAppBar(
    title: String = "Title"
){
    TopAppBar(
        title = { Text(text = title)},
        elevation = 4.dp
    )
}

@Preview
@Composable
fun TopBarAppHome(){
    HomeAppBar(title = "This is the title")
}
