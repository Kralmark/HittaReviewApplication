package com.example.hittareviewapplication.ui.atoms
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.hittareviewapplication.ui.types.HeaderType

class Header {
    data class Props(
        val type: HeaderType,
        val text: String)
}

/**
 * Header with text and style.
 */
@Composable
fun Header(props: Header.Props) {
    Text(
        text = props.text,
        style = TextStyle(fontSize = props.type.value.sp)
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Column {
        Header(props = Header.Props(HeaderType._1, "Header type one"))
        Header(props = Header.Props(HeaderType._2, "Header type two"))
        Header(props = Header.Props(HeaderType._3, "Header type three"))
    }

}