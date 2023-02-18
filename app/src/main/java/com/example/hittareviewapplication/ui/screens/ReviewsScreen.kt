package com.example.hittareviewapplication.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.MainActivity
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.api.service.MockServiceImpl
import com.example.hittareviewapplication.ui.organisms.ReviewScore
import com.example.hittareviewapplication.ui.screens.destinations.MyReviewScreenDestination
import com.example.hittareviewapplication.ui.templates.ReviewsTemplate
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * Template containing my review (header, stars, stars my name and a comment) and other reviews
 * in a list below my review.
 */
@RootNavGraph(start = true)
@Destination
@Composable
fun ReviewsScreen(navigator: DestinationsNavigator) {

    ReviewsTemplate(
        model = ReviewsTemplate.Model(
            reviewScore = ReviewScore.Model(
                value = MainActivity.score,
                fromRatings = MainActivity.fromRatings,
                link = MainActivity.link,
            ),
            iconRes = R.drawable.ic_user_icon,
            onClick = {
                navigator.navigate(MyReviewScreenDestination())
            },
            reviews = MockServiceImpl().getReviews(),
            header = "Reviews",
            ratingState = MainActivity.getModel().ratingState
    ))

}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ReviewsTemplate(model = ReviewsTemplate.createMockModel(remember { mutableStateOf(0) }))
}
