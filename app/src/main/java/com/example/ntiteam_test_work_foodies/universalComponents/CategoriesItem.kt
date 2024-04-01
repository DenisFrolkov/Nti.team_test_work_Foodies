package com.example.ntiteam_test_work_foodies.universalComponents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ntiteam_test_work_foodies.R
import com.example.ntiteam_test_work_foodies.ui.theme.Orange

@Composable
fun CategoriesItem(
    categoriesTitle: String,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    val isSelected = selectedCategory == categoriesTitle
    val backgroundColor by animateColorAsState(if (isSelected) Orange else Color.White)
    val textColor by animateColorAsState(if (isSelected) Color.White else Color.Black)

    Box(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onCategorySelected(categoriesTitle) }
    ) {
        Text(
            text = categoriesTitle,
            color = textColor,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium))
            ),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
        )
    }
}



