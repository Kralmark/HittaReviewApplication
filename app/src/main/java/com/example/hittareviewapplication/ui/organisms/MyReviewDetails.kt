package com.example.hittareviewapplication.ui.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.ui.atoms.Divider
import com.example.hittareviewapplication.ui.tokens.Dimension.*

class MyReviewDetails {

    data class Model(
        var name: MutableState<String>,
        var details: MutableState<String>
    )
}

/**
 * Review coming from "me" (the actual user) with icon, clickable stars and text (TODO)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyReviewDetails(model: MyReviewDetails.Model) {

    // All content on one row with some vertical padding.
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(vertical = Padding._16.value)
    ) {

        // Column containing stars, stars comment, "my" name and editable text details
        Column {
            StarButtonRow(model = StarButtonRow.Model(
                nbrSelected = 3,
                nbrStars = 5,
                selectedIconRes = R.drawable.ic_five_pointed_star_filled,
                unselectedIconRes = R.drawable.ic_five_pointed_star_outline,
                rating = remember { mutableStateOf(5) },
                isSelectable = true))

            Divider()
            TextField(
                value = model.name.value,
                enabled = true,
                onValueChange = {model.name.value = it},
                label = {},
                modifier = Modifier.fillMaxWidth())

            Divider()
            TextField(
                value = model.details.value,
                enabled = true,
                onValueChange = {model.details.value = it},
                label = {},
                modifier = Modifier.fillMaxWidth())
            Divider()
        }
    }
}

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditableTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        enabled = true,
        onValueChange = onValueChange,
        label = {},
        modifier = Modifier.fillMaxWidth()
    )
}*/

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MyReview(R.drawable.ic_user_icon)
}