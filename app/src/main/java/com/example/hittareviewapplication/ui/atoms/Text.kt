package com.example.hittareviewapplication.ui.atoms

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.hittareviewapplication.ui.interfaces.Renderable
import com.example.hittareviewapplication.ui.tokens.Dimension

class TextRenderable(val model: Model): Renderable {
    data class Model(
        val text: String,
        val textAlign: TextAlign = TextAlign.Start
    )

    @Composable
    override fun RenderElement(model: Any) {
        Text(model as Model)
    }

    override fun getModel(): Any {
        return model
    }
}

@Composable
fun Text(model: TextRenderable.Model) {
    androidx.compose.material3.Text(
        text = model.text,
        color = MaterialTheme.colorScheme.background, //TODO
        textAlign = model.textAlign,
        modifier = Modifier
            .padding(Dimension.Padding._16.value))

}