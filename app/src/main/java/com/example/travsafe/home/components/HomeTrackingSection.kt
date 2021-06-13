package com.example.travsafe.home.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeTrackingSection(
    modifier: Modifier = Modifier,
    travelling: Boolean,
    onClick: () -> Unit
) {
    TravellingButton(
        travelling = travelling,
        onClick = onClick
    )
}

@Composable
fun TravellingButton(
    modifier: Modifier = Modifier,
    travelling: Boolean,
    onClick: () -> Unit
) {
    val travellingColor = MaterialTheme.colors.primary
    val notTravellingColor = MaterialTheme.colors.secondary
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = if (travelling) travellingColor else notTravellingColor),
    ) {
        Text(text = "I'm Travelling")
    }
}

@Preview
@Composable
fun HomeTrackingSectionDemo() {
    HomeTrackingSection(
        travelling = true,
        onClick = {}
    )
}