package com.example.multipos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.multipos.data.repository.ProductRepository
import com.example.multipos.ui.theme.DarkBlack
import com.example.multipos.ui.theme.GrayLight
import com.example.multipos.ui.theme.GreenMain
import com.example.multipos.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreen(
    productId: Int,
    onBackClick: () -> Unit,
    onAddToCart: (Int, Int) -> Unit // productId, quantity
) {
    val product = ProductRepository.getProductById(productId)
    var quantity by remember { mutableIntStateOf(1) }

    if (product == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Product not found")
        }
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Product Details", color = White) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkBlack)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayLight)
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Product Image
            if (product.imageResId != 0) {
                Image(
                    painter = painterResource(id = product.imageResId),
                    contentDescription = product.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color.White, shape = RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Fit
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color.Gray, shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Product Image", color = White)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = product.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = DarkBlack
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$${product.price}",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = GreenMain
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = product.description,
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.weight(1f))

            // Quantity Selector
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { if (quantity > 1) quantity-- },
                    modifier = Modifier.background(White, shape = RoundedCornerShape(8.dp))
                ) {
                    Icon(Icons.Default.Remove, contentDescription = "Decrease")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = quantity.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(16.dp))

                IconButton(
                    onClick = { quantity++ },
                    modifier = Modifier.background(White, shape = RoundedCornerShape(8.dp))
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Increase")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { onAddToCart(product.id, quantity) },
                colors = ButtonDefaults.buttonColors(containerColor = GreenMain),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Add to Cart - $${product.price * quantity}", color = White, fontSize = 18.sp)
            }
        }
    }
}
