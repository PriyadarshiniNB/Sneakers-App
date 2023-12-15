package com.example.myapp.Screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.DataClass.Sneakers
import com.example.myapp.DetailsScreenDestination
import com.example.myapp.R
import com.example.myapp.ui.Activity.MyAppTheme
import com.example.myapp.ui.Activity.Pink
import com.example.myapp.ui.Activity.White
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun SneakersScreen(navController: NavController) {

    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context, "SampleData.json")
    val gson = Gson()
    val gridSampleType: Type = object : TypeToken<List<Sneakers>>() {}.type
    val sneakersData: List<Sneakers> =
        gson.fromJson(dataFileString, gridSampleType) as List<Sneakers>



    MyAppTheme {
        Scaffold(
            topBar = {
                DefaultAppBar()
            }
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Headers()
                Spacer(modifier = Modifier.height(8.dp))
                gridView(sneakersData, navController)

            }

        }
    }
}

@Composable
fun gridView(sneakersData: List<Sneakers>, navController: NavController) {
    LazyVerticalGrid(
        GridCells.Fixed(2),
        modifier = Modifier.padding(10.dp)
    ) {
        items(100) { index ->
            var sneakers = sneakersData[index % sneakersData.size]

            SampleDataGridItem(data = sneakers, navController = navController)

        }

    }

}

@Composable
fun SampleDataGridItem(data: Sneakers, navController: NavController) {
    Card(
        modifier = Modifier
            .clickable {
                navController.graph?.startDestinationRoute?.let {
                    navController.popBackStack(it, true)
                }

                navController.navigate(DetailsScreenDestination.DetailScreen.route) {
                    launchSingleTop = true
                }


            }
            .padding(10.dp)
            .fillMaxSize(),
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp)

    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(id = R.drawable.shoe),
                contentDescription = "Sneaker Image",
                modifier = Modifier
                    .size(120.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.padding(3.dp))

            Text(
                text = data.name,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "$ ${data.retailPrice}",
                color = Pink
            )


        }
    }

}


fun getJsonDataFromAsset(context: Context, data: String): String {
    return context.assets.open(data).bufferedReader().use { it.readText() }
}

@Composable
fun DefaultAppBar() {
    TopAppBar(
        backgroundColor = White,
        title = {
            Text(
                text = "SNEAKERSHIP",
                color = Pink,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Magenta
                )
            }
        }
    )
}

@Composable
fun Headers() {
    Row(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Popular",
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            color = Color.Black,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h5
        )
        Row(
            modifier = Modifier
                .padding(end = 16.dp)
        ) {
            Text(text = "Sort by", color = Color.Gray)
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = "DownArrow Icon",
                tint = Color.Gray
            )
        }
    }
}





