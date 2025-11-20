package com.example.multipos.data.repository

import com.example.multipos.R
import com.example.multipos.data.model.Product

object ProductRepository {
    val products = listOf(
        // Category 1
        Product(1, "Product 1-1", 12.00, "Description for Product 1-1", R.drawable.cat1_1, 1),

        // Category 2
        Product(2, "Product 2-1", 8.00, "Description for Product 2-1", R.drawable.cat2_1, 2),
        Product(3, "Product 2-2", 10.00, "Description for Product 2-2", R.drawable.cat2_2, 2),
        Product(4, "Product 2-3", 25.00, "Description for Product 2-3", R.drawable.cat2_3, 2),
        Product(5, "Product 2-4", 15.00, "Description for Product 2-4", R.drawable.cat2_4, 2),
        Product(6, "Product 2-5", 18.00, "Description for Product 2-5", R.drawable.cat2_5, 2),

        // Category 3
        Product(7, "Product 3-1", 20.00, "Description for Product 3-1", R.drawable.cat3_1, 3),
        Product(8, "Product 3-2", 22.00, "Description for Product 3-2", R.drawable.cat3_2, 3),
        Product(9, "Product 3-3", 12.00, "Description for Product 3-3", R.drawable.cat3_3, 3),
        Product(10, "Product 3-4", 14.00, "Description for Product 3-4", R.drawable.cat3_4, 3),

        // Category 4
        Product(11, "Product 4-1", 30.00, "Description for Product 4-1", R.drawable.cat4_1, 4),
        Product(12, "Product 4-2", 35.00, "Description for Product 4-2", R.drawable.cat4_2, 4),
        Product(13, "Product 4-3", 40.00, "Description for Product 4-3", R.drawable.cat4_3, 4),

        // Category 5
        Product(14, "Product 5-1", 50.00, "Description for Product 5-1", R.drawable.cat5, 5),
        
        // Laptops (Assigning to Category 1 for variety)
        Product(15, "Laptop 1", 500.00, "High performance laptop", R.drawable.loptop1, 1),
        Product(16, "Laptop 2", 600.00, "Gaming laptop", R.drawable.loptop2, 1),
        Product(17, "Laptop 3", 700.00, "Ultrabook", R.drawable.loptop3, 1),
        Product(18, "Laptop 4", 800.00, "Workstation", R.drawable.loptop4, 1),
        Product(19, "Laptop 5", 900.00, "Convertible", R.drawable.loptop5, 1),
        Product(20, "Laptop 6", 1000.00, "Pro Laptop", R.drawable.loptop6, 1)
    )

    fun getProductById(id: Int): Product? {
        return products.find { it.id == id }
    }
}
