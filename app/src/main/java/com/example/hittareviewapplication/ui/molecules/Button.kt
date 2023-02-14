package com.example.hittareviewapplication.ui.molecules

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.ui.interfaces.Renderable
import com.example.hittareviewapplication.ui.tokens.Dimension

class ButtonRenderable(val model: Model): Renderable {

    data class Model(
        val text: String,
        val onClick: () -> Unit,
        val color: Color? = Color.Black,
        val backgroundColor: Color? = Color.White,
        val paddingValues: PaddingValues = PaddingValues(Dimension.Padding._16.value)
    )
    @Composable
    override fun RenderElement(model: Any) {
        Button(model as Model)
    }

    override fun getModel(): Any {
        return model
    }
}

@Composable
fun Button(model: ButtonRenderable.Model) {
    Text(
        text = model.text,
        color = model.color!!, // TODO
        modifier = Modifier
            .clickable { model.onClick() }
            .wrapContentSize(Alignment.Center)
            .background(color = Color.Transparent) // TODO
            .padding(model.paddingValues)
    )

}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Button(model = ButtonRenderable.Model(
        text = "Button",
        onClick = { Log.d("Button", "Clicked") }
    ))
}