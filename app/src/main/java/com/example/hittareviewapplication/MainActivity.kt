package com.example.hittareviewapplication

import android.os.Bundle
import android.util.Log
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

import com.example.hittareviewapplication.api.models.ReviewDTO
import com.example.hittareviewapplication.api.service.RetrofitServiceImpl
import com.example.hittareviewapplication.ui.screens.NavGraphs
import com.example.hittareviewapplication.ui.screens.ReviewsScreen
import com.example.hittareviewapplication.ui.templates.MyReviewTemplate
import com.example.hittareviewapplication.ui.theme.HittaReviewTheme
import com.example.hittareviewapplication.ui.templates.ReviewsTemplate
import com.example.hittareviewapplication.ui.tokens.Dimension
import com.ramcosta.composedestinations.DestinationsNavHost
import java.time.Instant
import java.util.*

class MainActivity : ComponentActivity() {

    data class Model(
        val ratingState: MutableState<Int>,
        val userNameState: MutableState<String>,
        val commentState: MutableState<String>,
        val timestampState: MutableState<Date>,
        var companyName: String? = null
    )

    companion object {
        const val id = "ctyfiintu"
        const val score = 4.1f
        const val fromRatings = "from 27 ratings"
        const val link = "View all reviews"
        var model: Model? = null
        @Composable
        fun createModel(): Model {
            if (model == null) {
                model = Model(
                    ratingState = remember { mutableStateOf(0) },
                    userNameState = remember { mutableStateOf("") },
                    commentState = remember { mutableStateOf("") },
                    timestampState = remember { mutableStateOf(Date.from(Instant.now())) }
                )
            }
            return model!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        downloadData()
        setContent {
            Surface(
                modifier = Modifier
                    .wrapContentSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                model = createModel()
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }

    private fun downloadData() {
        RetrofitServiceImpl().getCompanyName(id)
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