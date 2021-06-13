package com.example.travsafe.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    // for when the user clicks if they're travelling or not
    val isUserTravelling: MutableState<Boolean> = mutableStateOf(false)

    fun onUserTravellingChanged(){
        isUserTravelling.value = !isUserTravelling.value
    }
}