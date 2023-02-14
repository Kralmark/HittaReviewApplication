package com.example.hittareviewapplication.ui.templates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.ui.organisms.MyReviewDetails
import com.example.hittareviewapplication.ui.tokens.Dimension.Padding
//import com.ramcosta.composedestinations.annotation.Destination

class MyReviewTemplate {
    data class Model(
        val userName: String,
        val score: Int,
        val comment: String,
        val reviewElement: String
    )
}

/**
 * Template containing top buttons and "Review ..." header, stars, stars "explanation"
 * editable text for "my" name and for "my" experience.
 */
//@Destination
@Composable
fun MyReviewTemplate(model: MyReviewTemplate.Model) {
    Column(modifier = Modifier
        .padding(Padding._16.value))
    {
      MyReviewDetails(model = MyReviewDetails.Model(
          name = remember { mutableStateOf("Your name") },
          details = remember { mutableStateOf("Add more details on your experience...") }
      ))
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MyReviewTemplate(model = MyReviewTemplate.Model(
        userName = "Mattias",
        score = 3,
        comment = "Nice food and staff.",
        reviewElement = "Waan Thai"
    ))
}
