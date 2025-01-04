package com.example.ingetin.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ingetin.R
import com.example.ingetin.ui.theme.Primary
import com.example.ingetin.ui.theme.Secondary


@Composable
fun CustomText() {
    val text = buildAnnotatedString {
        append("Organize your life and achieve your goals with ")
        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.Bold),) {
            append("Inget")
        }
        append(".")
        withStyle(style = SpanStyle(color = Secondary, fontWeight = FontWeight.Bold),) {
            append("in")
        }
        append("!.")
    }

    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        modifier = Modifier.fillMaxWidth(0.80f),
        textAlign = TextAlign.Center
    )
}

@Composable
fun NavigateToLogin(navController: NavController) {
    val text = buildAnnotatedString {
        append("Already have an account? ")
        withStyle(style = SpanStyle(color = Color(0xFF9C27B0))) { // Purple color
            append("Login")
        }
    }

    ClickableText(
        text = text,
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        ),
        onClick = {
            // Handle the click on the "Login" text and navigate to the login screen
            navController.navigate("login_screen") // Replace with your login route
        },
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun OnboardingScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.on_boarding),
                contentDescription = "gambar",
                modifier = Modifier
                    .width(316.dp)
                    .height(230.dp)
            )
            Spacer(modifier = Modifier.height(80.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Let’s Get Productive!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(22.dp))
               CustomText()
            }
            Spacer(modifier = Modifier.height(52.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Primary),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Create an account",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            NavigateToLogin(navController = navController)
        }

    }
}
