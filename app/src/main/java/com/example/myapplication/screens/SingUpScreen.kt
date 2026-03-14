package com.example.myapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.regex.Pattern

@Composable
fun SingUpScreen( navController: NavController) {

    var email by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf(true) }
    fun validateEmail(email:String) : Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    var userName by remember { mutableStateOf("") }
    var isUserNameValid by remember { mutableStateOf(false) }
    var userNamePattern = Pattern.compile("\\w{4,20}")
//    fun validateUser(userName:String) : Bool {
//
//    }


    var phone by remember { mutableStateOf("") }
    var isPhoneNameValid by remember { mutableStateOf(false) }
    fun validatePhone(phoneNumber : String) : Boolean {
        return android.util.Patterns.PHONE.matcher(phoneNumber).matches()
    }

    var password by remember { mutableStateOf("") }
    var isPasswordValid by remember {mutableStateOf("")}
    fun validatePassword(password : String) : Boolean {
        return password.length >= 6;
    }

    var passwordAgain by remember { mutableStateOf("") }
    var isPasswordAgainValid by remember {mutableStateOf(false)}
    fun validatePasswordAgain() {
        isPasswordAgainValid = passwordAgain.contentEquals(password);
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
    ) {

        Text(
            text = "Singup",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("User") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Phone") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Confirmar contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Singup",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            Modifier.align(Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {
                    navController.navigate("welcome")
                }
            ) {
                Text(
                    text = "Cancel",
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = {}
            ) {
                Text(
                    text = "SingUp",
                    style = MaterialTheme.typography.headlineMedium
                )
            }

        }
    }
}