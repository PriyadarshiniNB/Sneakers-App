package com.example.myapp.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
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
import com.example.myapp.R
import com.example.myapp.ui.Activity.Pink
import com.example.myapp.ui.Activity.White

@Composable
fun SneakerDetailsScreen(
    sneaker: Sneakers,
    cartItems: MutableList<Sneakers>,
    navHostController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            IconButton(onClick = {
                if (navHostController.backQueue.size > 2)
                    navHostController.popBackStack()
                else
                    navHostController.navigate(BottomBarDestinations.Home.route)
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.shoe),
                contentDescription = "Sneaker Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                backgroundColor = Color.White,
                elevation = 16.dp,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                ) {
                    Text(
                        text = "Name: ${sneaker.name}",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                    )
                    Text(
                        text = "sed ut perspiciatis omnis iste natus error",
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Column() {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Size(UK) :",
                                style = MaterialTheme.typography.body1,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .background(Color.Gray)
                                    .padding(8.dp)
                                    .size(20.dp)
                            ) {
                                Text(text = "7", color = Pink)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .background(Color.Red)
                                    .padding(8.dp)
                                    .size(20.dp)
                            ) {
                                Text(text = "8", color = Color.White)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .background(Color.Gray)
                                    .padding(8.dp)
                                    .size(20.dp)
                            ) {
                                Text(text = "9", color = Pink)
                            }
                        }
                        Spacer(modifier = Modifier.height(25.dp))
                        Row(
                            modifier = Modifier
                                .padding(bottom = 20.dp)
                                .fillMaxWidth()
                        ) {

                            Text(
                                text = "Colour   :",
                                color = Color.Gray,
                                style = MaterialTheme.typography.body1
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Box(
                                modifier = Modifier
                                    .background(Color.Red)
                                    .size(30.dp)
                                    .padding(20.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Box(
                                modifier = Modifier
                                    .background(Color.Blue)
                                    .size(30.dp)
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "check",
                                    tint = White
                                )

                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Box(
                                modifier = Modifier
                                    .background(Color.Cyan)
                                    .size(30.dp)
                                    .padding(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))


                        }
                        Spacer(modifier = Modifier.height(20.dp))


                        Row() {
                            Text(
                                text = "Price :",
                                color = Color.Gray,
                                style = MaterialTheme.typography.body1
                            )
                            Text(
                                text = "$ ${sneaker.retailPrice}",
                                modifier = Modifier.padding(end = 8.dp),
                                color = Color.Gray,
                                style = MaterialTheme.typography.body1
                            )
                            Button(
                                onClick = {
                                    // Add the selected sneaker to the cart
                                    cartItems.add(sneaker)


                                },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Add to Cart",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.body1
                                )
                            }

                        }

                    }


                }


            }
        }
    }
}


