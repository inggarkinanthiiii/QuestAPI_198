package com.example.pamhttp.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pamhttp.uicontroller.route.DestinasiDetail
import com.example.pamhttp.uicontroller.route.DestinasiEntry
import com.example.pamhttp.uicontroller.route.DestinasiHome
import com.example.pamhttp.view.DetailSiswaScreen
import com.example.pamhttp.view.EntrySiswaScreen
import com.example.pamhttp.view.HomeScreen


@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(),
                 modifier: Modifier) {
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController = navController, startDestination = DestinasiHome.route,
        modifier = Modifier) {
        composable(DestinasiHome.route) {
            HomeScreen(navigateToItemEntry = {navController.navigate(DestinasiEntry.route)},
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetail.route}/${it}")
                })
        }
        composable (DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = {navController.navigate(DestinasiHome.route)})
        }
        composable (DestinasiDetail.routeWithArgs, arguments = listOf(navArgument(DestinasiDetail.itemIdArgs){
            type = NavType.IntType })
        ){
            DetailSiswaScreen(
                navigateBack = {navController.navigate(DestinasiHome.route)}
            )
        }
    }
}