package com.hd.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hd.calculator.ui.theme.LightGray
import com.hd.calculator.ui.theme.MediumGray
import com.hd.calculator.ui.theme.Orange

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier,
    onAction: (CalculatorActions)->Unit
){
    Box(modifier = modifier){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(MediumGray),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            val displayText = if (state.number2.isBlank()) {
                state.number1
            } else {
                state.number2
            }


            Text(text = displayText,
            //Text(text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 60.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
                )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(symbol = "AC", modifier = Modifier
                    .background(LightGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    }
                )
                CalculatorButton(symbol = "⌫", modifier = Modifier
                    .background(LightGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Delete)
                    }
                )
                CalculatorButton(symbol = "%", modifier = Modifier
                    .background(LightGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Percentage))
                    }
                )
                CalculatorButton(symbol = "÷", modifier = Modifier
                    .background(if (state.operation == CalculatorOperation.Divide) Color.White else Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Divide))
                    },
                    isOperator = true,
                    isPressed = state.operation == CalculatorOperation.Divide
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "7", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(7))
                    }
                )
                CalculatorButton(symbol = "8", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(8))
                    }
                )
                CalculatorButton(symbol = "9", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(9))
                    }
                )
                CalculatorButton(symbol = "x", modifier = Modifier
                    .background(if (state.operation == CalculatorOperation.Multiply) Color.White else Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Multiply))
                    },
                    isOperator = true,
                    isPressed = state.operation == CalculatorOperation.Multiply
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "4", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(4))
                    }
                )
                CalculatorButton(symbol = "5", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(5))
                    }
                )
                CalculatorButton(symbol = "6", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(6))
                    }
                )
                CalculatorButton(symbol = "-", modifier = Modifier
                    .background(if (state.operation == CalculatorOperation.Subtract) Color.White else Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Subtract))
                    },
                    isOperator = true,
                    isPressed = state.operation == CalculatorOperation.Subtract
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "1", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(1))
                    }
                )
                CalculatorButton(symbol = "2", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(2))
                    }
                )
                CalculatorButton(symbol = "3", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(3))
                    }
                )
                CalculatorButton(symbol = "+", modifier = Modifier
                    .background(if (state.operation == CalculatorOperation.Add) Color.White else Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculatorOperation.Add))
                    },
                    isOperator = true,
                    isPressed = state.operation == CalculatorOperation.Add
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "0", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(2f)
                    .weight(2f),
                    onClick = {
                        onAction(CalculatorActions.Number(0))
                    }
                )
                CalculatorButton(symbol = ".", modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Decimal)
                    }
                )
                CalculatorButton(symbol = "=", modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Calculate)
                    }
                )
            }
        }
    }
}