package com.example.hittareviewapplication.ui.templates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.MainActivity
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.api.service.MockServiceImpl
import com.example.hittareviewapplication.ui.atoms.Divider
import com.example.hittareviewapplication.ui.atoms.Header
import com.example.hittareviewapplication.ui.organisms.ReviewScore
import com.example.hittareviewapplication.ui.organisms.MyReview
import com.example.hittareviewapplication.ui.organisms.ReviewsList
import com.example.hittareviewapplication.ui.tokens.Dimension.Padding
import com.example.hittareviewapplication.ui.types.HeaderType
//import com.ramcosta.composedestinations.annotation.Destination
import java.util.Date

class ReviewsTemplate {
    data class Model(
        val reviewScore: ReviewScore.Model,
        val iconRes: Int,
        val reviews: List<Review>
    )

    data class Review(
       val userName: String,
       val score: Int,
       val comment: String,
       val date: Date,
       val userIcon: Int = R.drawable.ic_user_icon
    )

    companion object {
        fun createMockModel(): Model {
            return Model(
                reviewScore = ReviewScore.Model(
                    value = MainActivity.score,
                    fromRatings = MainActivity.fromRatings,
                    link = MainActivity.link,
                ),
                iconRes = R.drawable.ic_user_icon,
                reviews = MockServiceImpl().getReviews()
            )
        }
    }
}

//@Destination(start = true)
/**
 * Template containing "Reviews" header, review score and a list of reviews.
 */
@Composable
fun ReviewsTemplate(model: ReviewsTemplate.Model) {
    Column(modifier = Modifier
        .padding(Padding._16.value))
    {
        Header(props = Header.Props(HeaderType._1, "Reviews"))
        ReviewScore(model = model.reviewScore)
        Divider()
        MyReview(iconRes = model.iconRes)
        Divider()
        ReviewsList(list = model.reviews)
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ReviewsTemplate(model = ReviewsTemplate.createMockModel())
}
