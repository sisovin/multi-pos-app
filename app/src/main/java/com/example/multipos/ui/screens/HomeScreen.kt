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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.multipos.ui.theme.DarkBlack
import com.example.multipos.ui.theme.GrayLight
import com.example.multipos.ui.theme.GreenMain
import com.example.multipos.ui.theme.RedMain
import com.example.multipos.ui.theme.White
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(
    onPayClick: () -> Unit,
    onBuyClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayLight)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(GreenMain)
                .padding(24.dp)
        ) {
            Column {
                Text(
                    text = "ចំនួនសរុបត្រូវបង់", // Total to pay
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$0.00",
                    color = White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // Date
        val currentDate = SimpleDateFormat("EEEE dd MMMM yyyy", Locale.getDefault()).format(Date())
        Text(
            text = currentDate,
            color = Color.Gray,
            modifier = Modifier.padding(16.dp)
        )

        // Chart Panel Placeholder
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("[ក្រាហ្វិកលក់ប្រចាំថ្ងៃ]", color = Color.Gray) // Daily Sales Chart
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Action Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = onPayClick,
                colors = ButtonDefaults.buttonColors(containerColor = GreenMain),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f).height(60.dp)
            ) {
                Text("សងប្រាក់", fontSize = 18.sp) // Pay Back / Refund? Or Pay? Context implies Pay/Settle
            }
            Button(
                onClick = onBuyClick,
                colors = ButtonDefaults.buttonColors(containerColor = RedMain),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f).height(60.dp)
            ) {
                Text("ទិញផល", fontSize = 18.sp) // Buy Product
            }
        }
        
        Button(
            onClick = { /* Close Machine */ },
            colors = ButtonDefaults.buttonColors(containerColor = DarkBlack),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(50.dp)
        ) {
            Text("បិទម៉ាស៊ីន", fontSize = 18.sp) // Close Machine
        }
    }
}
