package com.example.hittareviewapplication.ui.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.ui.atoms.Icon
import com.example.hittareviewapplication.ui.tokens.Dimension.*

class IconButton {
    data class Model(
        val iconProps: Icon.Props,
        val onClick: () -> Unit
    )
}

/**
 * Clickable button containing an icon.
 */
@Composable
fun IconButton(model: IconButton.Model) {
    Box(modifier = Modifier
        .clickable(
            interactionSource = MutableInteractionSource(),
            indication = null
        ) {
            model.onClick()
        },
        content = { Icon(model.iconProps) })
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    IconButton(
        model = IconButton.Model(
            iconProps = Icon.Props(
                R.drawable.ic_five_pointed_star_outline,
                Padding._8,
                tintResId = R.color.secondary),
            onClick = { }
        )
    )
}