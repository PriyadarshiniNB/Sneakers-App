package com.example.myapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarDestinations(val route: String, val icons:ImageVector) {
    object Home : BottomBarDestinations("home",Icons.Filled.Home)
    object Cart : BottomBarDestinations("cart", Icons.Filled.ShoppingCart)
    // Add more destinations as needed
}

sealed class DetailsScreenDestination(val route:String){
    object DetailScreen : DetailsScreenDestination("details")
}