package com.example.hittareviewapplication.ui.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.ui.atoms.Header
import com.example.hittareviewapplication.ui.molecules.UserIcon
import com.example.hittareviewapplication.ui.tokens.Dimension.*
import com.example.hittareviewapplication.ui.types.HeaderType

/**
 * Review coming from "me" (the actual user) with icon and clickable stars.
 */
@Composable
fun MyReview(iconRes: Int) {

    // All content on one row with some vertical padding.
    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(vertical = Padding._16.value)
    ) {
        UserIcon(iconRes)
        Spacer(
            modifier = Modifier
                .size(Size._16.value),
        )
        // Column containing header, body and row of stars.
        Column {
            Header(props = Header.Props(
                text = "Rate and review",
                type = HeaderType._2
            ))
            Text(text = "Share your experiences to help others")
            StarButtonRow(model = StarButtonRow.Model(
                nbrSelected = 3,
                nbrStars = 5,
                selectedIconRes = R.drawable.ic_five_pointed_star_filled,
                unselectedIconRes = R.drawable.ic_five_pointed_star_outline,
                rating = remember { mutableStateOf(5) },
                isSelectable = true))

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MyReview(R.drawable.ic_user_icon)
}