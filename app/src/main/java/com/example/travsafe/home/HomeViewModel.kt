package com.example.travsafe.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    val isUserTravelling: MutableState<Boolean> = mutableStateOf(true)

    fun onUserTravellingChanged(){
        isUserTravelling.value = !isUserTravelling.value
    }
}