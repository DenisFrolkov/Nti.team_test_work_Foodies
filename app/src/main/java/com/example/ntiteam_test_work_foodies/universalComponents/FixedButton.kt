package com.example.ntiteam_test_work_foodies.universalComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ntiteam_test_work_foodies.R
import com.example.ntiteam_test_work_foodies.ui.theme.Gray
import com.example.ntiteam_test_work_foodies.ui.theme.Orange

@Composable
fun FixedButton(
    textTotalPrice: String,
    painterCard: Painter?,
    textInCard: String,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                if (textInCard == "Заказать за") navController.navigate("catalog_screen") else navController.navigate("basket_screen")
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = Orange, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .padding(vertical = 15.67.dp)
        ) {
            if (painterCard != null) {
                Icon(
                    painter = painterCard,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
            Text(
                text = if (painterCard == null) "$textInCard $textTotalPrice ₽" else "$textTotalPrice ₽",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.roboto_medium))
                )
            )
        }
    }
}