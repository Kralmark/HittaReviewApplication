package com.example.hittareviewapplication.ui.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.MainActivity
import com.example.hittareviewapplication.ui.organisms.MyReviewDetails
import com.example.hittareviewapplication.ui.tokens.Dimension

class MyReviewTemplate {
    data class Model(
        val ratingState: MutableState<Int>,
        val userNameState: MutableState<String>,
        val commentState: MutableState<String>
    )
}
/**
 * Template containing top buttons and "Review ..." header, stars, rate description,
 * editable text for "my" name and for "my" experience.
 */
@Composable
fun MyReviewTemplate(model: MyReviewTemplate.Model) {
    Column(modifier = Modifier
        .padding(
            vertical = Dimension.Padding._16.value,
            horizontal = Dimension.Padding._16.value
        )
        .background(color = MaterialTheme.colorScheme.background)) //TODO
    {
        MyReviewDetails(model = MyReviewDetails.Model(
            ratingState = model.ratingState,
            commentState = model.commentState,
            userNameState = model.userNameState)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MyReviewTemplate(model = MyReviewTemplate.Model(
        ratingState = MainActivity.getModel().ratingState,
        userNameState = MainActivity.getModel().userNameState,
        commentState = MainActivity.getModel().commentState
    ))
}


