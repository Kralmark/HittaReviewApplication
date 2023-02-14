package com.example.hittareviewapplication.ui.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.MainActivity
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.ui.atoms.Divider
import com.example.hittareviewapplication.ui.tokens.Dimension.*

/**
 * Review coming from "me" (the actual user) with clickable stars, a descriptive text,
 * "my" name and "my" comment.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyReviewDetails(model: MainActivity.Model) {

    // All content on one row with some vertical padding.
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
    ) {

        // Column containing stars, stars comment, "my" name and editable text details
        Column {
            StarButtonRow(model = StarButtonRow.Model(
                selectedIconRes = R.drawable.ic_five_pointed_star_filled,
                unselectedIconRes = R.drawable.ic_five_pointed_star_outline,
                rating = model.ratingState,
                isSelectable = true,
                arrangement = Arrangement.Center))

            // Describing text based on star rating
            Text(
                text = getRatingText(model.ratingState.value),
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .padding(all = Padding._16.value)
                    .align(alignment = Alignment.CenterHorizontally))
            Divider()

            // Name text field
            TextField(
                value = model.userNameState.value,
                textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
                enabled = true,
                onValueChange = {model.userNameState.value = it},
                label = {Text("Your name")},
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth())

            Divider()

            // Comment text field
            TextField(
                value = model.commentState.value,
                textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
                enabled = true,
                onValueChange = {model.commentState.value = it},
                label = { Text("Add more details on your experience...")},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Size._80.value))

            Divider()
        }
    }
}

fun getRatingText(nbrStars: Int): String {
    return when(nbrStars) {
        5 -> "I loved it"
        4 -> "I liked it"
        3 -> "It was OK"
        2 -> "I didn't like it"
        1 -> "I hated it"
        else -> ""
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    val ratingState = remember { mutableStateOf(0) }
    MyReview(model = MyReview.Model(
        iconRes = R.drawable.ic_user_icon,
        ratingState = ratingState,
        onClick = { }
    ))
}