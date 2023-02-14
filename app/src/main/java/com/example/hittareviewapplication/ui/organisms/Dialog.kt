package com.example.hittareviewapplication.ui.organisms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.ui.atoms.*
import com.example.hittareviewapplication.ui.interfaces.Renderable
import com.example.hittareviewapplication.ui.molecules.ButtonRenderable
import com.example.hittareviewapplication.ui.tokens.Dimension

class Dialog {
    data class Model(
        val elements: List<Renderable>,
        val visible: MutableState<Boolean>,
        val paddingValues: PaddingValues = PaddingValues(Dimension.Padding._16.value)
    )
}

/**
 * Generic dialog that will render content in a column.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dialog(model: Dialog.Model) {
    if (model.visible.value) {
        androidx.compose.material3.AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                model.visible.value = false
            }
        ) {
            Surface(
                modifier = Modifier
                    .wrapContentSize(),
                shape = MaterialTheme.shapes.large
            ) {
                Column(modifier = Modifier
                    .padding(model.paddingValues),
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    // Render the dialog content (elements) from the model
                    model.elements.forEach {
                        it.RenderElement(model = it.getModel())
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun Preview() {
    Dialog(model = Dialog.Model(
        visible = remember { mutableStateOf(true) },
        elements = listOf(
            HeaderRenderable(model = HeaderBase.Props(
                type = HeaderType._1,
                text = "Thank you for your review"
            )),
            BodyRenderable(model = BodyBase.Props(
                type = BodyType._1,
                text = "You're helping others make smarter decisions every day.",
                textAlign = TextAlign.Center
            )),
            DividerRenderable(model = DividerBase.Model()),
            ButtonRenderable(model = ButtonRenderable.Model(
                text = "Okay!",
                color = Color.Blue,
                paddingValues = PaddingValues(
                    start = Dimension.Padding._96.value,
                    end = Dimension.Padding._96.value,
                    top= Dimension.Padding._16.value,
                    bottom = Dimension.Padding._0.value,
                ),
                onClick = { }
            ))
        )
    ))
}