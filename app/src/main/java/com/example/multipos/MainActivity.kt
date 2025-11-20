package com.example.multipos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.multipos.ui.screens.AllItemsScreen
import com.example.multipos.ui.screens.CartScreen
import com.example.multipos.ui.screens.HomeScreen
import com.example.multipos.ui.screens.LauncherScreen
import com.example.multipos.ui.screens.LoginScreen
import com.example.multipos.ui.screens.SignupScreen
import com.example.multipos.ui.theme.MultiPOSTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiPOSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MultiPosApp()
                }
            }
        }
    }
}

@Composable
fun MultiPosApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "launcher") {
        composable("launcher") {
            LauncherScreen(
                onTimeout = {
                    navController.navigate("login") {
                        popUpTo("launcher") { inclusive = true }
                    }
                }
            )
        }
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToSignup = {
                    navController.navigate("signup")
                }
            )
        }
        composable("signup") {
            SignupScreen(
                onSignupSuccess = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    navController.popBackStack()
                }
            )
        }
        composable("home") {
            HomeScreen(
                onPayClick = { navController.navigate("cart") },
                onBuyClick = { navController.navigate("allItems") }
            )
        }
        composable("allItems") {
            AllItemsScreen(
                onCheckoutClick = { navController.navigate("cart") }
            )
        }
        composable("cart") {
            CartScreen()
        }
    }
}
