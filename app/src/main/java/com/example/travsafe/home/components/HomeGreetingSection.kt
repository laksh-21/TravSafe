package com.example.travsafe.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeGreetingSection(){
    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        Column {
            Text(
                text = "Hello,",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "We only track you when you want us to.",
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
@Preview
fun GreetingDemo(){
    HomeGreetingSection()
}