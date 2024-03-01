package com.hd.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.hd.calculator.ui.theme.Orange

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier,
    onClick: ()-> Unit,
    isPressed: Boolean = false,
    isOperator: Boolean =false
){
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .background(Color.DarkGray)
            .then(modifier)){
        Text(text = symbol,
            fontSize = 36.sp,
            color = if (isOperator && isPressed) Orange else Color.White
            )
    }
}