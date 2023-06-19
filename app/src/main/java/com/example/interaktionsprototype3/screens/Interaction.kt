package com.example.interaktionsprototype3.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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