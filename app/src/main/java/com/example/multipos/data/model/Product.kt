package com.example.multipos.data.model

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String = "No description available",
    val imageResId: Int = 0,
    val categoryId: Int = 1
)
