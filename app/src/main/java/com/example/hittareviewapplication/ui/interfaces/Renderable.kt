package com.example.hittareviewapplication.ui.interfaces

import androidx.compose.runtime.Composable

/**
 * Interface that can be used in order to have unknown UI elements in a list and let them
 * render themselves as the interface is implemented.
 * TODO: Look into taking a Composable as a parameter instead
 */
interface Renderable {
    @Composable
    fun RenderElement(model: Any)
    fun getModel(): Any
}