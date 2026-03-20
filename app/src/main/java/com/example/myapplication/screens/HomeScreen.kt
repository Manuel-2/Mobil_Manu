package com.example.myapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.components.ContactExample
import com.example.myapplication.core.Contact
import com.example.myapplication.navigation.AppNavigation
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun HomeScreen(){
    var contacts by remember { mutableStateOf(
        listOf<Contact>(Contact("Manuel","6122880833"))
    ) };

    var newContactName by remember { mutableStateOf("") }
    var newContactNameIsValid by remember { mutableStateOf(true) }

    var newContactPhone by remember { mutableStateOf("") }
    var newContactPhoneIsValid by remember { mutableStateOf(true) }

    val phoneRegex = "\\d{10}".toRegex()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            Column() {
                TextField(
                    value = newContactName,
                    onValueChange = {
                        newContactName = it;
                        newContactNameIsValid = newContactName.length >= 3
                    },
                    label = {Text("Nombre contacto")},
                    isError = !newContactNameIsValid
                )
                TextField(
                    value = newContactPhone,
                    onValueChange = {
                        newContactPhone = it;
                        newContactPhoneIsValid = phoneRegex.matches(it);
                    },
                    label = {Text("Numero de telefono")},
                    isError = !newContactPhoneIsValid
                )
            }
            Button(
                onClick = {
                    if(newContactNameIsValid && newContactPhoneIsValid){
                        contacts = contacts.plus(Contact(newContactName,newContactPhone))
                        newContactName = "";
                        newContactPhone = "";
                    }
                }
            ) {
                Text(" + ")
            }
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(contacts){
                ContactExample(it.name,it.number);
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    MyApplicationTheme {
        HomeScreen()
    }
}