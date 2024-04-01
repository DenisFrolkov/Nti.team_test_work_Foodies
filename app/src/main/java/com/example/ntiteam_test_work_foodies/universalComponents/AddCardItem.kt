package com.example.ntiteam_test_work_foodies.universalComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.ntiteam_test_work_foodies.ui.theme.Orange

@Composable
fun AddCardItem(
    iconItem: Painter,
    colorItem: Color
) {
    Box(modifier = Modifier.background(color = colorItem, shape = RoundedCornerShape(8.dp))) {
        Icon(
            painter = iconItem,
            contentDescription = null,
            tint = Orange,
            modifier = Modifier
                .padding(all = 8.dp)
                .size(26.8.dp)
        )
    }
}