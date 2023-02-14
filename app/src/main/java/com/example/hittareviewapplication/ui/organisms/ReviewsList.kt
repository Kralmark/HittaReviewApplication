package com.example.hittareviewapplication.ui.organisms

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.ui.atoms.Divider
import com.example.hittareviewapplication.ui.templates.ReviewsTemplate

/**
 * List containing reviews.
 */
@Composable
fun ReviewsList(list: List<ReviewsTemplate.Review>?) {
    LazyColumn(content = {
        list?.forEachIndexed(action = { index: Int, review: ReviewsTemplate.Review ->
            item { Review(review) }
            if(index != list.lastIndex) {
                item { Divider() }
            }
        })
    })
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ReviewsList(list = ReviewsTemplate.createMockModel().reviews)
}
