package com.example.hittareviewapplication.ui.atoms

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hittareviewapplication.ui.interfaces.Renderable
import com.example.hittareviewapplication.ui.tokens.Dimension.*

abstract class DividerBase {
    class Model(
        val thickness: Int? = IntValue._1.value,
        val color: Color? = Color.LightGray)
}

class DividerRenderable(val model: Model): DividerBase(), Renderable {
    @Composable
    override fun RenderElement(model: Any) {
        Divider(model as Model)
    }

    override fun getModel(): Any {
        return model
    }

}
/**
 * Divider for consistent look using divider from Material Design 3.
 */
@Composable
fun Divider(model: DividerBase.Model) {
    androidx.compose.material3.Divider(thickness = model.thickness!!.dp, color = model.color!!)
}

@Composable
fun Divider() {
    Divider(DividerBase.Model())
}
