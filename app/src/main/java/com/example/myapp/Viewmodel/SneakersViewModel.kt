package com.example.myapp.Viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapp.DataClass.Sneakers


class SneakersViewModel: ViewModel()  {
    var cartItems = mutableListOf<Sneakers>()

    fun getSneakersData() : List<Sneakers>{

        return listOf(
            Sneakers(
                brand = "nike",
                colorway = "Red",
                relaeseDate = "2022-12-15",
                retailPrice = 100,
                shoe = "",
                styleId = "123",
                title = "",
                id = "",
                gender = "male",
                media = Sneakers.Media(),
                year = 2021,
                name = "nic"


            ),
            Sneakers(
                brand = "nike",
                colorway = "Red",
                relaeseDate = "2022-12-15",
                retailPrice = 100,
                shoe = "",
                styleId = "123",
                title = "",
                id = "",
                gender = "male",
                media = Sneakers.Media(),
                year = 2021,
                name = "nic"

            )
        )
    }

}
