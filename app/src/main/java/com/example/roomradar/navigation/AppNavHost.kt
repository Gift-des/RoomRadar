package com.example.roomradar.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roomradar.ui.theme.screens.about.AboutScreen
import com.example.roomradar.ui.theme.screens.dashboard.DashboardScreen
import com.example.roomradar.ui.theme.screens.details.DetailsScreen
import com.example.roomradar.ui.theme.screens.home.HomeScreen

import com.example.roomradar.ui.theme.screens.intent.IntentScreen
import com.example.roomradar.ui.theme.screens.login.LoginScreen
import com.example.roomradar.ui.theme.screens.rooms.AddRoomsScreen
import com.example.roomradar.ui.theme.screens.rooms.ViewRoomsScreen
import com.example.roomradar.ui.theme.screens.signup.SignupScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = ROUT_SPLASH
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){

        composable(ROUT_LOGIN){
            LoginScreen(navController = navController)
        }

        composable(ROUT_SIGNUP){
           SignupScreen(navController = navController)
        }

        composable(ROUT_ADD_ROOMS){
          AddRoomsScreen(navController = navController)
        }

        composable(ROUT_VIEW_ROOMS){
          ViewRoomsScreen(navController = navController)
        }

        composable(ROUT_ROOM){
            AddRoomsScreen(navController = navController)
        }
        composable(ROUT_HOME){
         HomeScreen(navController = navController)
        }

        composable(ROUT_ABOUT){
            AboutScreen(navController = navController)
        }
        composable(ROUT_DETAILS){
           DetailsScreen(navController = navController)
        }
        composable(ROUT_DASHBOARD){
           DashboardScreen(navController = navController)
        }
        composable(ROUT_INTENT){
           IntentScreen(navController = navController)
        }

        




    }


}