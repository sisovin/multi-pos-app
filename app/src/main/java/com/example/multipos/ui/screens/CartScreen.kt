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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.ui.window.Dialog
import com.example.multipos.R
import com.example.multipos.data.model.Product
import com.example.multipos.ui.theme.GrayLight
import com.example.multipos.ui.theme.GreenMain
import com.example.multipos.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    onBackClick: () -> Unit
) {
    val cartItems = listOf(
        Product(1, "កែកប៊ឺរី", 12.00),
        Product(2, "ផ្លែប៉ោម", 8.00),
        Product(3, "តែខ្មៅ", 12.00)
    )
    val total = cartItems.sumOf { it.price }
    var showQrCode by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cart Summary", color = White) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = GreenMain)
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
                        onClick = { showQrCode = true },
                        colors = ButtonDefaults.buttonColors(containerColor = GreenMain),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("QR Scan")
                    }
                }
            }
        }

        if (showQrCode) {
            Dialog(onDismissRequest = { showQrCode = false }) {
                Box(
                    modifier = Modifier
                        .size(300.dp)
                        .background(White, shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Scan to Pay",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.qr),
                            contentDescription = "QR Code",
                            modifier = Modifier.size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }
        }
    }
}
