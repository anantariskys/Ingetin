package com.example.ingetin.ui.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ingetin.R
import com.example.ingetin.ui.screens.onBoarding.OnboardingPage1
import com.example.ingetin.ui.screens.onBoarding.OnboardingPage2
import com.example.ingetin.ui.screens.onBoarding.OnboardingPage3
import com.example.ingetin.ui.theme.Primary
import com.example.ingetin.ui.theme.Secondary
import kotlinx.coroutines.launch

@Composable
fun CustomText() {
    val text = buildAnnotatedString {
        append("Organize your life and achieve your goals with ")
        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.Bold)) {
            append("Inget")
        }
        withStyle(style = SpanStyle(color = Secondary, fontWeight = FontWeight.Bold)) {
            append("in")
        }
        append("!")
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
        withStyle(style = SpanStyle(color = Color(0xFF9C27B0))) {
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
            navController.navigate("login_screen")
        },
        modifier = Modifier.fillMaxWidth()
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {
    val pagerState = rememberPagerState(
        pageCount = { 4 }
    )
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { page ->
                when (page) {
                    0 -> OnboardingPage1()
                    1 -> OnboardingPage2()
                    2 -> OnboardingPage3()
                    3 -> OnboardingPage4(navController)
                }
            }


        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            repeat(pagerState.pageCount) { index ->
                val targetWidth = if (pagerState.currentPage == index) 20.dp else 8.dp


                val animatedWidth = animateDpAsState(
                    targetValue = targetWidth,
                    animationSpec = tween(durationMillis = 300)
                )

                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .width(animatedWidth.value)
                        .height(8.dp)
                        .background(
                            color = if (pagerState.currentPage == index) Primary else Color.Gray,
                            shape = CircleShape
                        )
                )
            }
        }


        if (pagerState.currentPage > 0) {
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                },
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
                    .size(56.dp)
                    .background(color = Color(0xFFFBF1FF), shape = CircleShape)

            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Previous",
                    tint = Primary

                )
            }
        }
        if (pagerState.currentPage < pagerState.pageCount - 1) {
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }, modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .size(56.dp)
                    .background(color = Primary, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Previous",
                    tint = Color(0xFFFBF1FF)
                )
            }
        }



    }
}


@Composable
fun OnboardingPage4(navController: NavController) {
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


