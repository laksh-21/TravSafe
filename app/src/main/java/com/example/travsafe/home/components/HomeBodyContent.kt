package com.example.travsafe.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeBodyContent(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit
){
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        TravellingButton(
            selected = selected,
            onClick = onClick
        )
    }
}

@Composable
fun TravellingButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit
){
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = if (selected) Color.Blue else Color.Gray)
    ){
          Text(text = "I'm Travelling")
    }
}

@Preview
@Composable
fun TravellingButtonSelected(){
    TravellingButton(selected = true, onClick = {})
}

@Preview
@Composable
fun TravellingButtonDeselected(){
    TravellingButton(selected = false, onClick = {})
}