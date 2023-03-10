package com.example.hittareviewapplication.ui.atoms
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.hittareviewapplication.ui.interfaces.Renderable
import com.example.hittareviewapplication.ui.tokens.Dimension

enum class HeaderType (val value: Int) {
    _1(20),
    _2(15),
    _3(12)
}

abstract class HeaderBase {

    data class Props(
        val type: HeaderType,
        val text: String)

}

class HeaderRenderable(val model: Props): HeaderBase(), Renderable {
    @Composable
    override fun RenderElement(model: Any) {
        Header(props = model as Props)
    }

    override fun getModel(): Any {
        return model
    }
}

/**
 * Header with text and style.
 */
@Composable
fun Header(props: HeaderBase.Props) {
    Text(
        text = props.text,
        style = TextStyle(fontSize = props.type.value.sp),
        modifier = Modifier.padding(bottom = Dimension.Padding._8.value)
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Column {
        Header(props = HeaderBase.Props(HeaderType._1, "Header type one"))
        Header(props = HeaderBase.Props(HeaderType._2, "Header type two"))
        Header(props = HeaderBase.Props(HeaderType._3, "Header type three"))
    }

}