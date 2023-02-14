package com.example.hittareviewapplication.ui.organisms

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.ui.atoms.Icon
import com.example.hittareviewapplication.ui.molecules.IconButton
import com.example.hittareviewapplication.ui.molecules.IconButtonRow
import com.example.hittareviewapplication.ui.tokens.Dimension.*

class StarButtonRow {
    data class Model(
        var nbrSelected: Int = 0,
        val nbrStars: Int = 5,
        val iconSize: Size = Size._32,
        val iconPadding: Padding = Padding._8,
        val selectedIconRes: Int,
        val unselectedIconRes: Int,
        val isSelectable: Boolean = false,
        var rating: MutableState<Int>)
}


/**
 * A component showing a row of stars (default is five stars).
 */
@Composable
fun StarButtonRow(model: StarButtonRow.Model) {

    // Set rating from model
    model.rating.value = model.nbrSelected
    IconButtonRow(model = IconButtonRow.Model(
        iconButtons = List(model.nbrStars) { index ->
            val isSelected = model.rating.value > index
            val iconProps = Icon.Props(
                resId = if(isSelected) model.selectedIconRes else model.unselectedIconRes,
                size = model.iconSize,
                padding = model.iconPadding,
                tintResId = getTintResourceId(isSelected)
            )

            IconButton.Model(iconProps = iconProps,
                onClick = {
                    if(model.isSelectable) {
                        model.rating.value = index + 1
                        model.nbrSelected = model.rating.value
                        iconProps.tintResId = getTintResourceId(
                            isSelected = model.rating.value > index)
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
    val nbrStars = 5
    val nbrSelected =  remember { mutableStateOf(0) }

    StarButtonRow(model = StarButtonRow.Model(
        nbrSelected = nbrSelected.value,
        nbrStars = nbrStars,
        selectedIconRes = R.drawable.ic_five_pointed_star_filled,
        unselectedIconRes = R.drawable.ic_five_pointed_star_filled,
        rating = remember { mutableStateOf(4) }))
    nbrSelected.value = 4
}
