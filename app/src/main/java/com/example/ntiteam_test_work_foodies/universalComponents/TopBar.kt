package com.example.ntiteam_test_work_foodies.universalComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ntiteam_test_work_foodies.R
import com.example.ntiteam_test_work_foodies.ui.theme.Gray
import com.example.ntiteam_test_work_foodies.ui.theme.Orange

@Composable
fun TopBar(
    navController: NavController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) { navController.popBackStack() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_item),
                contentDescription = null,
                tint = Orange,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.width(32.dp))
        Text(
            text = "Корзина",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.inter_semi_bold))
            ),
            modifier = Modifier.alpha(0.87f)
        )
    }
}