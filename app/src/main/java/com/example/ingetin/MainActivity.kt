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
import com.example.ingetin.ui.screens.SplashScreen
import com.example.ingetin.ui.theme.IngetinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IngetinTheme {

                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()
                    SetupNavGraph(navController)
                }
            }
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("onboarding_screen") {
            OnboardingScreen(navController)
        }
        composable("login_screen") {
            LoginScreen()
        }
        composable("splash_screen"){
            SplashScreen(navController)
        }
    }
}
