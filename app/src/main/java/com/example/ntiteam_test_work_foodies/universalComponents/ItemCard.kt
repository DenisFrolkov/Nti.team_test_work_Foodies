package com.example.ntiteam_test_work_foodies.universalComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ntiteam_test_work_foodies.R
import com.example.ntiteam_test_work_foodies.ui.theme.Gray

@Composable
fun ItemCard(
    textName: String,
    textWeight: String,
    textPrice: String,
    textSalePrice: String?
) {
    var countAddCard by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .background(color = Gray, shape = RoundedCornerShape(8.dp))
    ) {
        if (textSalePrice != null) {
            Box(modifier = Modifier.padding(8.dp)) {
                IconSaleItem(painterResource(id = R.drawable.sale_icon))
            }
        }
        Column {
            Image(
                painter = painterResource(id = R.drawable.photo_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                Text(
                    text = textName,
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = textWeight,
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(
                            Font(R.font.roboto_regular)
                        ),
                    ),
                    modifier = Modifier.alpha(0.6f)
                )
                if (countAddCard == 0) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {
                                countAddCard++
                            }
                    ) {
                        if (textSalePrice != null) {
                            Text(
                                text = "$textSalePrice ₽",
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(
                                        Font(R.font.roboto_medium)
                                    ),
                                ),
                                modifier = Modifier.padding(vertical = 12.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                        Text(
                            text = "$textPrice ₽",
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(
                                    Font(R.font.roboto_medium)
                                ),
                                textDecoration = if (textSalePrice != null) TextDecoration.LineThrough else null
                            ),
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                                .alpha(if (textSalePrice != null) 0.6f else 1f)
                        )
                    }
                } else {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                    ) {
                        Box(modifier = Modifier.clickable { countAddCard-- }) {
                            AddCardItem(
                                iconItem = painterResource(id = R.drawable.minus_icon),
                            )
                        }
                        Text(
                            text = countAddCard.toString(),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium))
                            )
                        )
                        Box(modifier = Modifier.clickable { countAddCard++ }) {
                            AddCardItem(
                                iconItem = painterResource(id = R.drawable.plus_icon),
                            )
                        }
                    }
                }
            }
        }
    }
}