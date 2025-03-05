package com.jda.flyaccesskmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jda.flyaccesskmp.access.AccessScreen
import com.jda.flyaccesskmp.initial.InitialScreen
import com.jda.flyaccesskmp.register.RegisterScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Initial") {
        composable("Initial"){
            InitialScreen(goToAccessScreen = { navController.navigate("Access") },
                goToRegisterScreen = { navController.navigate("Register") })
        }
        composable("Access") {
            AccessScreen(goToBack = { navController.popBackStack()})
        }
        composable("Register") {
            RegisterScreen { navController.popBackStack() }
        }
    }
}