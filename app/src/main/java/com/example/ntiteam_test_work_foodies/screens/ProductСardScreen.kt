package com.example.ntiteam_test_work_foodies.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ntiteam_test_work_foodies.R
import com.example.ntiteam_test_work_foodies.universalComponents.FixedButton

@Composable
fun ProductCardScreen(
    navController: NavController
) {
    ProductCard(navController = navController)
}

@Composable
fun ProductCard(
    navController: NavController
) {

    LazyColumn(
        modifier = Modifier
            .padding(top = 24.dp)
            .background(color = Color.White)
    ) {
        item {
            BigImage()
            Spacer(modifier = Modifier.height(24.dp))
            TitleProductCurd("Том Ям")
            CompoundProductCurd(textCompound = "Кокосовое молоко, кальмары, креветки, помидоры черри, грибы вешанки")
            Spacer(modifier = Modifier.height(24.dp))
            ListItemProductCard(titleListItem = "Вес", textListItem = "400 г", navController = navController)
            ListItemProductCard(titleListItem = "Энерг. ценность", textListItem = "198,9 ккал", navController = navController)
            ListItemProductCard(titleListItem = "Белки", textListItem = "10 г", navController = navController)
            ListItemProductCard(titleListItem = "Жиры", textListItem = "8,5 г", navController = navController)
            ListItemProductCard(titleListItem = "Углеводы", textListItem = "19,7 г", navController = navController)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(0.3f)
                    .height(1.dp)
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.height(126.dp))
        }
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, top = 40.dp)
    ) {
        BackButton(
            navController = navController
        )
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        FixedButton(
            textTotalPrice = "2 160",
            painterCard = null,
            textInCard = "В корзину за",
            navController = navController
        )
    }
}

@Composable
fun BackButton(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(25.dp)
            )
            .background(color = Color.White, shape = RoundedCornerShape(25.dp))
    ) {
        Icon(
            painter = painterResource(id = R.drawable.back_item),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .padding(10.dp)
                .size(24.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    navController.popBackStack()
                }
        )
    }
}

@Composable
fun BigImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.photo_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun TitleProductCurd(
    textTitle: String
) {
    Text(
        text = textTitle,
        style = TextStyle(
            fontSize = 34.sp,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.roboto_regular))
        ),
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun CompoundProductCurd(
    textCompound: String
) {
    Text(
        text = textCompound,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.roboto_regular)),
            lineHeight = 24.sp
        ),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .alpha(0.6f)
    )
}


@Composable
fun ListItemProductCard(
    titleListItem: String,
    textListItem: String,
    navController: NavController
) {
    Column(
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            navController.navigate("product_card_screen")
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.3f)
                .height(1.dp)
                .background(Color.Gray)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 13.dp)
        ) {
            Text(
                text = titleListItem,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    lineHeight = 24.sp
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .alpha(0.6f)
            )
            Text(
                text = textListItem,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    lineHeight = 24.sp
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .alpha(0.87f)
            )
        }
    }
}
