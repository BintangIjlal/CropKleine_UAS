package com.pnj.cropexchange.farmer

data class Farmer(
    val farmerId: String,
    val name: String,
    val location: String,
    val product: String,
    val imageUrl: String? // Optional field for storing the URL of the farmer's product image
)
