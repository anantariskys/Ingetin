package com.example.ingetin.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.ingetin.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val visible = remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(500)
        visible.value = true
        delay(2000)
        navController.navigate("onboarding_screen")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
              Color.White
            ),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = visible.value,
            enter = androidx.compose.animation.fadeIn(animationSpec = tween(durationMillis = 1000)),
            exit = androidx.compose.animation.fadeOut(animationSpec = tween(durationMillis = 1000))
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxSize(0.5f)

            )
        }
    }
}


