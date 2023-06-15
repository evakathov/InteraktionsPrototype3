package com.example.interaktionsprototype3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    searchObjects: List<SearchObject>,
    onSearchObjectAdded: (SearchObject) -> Unit,
    onCompareClicked: () -> Unit
) {
    // Local state to hold the search query
    val searchQuery = remember { mutableStateOf("") }

    Column {
        // Search input field
        TextField(
            value = searchQuery.value,
            onValueChange = { searchQuery.value = it },
            label = { Text("Search") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to add search object
        Button(
            onClick = {
                // Create a new search object based on the query and add it to the list
                val newSearchObject = SearchObject(searchObjects.size + 1, searchQuery.value)
                onSearchObjectAdded(newSearchObject)

                // Clear the search query
                searchQuery.value = ""
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add Search Object")
        }

        // Button to compare search objects
        Button(
            onClick = { onCompareClicked() },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Compare")
        }

        // Display the list of search objects
        LazyColumn {
            items(searchObjects) { searchObject ->
                Text(searchObject.name)
            }
        }
    }
}
