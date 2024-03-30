package com.example.ntiteam_test_work_foodies.universalComponents

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.ntiteam_test_work_foodies.R
import com.example.ntiteam_test_work_foodies.ui.theme.GradientColorOne
import com.example.ntiteam_test_work_foodies.ui.theme.GradientColorThree
import com.example.ntiteam_test_work_foodies.ui.theme.GradientColorTwo

@Composable
fun IconSaleItem(
    iconSale: Painter
) {
    Box(
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(50.dp)
            )
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        GradientColorOne,
                        GradientColorTwo,
                        GradientColorThree
                    ),
                )
            )
    ) {
        Icon(
            painter = iconSale,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.padding(all = 7.2.dp).size(9.6.dp)
        )
    }
}