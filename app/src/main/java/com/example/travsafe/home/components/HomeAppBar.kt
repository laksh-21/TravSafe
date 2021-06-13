package com.example.travsafe.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeAppBar(
    modifier: Modifier = Modifier,
    title: String = "Title",
    actions: @Composable RowScope.() -> Unit = {}
){
    TopAppBar(
        modifier = modifier,
        title = {
            Column(
                // so the column fills the whole slot to center the text in
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = title)
            }
        },
        actions = actions,
        elevation = 4.dp
    )
}

@Preview
@Composable
fun TopBarAppHome(){
    HomeAppBar(title = "This is the title")
}
