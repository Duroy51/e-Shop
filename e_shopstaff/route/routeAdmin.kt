package com.example.e_shopstaff.route

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_shopstaff.ui.theme.uiSuperAdmin.fenetreAcceuilAdmin
import com.example.e_shopstaff.ui.theme.uiSuperAdmin.fenetreGestionArticleAdmin


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { fenetreAcceuilAdmin(navController = navController) }
        composable("gesArticle") { fenetreGestionArticleAdmin() }
    }
}
