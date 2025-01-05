package com.example.ingetin.ui.screens.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.ingetin.R
import com.example.ingetin.ui.theme.Primary
import com.example.ingetin.ui.theme.Secondary


@Composable
fun TitleText() {
    val text = buildAnnotatedString {
        append("Welcome to ")
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
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth(0.80f),
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun OnboardingPage1() {

    Box(
        modifier = Modifier
            .fillMaxSize()

            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.on_boarding1),
                contentDescription = "Image for page 2",
                modifier = Modifier
                    .width(316.dp)
                    .height(230.dp)
            )
            Spacer(modifier = Modifier.height(96.dp))
            TitleText()
            Spacer(modifier = Modifier.height(22.dp))
            Text(text = "We're here to help you organize and remember every important task. Boost your productivity without the stress!",
    fontSize = 12.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(0.75f)
                )
        }
    }
}