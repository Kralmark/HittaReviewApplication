package com.example.hittareviewapplication.api.service

import com.example.hittareviewapplication.ui.templates.ReviewsTemplate
import java.time.Instant
import java.util.*

//interface MockService

class MockServiceImpl {

    /**
     * Get mock review data.
     */
    fun getReviews(): List<ReviewsTemplate.Review> {
        val list = mutableListOf<ReviewsTemplate.Review>()
        list.add(
            ReviewsTemplate.Review(
                "Anonym",
                4,
                "Liked it very much - probably one of the best Thai restaurants in the city - recommend!",
                Date.from(Instant.now()),
            )
        )
        list.add(
            ReviewsTemplate.Review(
                "Jenny Svensson",
                3,
                "Maybe a bit too fast food. I personally dislike that. Good otherwise.",
                date = Date.from(Instant.now())
            )
        )
        list.add(
            ReviewsTemplate.Review(
                "Happy56",
                5,
                "Super good! Love the food!",
                date = Date.from(Instant.now())
            )
        )
        return list
    }
}