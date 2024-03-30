package com.example.ntiteam_test_work_foodies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ntiteam_test_work_foodies.screens.CatalogScreen
import com.example.ntiteam_test_work_foodies.ui.theme.Ntiteam_test_work_FoodiesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ntiteam_test_work_FoodiesTheme {
                CatalogScreen()
            }
        }
    }
}
