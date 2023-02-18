package com.example.hittareviewapplication.ui.organisms

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.MainActivity
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.ui.atoms.Header
import com.example.hittareviewapplication.ui.atoms.HeaderBase
import com.example.hittareviewapplication.ui.atoms.HeaderType
import com.example.hittareviewapplication.ui.molecules.UserIcon
import com.example.hittareviewapplication.ui.templates.ReviewsTemplate
import com.example.hittareviewapplication.ui.tokens.Dimension.*

class MyReview
{
    data class Model(
        val iconRes: Int,
        val ratingState: MutableState<Int>,
        val onClick: (value: Int) -> Unit
    )
}
/**
 * Review coming from "me" (the actual user) with icon and clickable stars.
 */
@Composable
fun MyReview(model: MyReview.Model) {
    if(model.ratingState.value <= 0) {
        RateAndReview(model)
    } else {
        RenderMyReview(model )
    }
}

/**
 * The way to render when "I" have set a rating/score.
 */
@Composable
fun RenderMyReview(model: MyReview.Model) {
    Review(ReviewsTemplate.Review(
        userName = MainActivity.applicationState!!.userNameState.value,
        score = MainActivity.applicationState!!.ratingState.value,
        comment = MainActivity.applicationState!!.commentState.value,
        isMyReview = true,
        userIcon = model.iconRes,
        date = MainActivity.applicationState!!.timestampState.value
    ))
}

/**
 * The way to render when "I" don't have set any rating/score.
 */
@Composable
fun RateAndReview(model: MyReview.Model) {
// All content on one row with some vertical padding.
    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(vertical = Padding._16.value)
    ) {
        UserIcon(model.iconRes)
        Spacer(
            modifier = Modifier
                .size(Size._16.value),
        )
        // Column containing header, body and row of stars.
        Column {
            Header(
                props = HeaderBase.Props(
                    text = "Rate and review",
                    type = HeaderType._2
                )
            )
            Text(text = "Share your experiences to help others")

            // Stars and some space on the right side
            Box(
                modifier = Modifier
                    .padding(end = Padding._32.value)
            ) {
                StarButtonRow(
                    model = StarButtonRow.Model(
                        selectedIconRes = R.drawable.ic_five_pointed_star_filled,
                        unselectedIconRes = R.drawable.ic_five_pointed_star_outline,
                        rating = model.ratingState,
                        isSelectable = true,
                        arrangement = Arrangement.SpaceBetween,
                        onClick = { model.onClick(it)},
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MyReview(
        model = MyReview.Model(
            iconRes = R.drawable.ic_user_icon,
            ratingState = remember { mutableStateOf(3) },
            onClick = { },
        )
    )
}