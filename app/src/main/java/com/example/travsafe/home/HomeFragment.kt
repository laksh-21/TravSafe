package com.example.travsafe.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.example.travsafe.home.components.HomeAppBar
import com.example.travsafe.home.components.HomeGreetingSection
import com.example.travsafe.home.components.HomeTrackingSection

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    @ExperimentalAnimationApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Scaffold(
                    topBar = {
                        HomeAppBar(title ="Home")
                    }
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .verticalScroll(rememberScrollState())
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        // all the content of the screen goes here
                        //Greeting Section
                        HomeGreetingSection()
                        Spacer(modifier = Modifier.height(16.dp))
                        //Tracking Section
                        val travelling = viewModel.isUserTravelling.value
                        HomeTrackingSection(
                            travelling = travelling,
                            onTrackClick = { viewModel.onUserTravellingChanged() }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        // Contacts Section

                    }
                }
            }
        }
    }
}