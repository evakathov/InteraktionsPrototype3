package com.example.interaktionsprototype3.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun InteractionScreen() {
     Text(text = "Søg på flere præparater",
         fontSize = MaterialTheme.typography.h4.fontSize,
         fontWeight = FontWeight.Bold,)
}                


@Composable
@Preview
fun InteractionScreenPreview() {
    InteractionScreen()
}