package com.example.e_shopstaff.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.e_shopstaff.data.produits
import com.example.e_shopstaff.ui.theme.uiClient.PageConnexion
import com.example.e_shopstaff.ui.theme.uiClient.corpDétail
import com.example.e_shopstaff.ui.theme.uiClient.fenetreAcceuilClient

@Composable
fun clientNavigation(onLogin: (String, String) -> Unit, ) {
    val navController = rememberNavController()




    NavHost(navController, startDestination = "homeClient") {
        composable("homeClient") { fenetreAcceuilClient(navController = navController) }
        composable("pageConnexion") { PageConnexion(onLogin = onLogin) }
        composable("detail/{codePro}", arguments = listOf(navArgument("codePro") { defaultValue = "11" })/*{ type = NavType.Companion.IntType }*/) { backStackEntry ->
            // Récupérez l'ID du produit à partir des arguments de la route
            val produitId = backStackEntry.arguments?.getInt("codePro")
            // Trouvez le produit correspondant dans votre liste de produits
            val produit = produits.find { it.codePro == produitId }
            // Assurez-vous que le produit n'est pas null
            if (produit != null) {
                corpDétail(Produit = produit)
            }
        }

        composable(
            route = "productDetails/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            // Récupérez l'ID du produit en tant qu'entier
            val productId = backStackEntry.arguments?.getInt("productId") ?: return@composable
            val produit = produits.find { it.codePro == productId }
            if (produit != null) {
                corpDétail(Produit = produit)
            }
        }
    }
}