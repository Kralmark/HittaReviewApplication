package com.example.hittareviewapplication.ui.molecules

import android.util.Log
import androidx.compose.foundation.layout.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.ui.atoms.Icon
import com.example.hittareviewapplication.ui.tokens.Dimension.*

class IconButtonRow {
    data class Model(val iconButtons: List<IconButton.Model>)
}

/**
 * A row of icons that are clickable.
 */
@Composable
fun IconButtonRow(model: IconButtonRow.Model) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.CenterVertically)
            .fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
            ) {
                for(iconButton in model.iconButtons) {
                    IconButton(iconButton)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    val icon = IconButton.Model(
        iconProps = Icon.Props(
            resId = R.drawable.ic_five_pointed_star_outline,
            padding = Padding._8
        ),
        onClick = { Log.d("IconButtonRow","IconButtonRow clicked")}
    )
    IconButtonRow(IconButtonRow.Model(mutableListOf(icon, icon, icon)))
}