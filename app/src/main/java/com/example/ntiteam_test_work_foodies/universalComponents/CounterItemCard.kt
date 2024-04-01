package com.example.ntiteam_test_work_foodies.universalComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ntiteam_test_work_foodies.R
import com.example.ntiteam_test_work_foodies.ui.theme.Gray

@Composable
fun CounterItemCard(
    countAddCard: Int,
    newCountAddCard: (Int) -> Unit
) {
    var counterCountAddCard by remember { mutableStateOf(countAddCard) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
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
                colorItem = Color.White,
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
                colorItem = Color.White,
                iconItem = painterResource(id = R.drawable.plus_icon),
            )
        }
    }
}