package com.example.ingetin.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
        append("Welcome back to ")
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
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailInput(email: String, onEmailChange: (String) -> Unit) {
    Column {
        Text(text = "Email", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email Icon") },
            placeholder = { Text("Enter your email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Primary,
                unfocusedBorderColor = Color.DarkGray,
                focusedTextColor = Primary,
                unfocusedTextColor = Color.DarkGray,
                cursorColor = Primary,
                focusedPlaceholderColor = Primary,
                unfocusedPlaceholderColor = Color.DarkGray,
                focusedLeadingIconColor = Primary,
                unfocusedLeadingIconColor = Color.DarkGray,


            )

        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(password: String, onPasswordChange: (String) -> Unit) {
    var passwordVisible by remember { mutableStateOf(false) }
    Column {
        Text(text = "Password", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            leadingIcon = {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = "Password Icon"
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide Password" else "Show Password"
                    )
                }
            },
            placeholder = { Text("Enter your password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Primary,
                unfocusedBorderColor = Color.DarkGray,
                focusedTextColor = Primary,
                unfocusedTextColor = Color.DarkGray,
                cursorColor = Primary,
                focusedPlaceholderColor = Primary,
                unfocusedPlaceholderColor = Color.DarkGray,
                focusedLeadingIconColor = Primary,
                unfocusedLeadingIconColor = Color.DarkGray,

            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleText()
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Don’t let tasks slip away. Let’s get back to managing what matters!",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.drawable.login_img),
            contentDescription = "login",
            modifier = Modifier
                .height(152.dp)
                .width(216.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        EmailInput(email = email, onEmailChange = { email = it })
        Spacer(modifier = Modifier.height(16.dp))
        PasswordInput(password = password, onPasswordChange = { password = it })
        Text(text = "Forgot password?", modifier = Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { /* Implement your login action */ }, enabled =  (email.isNotEmpty()&&password.isNotEmpty()),  colors = ButtonDefaults.buttonColors(
            disabledContainerColor = if (email.isNotEmpty() && password.isNotEmpty()) Primary else Color(0xFFE6E5E5),
            disabledContentColor = if (email.isNotEmpty() && password.isNotEmpty()) Color.White else Color.White,
            containerColor = Primary,
            contentColor = Color.White
        ), modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(4.dp))
        }
    }
}
