package com.example.mvvmarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.mvvmarchitecture.mvvm.view.SignInScreen
import com.example.mvvmarchitecture.mvvm.view.SignUpScreen

/**
 * MainActivity sets up the navigation for the app.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Creates a navigation controller to manage screen transitions
            val navController = rememberNavController()

            // Defines the navigation graph with two screens
            NavHost(navController, startDestination = "sign_in") {
                // Navigate from SignInScreen to SignUpScreen
                composable("sign_in") { SignInScreen { navController.navigate("sign_up") } }

                // Navigate from SignUpScreen to SignInScreen
                composable("sign_up") { SignUpScreen { navController.navigate("sign_in") } }
            }
        }
    }
}
