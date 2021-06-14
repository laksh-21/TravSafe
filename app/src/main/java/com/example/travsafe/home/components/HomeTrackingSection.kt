package com.example.travsafe.home.components

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeTrackingSection(
    modifier: Modifier = Modifier,
    travelling: Boolean,
    onTrackClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 8.dp
    ) {
        CardContent(
            travelling = travelling,
            onTrackClick = onTrackClick
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    if (travelling) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 8.dp,
                pressedElevation = 6.dp,
            ),
            onClick = {}
        ) {
            Text(
                text = "I feel unsafe!",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun CardContent(
    travelling: Boolean,
    onTrackClick: () -> Unit
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

@Composable
fun TravellingButton(
    modifier: Modifier = Modifier,
    travelling: Boolean,
    onTrackClick: () -> Unit
) {
    val travellingColor = MaterialTheme.colors.primary
    val notTravellingColor = MaterialTheme.colors.secondary
    val backgroundColor by animateColorAsState(if (travelling) travellingColor else notTravellingColor)
    Button(
        modifier = modifier.animateContentSize(
            animationSpec = tween(durationMillis = 500, easing = FastOutLinearInEasing)
        ),
        onClick = onTrackClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
    ) {
        val trackText = "Track"
        val stopTrackText = "Stop!"
        Text(text = if (travelling) stopTrackText else trackText)
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