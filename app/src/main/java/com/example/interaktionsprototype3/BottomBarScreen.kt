package com.example.interaktionsprototype3

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
//each screen i our bottombar will have a route, a title and an icon
sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector

) {
    // We define 3 different objects for the different screens
    //Each object represents the screens in our bottomnavgationbar
    object Drug: BottomBarScreen(route= "drug",
    title = "Præparat",
    icon = Icons.Default.Search)

    object Interaction: BottomBarScreen(route= "interaction",
        title = "Interaktioner",
        icon = Icons.Default.AddCircle)

    object Info: BottomBarScreen(route= "info",
        title = "Info",
        icon = Icons.Default.Info)

}




