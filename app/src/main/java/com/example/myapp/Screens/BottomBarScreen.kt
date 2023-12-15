package com.example.myapp.Screens

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapp.BottomBarDestinations
import com.example.myapp.DataClass.Sneakers
import com.example.myapp.DetailsScreenDestination
import com.example.myapp.ui.Activity.White


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Navigation(data: List<Sneakers>, cartItems: MutableList<Sneakers>) {

    val navController = rememberNavController()
    val items = listOf(BottomBarDestinations.Home, BottomBarDestinations.Cart)

    Scaffold(topBar = {}, bottomBar = {
        BottomNavigation(backgroundColor = White) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            items.forEach {
                BottomNavigationItem(selected = currentRoute == it.route,
                    icon = {
                        Icon(imageVector = it.icons, contentDescription = "")
                    },
                    onClick = {
                        if (currentRoute != it.route) {
                            navController.graph?.startDestinationRoute?.let {
                                navController.popBackStack(it, true)
                            }

                            navController.navigate(it.route) {
                                launchSingleTop = true
                            }
                        }
                    }
                )
            }

        }
    }
    ) {
        NavigationController(navController = navController, data, cartItems)

    }

}


@Composable
fun NavigationController(
    navController: NavHostController,
    data: List<Sneakers>, cartItems: MutableList<Sneakers>
) {
    NavHost(navController = navController, startDestination = BottomBarDestinations.Home.route) {
        composable(BottomBarDestinations.Home.route) {
            SneakersScreen(navController)

        }
        composable(BottomBarDestinations.Cart.route) {
            SneakersCartScreen(data, cartItems, navController)

        }
        composable(DetailsScreenDestination.DetailScreen.route) {
            SneakerDetailsScreen(sneaker = data[0], cartItems, navController)

        }


    }
}


