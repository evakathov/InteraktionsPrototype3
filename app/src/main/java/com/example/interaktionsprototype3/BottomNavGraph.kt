package com.example.interaktionsprototype3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.interaktionsprototype3.screens.HomeScreen
import com.example.interaktionsprototype3.screens.InfoScreen
import com.example.interaktionsprototype3.screens.SearchScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Search.route){
            SearchScreen()
        }
        composable(route = BottomBarScreen.Info.route){
            InfoScreen()
        }
    }

}