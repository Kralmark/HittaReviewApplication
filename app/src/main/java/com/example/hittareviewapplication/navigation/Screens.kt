package com.example.hittareviewapplication.navigation

sealed class Screens(val route: String) {
    object MyReview: Screens("my_review_screen")
    object Reviews: Screens("reviews_screen")
}