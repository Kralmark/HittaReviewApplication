package com.example.hittareviewapplication.ui.atoms
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.hittareviewapplication.ui.interfaces.Renderable
import com.example.hittareviewapplication.ui.tokens.Dimension

enum class BodyType(val value: Int) {
    _1(12),
    _2(14)
}

abstract class BodyBase {
    data class Props(
        val type: BodyType,
        val text: String,
        val textAlign: TextAlign = TextAlign.Start
    )
}

class BodyRenderable(val model: Props): BodyBase(), Renderable {
    @Composable
    override fun RenderElement(model: Any) {
        Body(props = model as Props)
    }

    override fun getModel(): Any {
        return model
    }
}

/**
 * Header with text and style.
 */
@Composable
fun Body(props: BodyBase.Props) {
    androidx.compose.material3.Text(
        text = props.text,
        style = TextStyle(fontSize = props.type.value.sp),
        modifier = Modifier
            .padding(bottom = Dimension.Padding._16.value),
        textAlign = props.textAlign
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Column {
        Body(props = BodyBase.Props(BodyType._1, "Body type one"))
        Body(props = BodyBase.Props(BodyType._2, "Body type two"))
    }

}