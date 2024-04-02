package com.example.ntiteam_test_work_foodies.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ntiteam_test_work_foodies.api.MainViewModel
import com.example.ntiteam_test_work_foodies.screens.BasketScreen
import com.example.ntiteam_test_work_foodies.screens.CatalogScreen
import com.example.ntiteam_test_work_foodies.screens.ProductCardScreen

@SuppressLint("UnusedCrossfadeTargetStateParameter")
@Composable
fun Navigation(viewModel: MainViewModel) {
    val navController = rememberNavController()
    val product = viewModel.products

    NavHost(navController = navController, startDestination = "catalog_screen") {
        composable("catalog_screen") {
            Crossfade(targetState = "catalog_screen") {
                CatalogScreen(navController = navController, viewModel = viewModel)
            }
        }
        composable("product_card_screen/{idProduct}") { backStackEntry ->
            val idProduct = backStackEntry.arguments?.getString("idProduct")
            if (idProduct != null) {
                Crossfade(targetState = "product_card_screen/$idProduct") {
                    ProductCardScreen(navController = navController, viewModel = viewModel, idProduct = idProduct)
                }
            }
        }
        composable("basket_screen") {
            Crossfade(targetState = "basket_screen") {
                BasketScreen(navController = navController, viewModel = viewModel)
            }
        }
    }
}
