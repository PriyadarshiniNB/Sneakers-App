package com.example.myapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapp.BottomBarDestinations
import com.example.myapp.DataClass.Sneakers
import com.example.myapp.ui.Activity.Pink


@Composable
fun SneakersCartScreen(
    data: List<Sneakers>,
    cartItems: MutableList<Sneakers>,
    navHostController: NavHostController

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopAppBar(backgroundColor = Color.White,
            title = {
                Text(
                    text = "Cart",
                    Modifier.background(Color.White),
                    color = Pink,
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    if (navHostController.backQueue.size > 2)
                        navHostController.popBackStack()
                    else
                        navHostController.navigate(BottomBarDestinations.Home.route)

                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display each item in the cart with an option to remove it
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            item {

                for (item in cartItems) {
                    CartItem(item, onRemoveFromCart = { removedItem ->
                        // Remove the item from the cart
                        cartItems.remove(removedItem)
                    }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }





                Column(modifier = Modifier.fillMaxSize()) {

                    if (cartItems.size > 0) {
                        Text(
                            text = "Order details:",
                            style = MaterialTheme.typography.h6,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "Subtotal: $${data.sumBy { it.retailPrice }}",
                            style = MaterialTheme.typography.body1,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Taxes and Charges: $40",
                            style = MaterialTheme.typography.body1,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        Row(Modifier.fillMaxWidth()) {
                            Text(
                                text = "Total :", style = MaterialTheme.typography.body1,
                                color = Color.Gray
                            )
                            Text(
                                text = "$438", style = MaterialTheme.typography.h6,
                                color = Pink, fontWeight = FontWeight.Bold
                            )

                            Box(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .background(color = Pink)
                            ) {
                                Text(
                                    text = "$ Check Out",
                                    color = Color.White,
                                    modifier = Modifier.padding(20.dp),
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.body1
                                )
                            }
                        }
                    } else {
                        Text(text = "Please add items to cart")
                    }
                }
            }
        }
    }
}


@Composable
fun CartItem(item: Sneakers, onRemoveFromCart: (Sneakers) -> Unit) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp)

    )
    {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id = com.example.myapp.R.drawable.shoe), // Replace with actual image resource
                contentDescription = "Sneaker Image",
                modifier = Modifier
                    .size(60.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop
            )


            Spacer(modifier = Modifier.width(16.dp))


            Column {
                Text(text = item.name, style = MaterialTheme.typography.h6)
                Text(text = "Price: $${item.retailPrice}", style = MaterialTheme.typography.body1)
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = {
                onRemoveFromCart(item)
            }, modifier = Modifier.align(Alignment.Top)) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "Remove from Cart")
            }
        }
    }
}
