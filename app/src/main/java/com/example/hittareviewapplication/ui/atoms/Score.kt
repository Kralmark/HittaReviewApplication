package com.example.hittareviewapplication.ui.atoms


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hittareviewapplication.ui.tokens.Dimension.*
import com.example.hittareviewapplication.ui.types.ColorType
import com.example.hittareviewapplication.ui.types.ColorType.WARNING

/**
 * Component showing a score (similar to a badge).
 */
class Score {
    data class Model(
        val score: Float = 0f,
        val backgroundType: ColorType = WARNING
    )
}

@Composable
fun Score(model: Score.Model) {
    Surface(
        shape = RoundedCornerShape(IntValue._8.value.dp),
        color = Color(model.backgroundType.value)){
            Text(modifier = Modifier.padding(Padding._4.value),
                text = model.score.toString())
    }
}

private fun createModel(): Score.Model {
    return Score.Model( 4.1f, WARNING)
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Score(createModel())
}