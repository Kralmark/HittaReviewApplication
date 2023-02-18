package com.example.hittareviewapplication.ui.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.hittareviewapplication.R
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.ui.atoms.Header
import com.example.hittareviewapplication.ui.atoms.HeaderBase
import com.example.hittareviewapplication.ui.atoms.HeaderType
import com.example.hittareviewapplication.ui.molecules.UserIcon
import com.example.hittareviewapplication.ui.templates.ReviewsTemplate
import com.example.hittareviewapplication.ui.tokens.Dimension.*

/**
 * A review post containing icon, name, stars and a body text.
 */
@Composable
fun Review(review: ReviewsTemplate.Review) {
    Row(
        modifier = Modifier
            .padding(vertical = Padding._16.value)
    ) {
        // Render user icon
        UserIcon()
        Spacer(
            modifier = Modifier
            .size(Size._16.value),
        )
        // Render name, stars and comment
        Column {
            Header(
                props = HeaderBase.Props(
                    type = HeaderType._2,
                    text = review.userName
                )
            )
            Row {
                StarButtonRow(
                    model = StarButtonRow.Model(
                        iconSize = Size._8,
                        iconPadding = Padding._1,
                        unselectedIconRes = R.drawable.ic_five_pointed_star_outline,
                        selectedIconRes = R.drawable.ic_five_pointed_star_filled,
                        rating = remember { mutableStateOf(review.score)},
                        onClick = { },
                    )
                )
                /*Text(
                modifier = Modifier.wrapContentHeight(),
                text = "review.date.toString()")*/
            }
            Text(review.comment)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Review(review = ReviewsTemplate.createMockModel(remember { mutableStateOf(0) }).reviews[0])
}
