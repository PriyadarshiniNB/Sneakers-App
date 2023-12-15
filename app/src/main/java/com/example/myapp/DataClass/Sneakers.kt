package com.example.myapp.DataClass

data class Sneakers(
    var id: String,
    var brand: String,
    var colorway: String,
    val gender: String,
    var media: Media = Media(),
    var relaeseDate: String,
    var retailPrice: Int,
    var styleId: String,
    var shoe: String,
    var name: String,
    var title: String,
    var year: Int

) {
    data class Media(
        val imageUrl: String = "",
        val smallImageUrl: String = "",
        val thumbUrl: String = ""

    )
}