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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
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
import com.example.ntiteam_test_work_foodies.R
import com.example.ntiteam_test_work_foodies.ui.theme.Gray
import com.example.ntiteam_test_work_foodies.universalComponents.CategoriesItem
import com.example.ntiteam_test_work_foodies.universalComponents.FixedButton
import com.example.ntiteam_test_work_foodies.universalComponents.ItemCard

@Composable
fun CatalogScreen() {
    Catalog()
}

@Composable
fun Catalog() {
    Column {
        Column(
        ) {
            TopLine()
            Categories()
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

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .navigationBarsPadding()
        ) {
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    ItemList()
                }
            }
        }
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        FixedButton(textTotalPrice = "2 160", painterCard = painterResource(id = R.drawable.basket_icon), textInCard = "")
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
fun Categories() {
    var selectedCategory by remember { mutableStateOf("") }

    LazyRow(
        modifier = Modifier.background(color = Color.White)
    ) {
        items(listOf("Роллы", "Суши", "Наборы", "Горячие блюда", "Супы", "Десерты")) { category ->
            CategoriesItem(
                categoriesTitle = category,
                selectedCategory = selectedCategory,
                onCategorySelected = { newCategory ->
                    selectedCategory = newCategory
                }
            )
        }
    }
}

@Composable
fun ItemList() {
    Row(
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(end = 4.dp)
        ) {
            ItemCard(
                textName = "Том Ям",
                textWeight = "500 гр",
                textPrice = "800",
                textSalePrice = "720"
            )
            Spacer(modifier = Modifier.height(8.dp))
            ItemCard(
                textName = "Том Ям",
                textWeight = "500 гр",
                textPrice = "800",
                textSalePrice = "720"
            )
            Spacer(modifier = Modifier.height(8.dp))
            ItemCard(
                textName = "Том Ям",
                textWeight = "500 гр",
                textPrice = "800",
                textSalePrice = "720"
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 4.dp)
        ) {
            ItemCard(
                textName = "Том Ям",
                textWeight = "500 гр",
                textPrice = "800",
                textSalePrice = null
            )
            Spacer(modifier = Modifier.height(8.dp))
            ItemCard(
                textName = "Том Ям",
                textWeight = "500 гр",
                textPrice = "800",
                textSalePrice = null
            )
            Spacer(modifier = Modifier.height(8.dp))
            ItemCard(
                textName = "Том Ям",
                textWeight = "500 гр",
                textPrice = "800",
                textSalePrice = null
            )
        }
    }
}