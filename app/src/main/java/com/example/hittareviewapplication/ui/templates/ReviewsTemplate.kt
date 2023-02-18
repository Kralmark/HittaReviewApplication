package com.example.hittareviewapplication.ui.templates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.MainActivity
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.api.service.MockServiceImpl
import com.example.hittareviewapplication.ui.atoms.*
import com.example.hittareviewapplication.ui.organisms.ReviewScore
import com.example.hittareviewapplication.ui.organisms.MyReview
import com.example.hittareviewapplication.ui.organisms.ReviewsList
import com.example.hittareviewapplication.ui.tokens.Dimension
import java.util.Date

class ReviewsTemplate {
    data class Model(
        val reviewScore: ReviewScore.Model,
        val iconRes: Int,
        val header: String,
        val onClick: (value: Int) -> Unit,
        val reviews: List<Review>,
        val ratingState: MutableState<Int>
    )

    data class Review(
       val userName: String,
       val score: Int,
       val comment: String,
       val date: Date,
       val userIcon: Int = R.drawable.ic_user_icon,
       val isMyReview: Boolean = false
    )

    companion object {
        fun createMockModel(ratingState: MutableState<Int>): Model {
            return Model(
                reviewScore = ReviewScore.Model(
                    value = MainActivity.score,
                    fromRatings = MainActivity.fromRatings,
                    link = MainActivity.link,
                ),
                iconRes = R.drawable.ic_user_icon,
                onClick = { },
                reviews = MockServiceImpl().getReviews(),
                header = "Reviews",
                ratingState = ratingState
            )
        }
    }
}

/**
 * Template containing "Reviews" header, review score optionally "my" review and a list of other reviews.
 */
@Composable
fun ReviewsTemplate(model: ReviewsTemplate.Model) {
    Column(modifier = Modifier
        .padding(
            horizontal = Dimension.Padding._16.value,
            vertical = Dimension.Padding._24.value
        )
    ) {
        Header(props = HeaderBase.Props(HeaderType._1, model.header))
        ReviewScore(model = model.reviewScore)

        Divider()

        MyReview(
            model = MyReview.Model(
                iconRes = model.iconRes,
                onClick = { model.onClick(it) },
                ratingState = model.ratingState
            )
        )

        Divider()

        ReviewsList(list = model.reviews)

        Text(
            model = TextRenderable.Model(
                text = MainActivity.link,
                textAlign = TextAlign.Center
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    ReviewsTemplate(model = ReviewsTemplate.createMockModel(remember { mutableStateOf(5) },))
}
