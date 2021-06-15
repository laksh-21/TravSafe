package com.example.travsafe.home.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun HomeTrackingSection(
    modifier: Modifier = Modifier,
    travelling: Boolean,
    onTrackClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Tracking",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
        )
        Spacer(modifier = Modifier.height(8.dp))
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
        AnimatedVisibility (
            travelling
        ) {
            UnsafeButton(onUnsafeClick = {})
        }
    }
}

@Composable
fun UnsafeButton(
    onUnsafeClick: () -> Unit,
){
    Button(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 8.dp,
            pressedElevation = 6.dp,
        ),
        onClick = onUnsafeClick
    ) {
        Text(
            text = "I feel unsafe!",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
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

@ExperimentalAnimationApi
@Preview
@Composable
fun HomeTrackingSectionDemo() {
    HomeTrackingSection(
        travelling = true,
        onTrackClick = {}
    )
}