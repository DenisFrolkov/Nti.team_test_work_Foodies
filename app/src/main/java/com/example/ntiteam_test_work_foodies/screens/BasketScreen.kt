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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ntiteam_test_work_foodies.R
import com.example.ntiteam_test_work_foodies.dataclass_ui.BasketItem
import com.example.ntiteam_test_work_foodies.ui.theme.Gray
import com.example.ntiteam_test_work_foodies.universalComponents.AddCardItem
import com.example.ntiteam_test_work_foodies.universalComponents.FixedButton
import com.example.ntiteam_test_work_foodies.universalComponents.TopBar

@Composable
fun BasketScreen() {
    Basket()
}

@Preview
@Composable
fun Basket() {
    val basketItems = listOf(
        BasketItem(R.drawable.photo_basket_1_image, "Том Ям", "800", "720"),
        BasketItem(
            R.drawable.photo_basket_2_image,
            "Бургер с кучей овощей и чеддером",
            "800",
            null
        ),
        BasketItem(
            R.drawable.photo_basket_3_image,
            "Кусок пиццы с соусом песто и оливками",
            "800",
            null
        ),
        BasketItem(R.drawable.photo_basket_3_image, "Ролл Сяки Маки", "800", "720")
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
                .background(Color.White)
        )
        TopBar()
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .align(Alignment.CenterHorizontally)
//        ) {
//            Text(
//                text = "Пусто, выберите блюда \n в каталоге :)",
//                style = TextStyle(
//                    fontSize = 16.sp,
//                    color = Color.Black,
//                    textAlign = TextAlign.Center,
//                    fontFamily = FontFamily(Font(R.font.roboto_regular))
//                ),
//                modifier = Modifier
//                    .align(Alignment.Center)
//                    .alpha(0.6f)
//            )
//        }
        if (basketItems == null) { //если пользователь удяляет блюдо из карзины, то текст появляется
            Text(
                text = "Пусто, выберите блюда \n в каталоге :)",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .alpha(0.6f)
            )
        } else {
            LazyColumn {
                items(basketItems) { item ->
                    ListItemBasket(
                        imageItem = painterResource(id = item.image),
                        titleItem = item.title,
                        textPriceItem = item.price,
                        textSalePriceItem = item.salePrice
                    )
                }
            }
        }
        if (basketItems != null) { //если пользователь удяляет блюдо из карзины, то кнопку исчезает
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .navigationBarsPadding()
                    .fillMaxSize()
            ) {
                FixedButton(
                    textTotalPrice = "2 160",
                    painterCard = null,
                    textInCard = "Заказать за"
                )
            }
        }
    }
}


@Composable
fun ListItemBasket(
    imageItem: Painter,
    titleItem: String,
    textPriceItem: String,
    textSalePriceItem: String?
) {
    var countAddCard by remember { mutableStateOf(1) }
    if (countAddCard > 0) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(height = 128.dp)
                .padding(16.dp)
        ) {
            Image(
                painter = imageItem,
                contentDescription = null,
                modifier = Modifier
                    .size(96.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding()
            ) {
                Text(
                    text = titleItem,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Black,
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                    ),
                    modifier = Modifier
                        .alpha(0.87f)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ) {
                    CounterBasket(
                        countAddCard = countAddCard,
                        newCountAddCard = { newCountAddCount -> countAddCard = newCountAddCount })
                    TextPriceBasket(textPrice = textPriceItem, textSalePrice = textSalePriceItem)
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.3f)
                .height(1.dp)
                .background(Color.Gray)
        )
    }
}


@Composable
fun TextPriceBasket(
    textPrice: String,
    textSalePrice: String?
) {
    Column(
        horizontalAlignment = Alignment.End
    ) {
        if (textSalePrice != null) {
            Text(
                text = "$textSalePrice ₽",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto_medium)
                    ),
                ),
                modifier = Modifier.alpha(0.87f)
            )
        }
        Text(
            text = "$textPrice ₽",
            color = Color.Black,
            style = TextStyle(
                fontSize = if (textSalePrice != null) 14.sp else 16.sp,
                fontFamily = FontFamily(
                    Font(R.font.roboto_medium)
                ),
                textDecoration = if (textSalePrice != null) TextDecoration.LineThrough else null
            ),
            modifier = Modifier
                .alpha(if (textSalePrice != null) 0.6f else 0.87f)
        )
    }
}

@Composable
fun CounterBasket(
    countAddCard: Int,
    newCountAddCard: (Int) -> Unit
) {
    var counterCountAddCard by remember { mutableStateOf(countAddCard) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                counterCountAddCard--
                newCountAddCard(counterCountAddCard)
            }) {
            AddCardItem(
                colorItem = Gray,
                iconItem = painterResource(id = R.drawable.minus_icon),
            )
        }
        Text(
            text = countAddCard.toString(),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium))
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        Box(
            modifier = Modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                counterCountAddCard++
                newCountAddCard(counterCountAddCard)
            }) {
            AddCardItem(
                colorItem = Gray,
                iconItem = painterResource(id = R.drawable.plus_icon),
            )
        }
    }
}