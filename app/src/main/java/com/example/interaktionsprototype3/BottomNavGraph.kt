package com.example.interaktionsprototype3

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.interaktionsprototype3.screens.HomeScreen
import com.example.interaktionsprototype3.screens.InfoScreen
import com.example.interaktionsprototype3.screens.InteractionScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    val mainViewModel: MainViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Drug.route
    ) {
        composable(route = BottomBarScreen.Drug.route) {
            HomeScreen(mainViewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.Interaction.route) {
            InteractionScreen()
        }
        composable(route = BottomBarScreen.Info.route) {
            InfoScreen()
        }
    }
}

