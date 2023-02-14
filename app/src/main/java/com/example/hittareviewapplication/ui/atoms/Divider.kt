package com.example.hittareviewapplication.ui.atoms

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hittareviewapplication.ui.tokens.Dimension.*

/**
 * Divider for consistent look using divider from Material Design 3.
 */
@Composable
fun Divider(thickness: Int = IntValue._1.value, color: Color = Color.LightGray) {
    androidx.compose.material3.Divider(thickness = thickness.dp, color = color)
}