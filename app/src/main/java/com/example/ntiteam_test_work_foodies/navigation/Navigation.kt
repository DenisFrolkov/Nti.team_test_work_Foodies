package com.example.ntiteam_test_work_foodies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ntiteam_test_work_foodies.screens.BasketScreen
import com.example.ntiteam_test_work_foodies.screens.CatalogScreen
import com.example.ntiteam_test_work_foodies.screens.ProductCard
import com.example.ntiteam_test_work_foodies.screens.ProductCardScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "catalog_screen") {
        composable("catalog_screen") { CatalogScreen(navController = navController) }
        composable("product_card_screen") { ProductCardScreen(navController = navController) }
        composable("basket_screen") { BasketScreen(navController = navController) }
    }
}