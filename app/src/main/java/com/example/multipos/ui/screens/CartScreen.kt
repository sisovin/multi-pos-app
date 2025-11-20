package com.example.multipos.ui.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.multipos.ui.theme.GrayLight
import com.example.multipos.ui.theme.GreenMain
import com.example.multipos.ui.theme.White

@Composable
fun CartScreen() {
    val cartItems = listOf(
        Product("កែកប៊ឺរី", 12.00),
        Product("ផ្លែប៉ោម", 8.00),
        Product("តែខ្មៅ", 12.00)
    )
    val total = cartItems.sumOf { it.price }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayLight)
            .padding(16.dp)
    ) {
        Text(
            text = "Cart Summary",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Item List
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(White, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            items(cartItems) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(item.name, fontSize = 18.sp)
                    Text("$${item.price}", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
                Divider(color = GrayLight)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Total & Payment
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(White, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Total", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("$$total", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = GreenMain)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Payment Options", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { /* Cash Payment */ },
                    colors = ButtonDefaults.buttonColors(containerColor = GreenMain),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Cash")
                }
                Button(
                    onClick = { /* QR Payment */ },
                    colors = ButtonDefaults.buttonColors(containerColor = GreenMain),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("QR Scan")
                }
            }
        }
    }
}
