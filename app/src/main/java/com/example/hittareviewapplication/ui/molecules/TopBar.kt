package com.example.hittareviewapplication.ui.molecules

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.ui.atoms.TextRenderable
import com.example.hittareviewapplication.ui.interfaces.Renderable

class TopBar {
    data class Model(val elements: List<Renderable>)
}

@Composable
fun TopBar(model: TopBar.Model) {
    Row(modifier = Modifier
        .background(color = MaterialTheme.colorScheme.secondary) // TODO
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
            model.elements.forEach {
                it.RenderElement(it.getModel())
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    TopBar(model = TopBar.Model(
        elements = listOf(
            ButtonRenderable(model = ButtonRenderable.Model(
                text = "Close",
                color = MaterialTheme.colorScheme.background,
                onClick = { Log.d("apa1", "clicked") } //TODO: go to prev screen
            )),
            TextRenderable(model = TextRenderable.Model(
                text = "Apa"
            )),
            ButtonRenderable(model = ButtonRenderable.Model(
                text = "Save",
                color = MaterialTheme.colorScheme.background,
                onClick = { Log.d("apa2", "clicked") } //TODO: go to prev screen
            ))
        )
    ))
}