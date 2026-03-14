package com.example.myapplication.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items;
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.components.ContactExample
import com.example.myapplication.ui.theme.MyApplicationTheme


@Composable
fun ListItemsExample(){
    val frutas = listOf<String>("Manzana","Pera","Naranja","Platano","Uvas");

    LazyColumn(
        horizontalAlignment = Alignment.End
    ) {
        items(frutas){
            fruta ->
            ContactExample(fruta, "(+52) 12345667890")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemsExamplePreview(){
    MyApplicationTheme {
        ListItemsExample();
    }
}