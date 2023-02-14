package com.example.hittareviewapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import com.example.hittareviewapplication.api.models.ReviewDTO
import com.example.hittareviewapplication.api.service.RetrofitServiceImpl
import com.example.hittareviewapplication.ui.templates.MyReviewTemplate
import com.example.hittareviewapplication.ui.theme.HittaReviewTheme
import com.example.hittareviewapplication.ui.templates.ReviewsTemplate

class MainActivity : ComponentActivity() {

    companion object {
        const val id = "ctyfiintu"
        const val score = 4.1f
        const val fromRatings = "from 27 ratings"
        const val link = "View all reviews"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RenderContent()
        }
    }

    fun downloadData() {
        RetrofitServiceImpl().getCompanyName(id)
    }

    fun postData() {
        RetrofitServiceImpl().postReview(
            ReviewDTO(
                companyId = id,
                comment = "A comment",
                score = 3,
            )
        )
    }
}


@Composable
fun RenderContent() {
    HittaReviewTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .wrapContentSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                ReviewsTemplate(ReviewsTemplate.createMockModel())
                Divider()

                MyReviewTemplate(MyReviewTemplate.Model(
                    userName = "Your name",
                    comment = "Add more details on your experience...",
                    score = 4,
                    reviewElement = "Waan Thai"
                ))

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RenderContent()
}