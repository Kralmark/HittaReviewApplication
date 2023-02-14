package com.example.hittareviewapplication.ui.organisms

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.ui.atoms.Score
import com.example.hittareviewapplication.ui.templates.ReviewsTemplate
import com.example.hittareviewapplication.ui.tokens.Dimension.*

/**
 * Component showing a score and a text on the left side. A clickable text on the right side.
 */
class ReviewScore {

    data class Model(
        val value: Float,
        val fromRatings: String,
        val link: String
    )
}

@Composable
fun ReviewScore(model: ReviewScore.Model) {
    // All content displayed on a row
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = Padding._16.value),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Left side showing score and number of ratings
        Column(
            modifier = Modifier.wrapContentSize()
        ) {
            Row(modifier = Modifier
                .align(Alignment.Start),
                horizontalArrangement = Arrangement.spacedBy(Padding._16.value),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Score(model = Score.Model(model.value))
                Text(text = model.fromRatings)
            }
        }
        // Right side showing primary colored text
        Text(
            text = model.link,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable {
                        Log.d(ReviewScore::class.toString(), "Clicked link")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewScorePreview() {
    ReviewScore(model = ReviewsTemplate.createMockModel().reviewScore)
}
