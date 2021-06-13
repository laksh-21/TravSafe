package com.example.travsafe.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import com.example.travsafe.home.components.HomeAppBar

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Scaffold(
                    topBar = {
                        HomeAppBar("Title here boi")
                    }
                ){
                    Text(text = "Hello!")
                }
            }
        }
    }
}