package com.example.hittareviewapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import com.example.hittareviewapplication.api.service.RetrofitServiceImpl
import com.example.hittareviewapplication.ui.screens.NavGraphs
import com.example.hittareviewapplication.ui.theme.HittaReviewTheme
import com.example.hittareviewapplication.ui.templates.ReviewsTemplate
import com.example.hittareviewapplication.ui.tokens.Dimension
import com.ramcosta.composedestinations.DestinationsNavHost
import java.time.Instant
import java.util.*

class MainActivity : ComponentActivity() {

    data class ApplicationState(
        val ratingState: MutableState<Int>,
        val userNameState: MutableState<String>,
        val commentState: MutableState<String>,
        val timestampState: MutableState<Date>,
        var companyNameState: MutableState<String>,
    )

    companion object {
        /**
         * Company id to get name for.
         */
        const val id = "ctyfiintu"
        /**
         * Mock value for score (rating).
         */
        const val score = 4.1f
        /**
         * Mock value for ratings on the company.
         */
        const val fromRatings = "from 27 ratings"
        /**
         * String for a clickable string to view all reviews.
         */
        const val link = "View all reviews"

        var applicationState: ApplicationState? = null

        @Composable
        fun getModel(): ApplicationState {
            if (applicationState == null) {
                applicationState = ApplicationState(
                    ratingState = remember { mutableStateOf(0) },
                    userNameState = remember { mutableStateOf("") },
                    commentState = remember { mutableStateOf("") },
                    timestampState = remember { mutableStateOf(Date.from(Instant.now())) },
                    companyNameState = remember { mutableStateOf("") },
                )
            }
            return applicationState!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RetrofitServiceImpl().getCompanyName(id, { } , { })
        setContent {
            applicationState = getModel()
            Surface(
                modifier = Modifier
                    .wrapContentSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                applicationState = getModel()
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HittaReviewTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .wrapContentSize()
                .padding(Dimension.Padding._16.value),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                ReviewsTemplate(ReviewsTemplate.createMockModel(remember { mutableStateOf(3) }))
            }
        }
    }
}