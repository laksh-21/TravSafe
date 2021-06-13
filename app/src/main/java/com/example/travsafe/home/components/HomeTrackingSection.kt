package com.example.travsafe.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeTrackingSection(
    modifier: Modifier = Modifier,
    travelling: Boolean,
    onTrackClick: () -> Unit
) {
    Card(
        modifier = Modifier.padding(start = 4.dp, end = 4.dp),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val trackingText = "Tracking"
            val notTrackingText = "Not Tracking"
            Text(
                text = if (travelling) trackingText else notTrackingText,
                modifier = Modifier.align(Alignment.CenterVertically),
                style = MaterialTheme.typography.h5
            )
            TravellingButton(
                travelling = travelling,
                onTrackClick = onTrackClick
            )
        }
    }
}

@Composable
fun TravellingButton(
    modifier: Modifier = Modifier,
    travelling: Boolean,
    onTrackClick: () -> Unit
) {
    val travellingColor = MaterialTheme.colors.primary
    val notTravellingColor = MaterialTheme.colors.secondary
    Button(
        modifier = modifier,
        onClick = onTrackClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = if (travelling) travellingColor else notTravellingColor),
    ) {
        val trackText = "Track"
        val stopTrackText = "Stop!"
        Text(text = if(travelling) stopTrackText else trackText)
    }
}

@Preview
@Composable
fun HomeTrackingSectionDemo() {
    HomeTrackingSection(
        travelling = true,
        onTrackClick = {}
    )
}