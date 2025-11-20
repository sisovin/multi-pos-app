package com.example.multipos.data.repository

import com.example.multipos.data.model.Product

object ProductRepository {
    val products = listOf(
        Product(1, "កែកប៊ឺរី", 12.00, "Delicious berry cake with fresh ingredients."), // Berry Cake
        Product(2, "ផ្លែប៉ោម", 8.00, "Fresh red apples from the farm."), // Apple
        Product(3, "តែខ្មៅ", 10.00, "Premium black tea leaves."), // Black Tea
        Product(4, "គ្រាប់ឈើកាស្យូ", 25.00, "Roasted cashew nuts, salted.") // Cashew Nuts
    )

    fun getProductById(id: Int): Product? {
        return products.find { it.id == id }
    }
}
