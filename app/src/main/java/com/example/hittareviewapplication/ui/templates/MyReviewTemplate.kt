package com.example.hittareviewapplication.ui.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.MainActivity
import com.example.hittareviewapplication.ui.organisms.MyReviewDetails
import com.example.hittareviewapplication.ui.tokens.Dimension

/**
 * Template containing top buttons and "Review ..." header, stars, rate description,
 * editable text for "my" name and for "my" experience.
 */
@Composable
fun MyReviewTemplate(model: MainActivity.Model) {
    Column(modifier = Modifier
        .padding(
            vertical = Dimension.Padding._16.value,
            horizontal = Dimension.Padding._16.value)
        .background(color = MaterialTheme.colorScheme.background)) //TODO
    {
        MyReviewDetails(model = model)
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MyReviewTemplate(model = MainActivity.createModel())
}


