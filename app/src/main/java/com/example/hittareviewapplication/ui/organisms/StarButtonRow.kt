package com.example.hittareviewapplication.ui.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.ui.atoms.Icon
import com.example.hittareviewapplication.ui.molecules.IconButton
import com.example.hittareviewapplication.ui.molecules.IconButtonRow
import com.example.hittareviewapplication.ui.tokens.Dimension.*

class StarButtonRow {
    data class Model(
        val nbrStars: Int = 5,
        val iconSize: Size = Size._32,
        val iconPadding: Padding = Padding._8,
        val selectedIconRes: Int,
        val unselectedIconRes: Int,
        var rating: MutableState<Int>,
        val isSelectable: Boolean = false,
        val arrangement: Arrangement.Horizontal = Arrangement.Start
    )
}

/**
 * A component showing a row of stars (default is five stars).
 */
@Composable
fun StarButtonRow(model: StarButtonRow.Model) {

    // Render a row of star icons and set the rating from the modelmodel
    IconButtonRow(
        model = IconButtonRow.Model(
            arrangement = model.arrangement,
            iconButtons = List(model.nbrStars) { index ->
            val isSelected = model.rating.value > index
            val iconProps = Icon.Props(
                resId = if(isSelected) model.selectedIconRes else model.unselectedIconRes,
                size = model.iconSize,
                padding = model.iconPadding,
                tintResId = getTintResourceId(isSelected)
            )

            IconButton.Model(
                iconProps = iconProps,
                onClick = {
                    if(model.isSelectable) {
                        model.rating.value = index + 1
                        if (model.rating.value > 0) {
                            iconProps.tintResId = getTintResourceId(
                                isSelected = model.rating.value > index
                            )
                        }
                    }
                }
            )
        }
    ))
}

/**
 * Get the resource id for the tint color depending on if it is selected or not
 */
fun getTintResourceId(isSelected: Boolean): Int {
    return if(isSelected) R.color.accent else R.color.secondary
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    StarButtonRow(model = StarButtonRow.Model(
        selectedIconRes = R.drawable.ic_five_pointed_star_filled,
        unselectedIconRes = R.drawable.ic_five_pointed_star_filled,
        rating = remember { mutableStateOf(0) }
    ))
}
