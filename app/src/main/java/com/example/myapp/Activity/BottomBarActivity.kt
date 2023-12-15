package com.example.myapp.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.Screens.Navigation
import com.example.myapp.Viewmodel.SneakersViewModel

class BottomBarActivity : ComponentActivity() {

    lateinit var sneakersViewModel: SneakersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sneakersViewModel = ViewModelProvider(this).get(SneakersViewModel::class.java)

        setContent {
            Navigation(sneakersViewModel.getSneakersData(), cartItems = sneakersViewModel.cartItems)
        }
    }

}