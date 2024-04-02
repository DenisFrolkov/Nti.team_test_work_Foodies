package com.example.ntiteam_test_work_foodies.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ntiteam_test_work_foodies.R
import com.example.ntiteam_test_work_foodies.api.Category
import com.example.ntiteam_test_work_foodies.api.MainViewModel
import com.example.ntiteam_test_work_foodies.api.Product
import com.example.ntiteam_test_work_foodies.ui.theme.Gray
import com.example.ntiteam_test_work_foodies.universalComponents.CategoriesItem
import com.example.ntiteam_test_work_foodies.universalComponents.FixedButton
import com.example.ntiteam_test_work_foodies.universalComponents.ItemCard

@Composable
fun CatalogScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    var categories by remember { mutableStateOf(emptyList<Category>()) }
    var products by remember { mutableStateOf(emptyList<Product>()) }
    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }
    LaunchedEffect(viewModel.categories, viewModel.products) {
        viewModel.categories.observeForever { newCategories ->
            categories = newCategories
        }
        viewModel.products.observeForever { newProducts ->
            products = newProducts
        }
    }
    Catalog(navController = navController, category = categories, products = products)
}

@Composable
fun Catalog(
    navController: NavController,
    category: List<Category>,
    products: List<Product>
) {
    Column(
        modifier = Modifier.background(color = Color.White)
    ) {
        Column() {
            TopLine()
            Categories(
                category = category
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Gray,
                                Color.White,
                            ),
                        )
                    )
            )
        }
        ProductsList(products = products, navController = navController)
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        FixedButton(
            textTotalPrice = "2 160",
            painterCard = painterResource(id = R.drawable.basket_icon),
            textInCard = "",
            navController = navController
        )
    }
}

@Composable
fun ProductsList(products: List<Product>, navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .background(color = Color.White)
    ) {
        items(products.chunked(2)) { productPair ->
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items(productPair) { product ->
                    ItemCard(
                        idProduct = product.id,
                        textName = product.name,
                        textWeight = product.measure.toString(),
                        textWeightUnit = product.measure_unit,
                        priceCurrent = product.price_current,
                        priceOld = product.price_old,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun TopLine() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color.White)
            .padding(top = 40.dp)
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.filter_icon),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 18.dp)
                .size(24.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.logo_image),
            contentDescription = null,
            modifier = Modifier
                .size(width = 110.dp, height = 44.dp)
                .align(Alignment.Bottom)
        )
        Icon(
            painter = painterResource(id = R.drawable.search_icon),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 18.dp)
                .size(24.dp)
        )
    }
}

@Composable
fun Categories(
    category: List<Category>
) {
    var selectedCategory by remember { mutableStateOf("") }

    LazyRow(
        modifier = Modifier.background(color = Color.White)
    ) {
        items(category) { category ->
            CategoriesItem(
                categoriesTitle = category.name,
                selectedCategory = selectedCategory,
                onCategorySelected = { newCategory ->
                    selectedCategory = newCategory
                }
            )
        }
    }
}
