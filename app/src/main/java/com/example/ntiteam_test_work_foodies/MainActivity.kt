package com.example.ntiteam_test_work_foodies

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.Navigation
import com.example.ntiteam_test_work_foodies.navigation.Navigation
import com.example.ntiteam_test_work_foodies.screens.BasketScreen
import com.example.ntiteam_test_work_foodies.screens.CatalogScreen
import com.example.ntiteam_test_work_foodies.screens.ProductCardScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ntiteam_test_work_foodies.api.MainViewModel

import com.example.ntiteam_test_work_foodies.ui.theme.Ntiteam_test_work_FoodiesTheme

class MainActivity : ComponentActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ntiteam_test_work_FoodiesTheme {
                Navigation(viewModel = viewModel)
            }
        }
    }
}

