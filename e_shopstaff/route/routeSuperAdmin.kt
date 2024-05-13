package com.example.e_shopstaff.route

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.e_shopstaff.R
import com.example.e_shopstaff.ui.theme.uiSuperAdmin.fenetreAcceuilAdmin
import com.example.e_shopstaff.ui.theme.uiSuperAdmin.fenetreGestionArticleAdmin

enum class routeSuperAdmin(@StringRes val title: Int) {

    Start(title = R.string.AcceuilAdmin),
    GesArt(title = R.string.ges_Article)


}
@Composable
fun eShopApp(
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = routeSuperAdmin.valueOf(
        backStackEntry?.destination?.route ?: routeSuperAdmin.Start.name
    )

    Scaffold(

    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = routeSuperAdmin.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = routeSuperAdmin.Start.name) {

            }
            composable(route = routeSuperAdmin.GesArt.name) {
                    fenetreGestionArticleAdmin()
                }
            }

        }
    }



