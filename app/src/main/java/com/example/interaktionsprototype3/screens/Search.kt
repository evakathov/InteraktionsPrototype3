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
import com.example.interaktionsprototype3.SearchBar
import com.example.interaktionsprototype3.SearchObject

@Composable
fun SearchScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        MyScreenContent()
    }
}

@Composable
fun MyScreenContent() {
    val searchObjects = remember { mutableStateListOf<SearchObject>() }

    SearchBar(
        searchObjects = searchObjects,
        onSearchObjectAdded = { searchObject ->
            searchObjects.add(searchObject)
        },
        onCompareClicked = {
            // Perform the compare operation
            // You can access the list of search objects using the 'searchObjects' variable
        }
    )
}

@Composable
@Preview
fun SearchScreenPreview() {
    SearchScreen()
}