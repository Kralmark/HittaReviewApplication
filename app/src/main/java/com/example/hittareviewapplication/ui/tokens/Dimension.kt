package com.example.hittareviewapplication.ui.tokens

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

interface Dimension {

    enum class IntValue(val value: Int) {
        _0(0),
        _1(1),
        _2(2),
        _4(4),
        _8(8),
        _12(12),
        _16(16),
        _24(24),
        _32(32),
        _80(80),
        _96(96)
    }

    enum class Size(val value: Dp) {
        _8(IntValue._8.value.dp),
        _16(IntValue._16.value.dp),
        _32(IntValue._32.value.dp),
        _80(IntValue._80.value.dp),

    }

    enum class Padding(val value: Dp) {
        _0(IntValue._0.value.dp),
        _1(IntValue._1.value.dp),
        _4(IntValue._4.value.dp),
        _8(IntValue._8.value.dp),
        _16(IntValue._16.value.dp),
        _24(IntValue._24.value.dp),
        _32(IntValue._32.value.dp),
        _96(IntValue._96.value.dp),
    }

}