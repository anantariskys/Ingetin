package com.example.ingetin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.ingetin.ui.screens.OnboardingScreen
import com.example.ingetin.ui.screens.LoginScreen
import com.example.ingetin.ui.theme.IngetinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IngetinTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // Set up the navigation
                    val navController = rememberNavController() // Initialize NavController
                    SetupNavGraph(navController) // Pass navController to setup navigation
                }
            }
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    // Define NavHost
    NavHost(navController = navController, startDestination = "onboarding_screen") {
        composable("onboarding_screen") {
            OnboardingScreen(navController) // Pass navController to OnboardingScreen
        }
        composable("login_screen") {
            LoginScreen() // Define your LoginScreen here
        }
    }
}
