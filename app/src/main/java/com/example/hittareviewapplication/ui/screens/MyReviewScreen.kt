package com.example.hittareviewapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.MainActivity
import com.example.hittareviewapplication.api.models.ReviewDTO
import com.example.hittareviewapplication.api.service.RetrofitServiceImpl
import com.example.hittareviewapplication.ui.atoms.*
import com.example.hittareviewapplication.ui.molecules.ButtonRenderable
import com.example.hittareviewapplication.ui.molecules.TopBar
import com.example.hittareviewapplication.ui.organisms.Dialog
import com.example.hittareviewapplication.ui.screens.destinations.ReviewsScreenDestination
import com.example.hittareviewapplication.ui.templates.MyReviewTemplate
import com.example.hittareviewapplication.ui.tokens.Dimension
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

private lateinit var dialogVisible: MutableState<Boolean>

/**
 * Template containing top buttons and "Review ..." header, stars, stars "explanation"
 * editable text for "my" name and for "my" experience.
 */
@Destination
@Composable
fun MyReviewScreen(navigator: DestinationsNavigator?) {
    Column(modifier = Modifier
        .fillMaxSize())
    {
        // Top bar containing a Close button, the company name and a Save button
        TopBar(model = createTopBarModel(navigator))

        // Actual review by "me"
        MainActivity.getModel().let { state ->
            MyReviewTemplate(model = MyReviewTemplate.Model(
                ratingState = state.ratingState,
                commentState = state.commentState,
                userNameState = state.userNameState
            ))
        }

        // Dialog that shall be visible after clicking the Save button
        dialogVisible = remember { mutableStateOf(false)}
        Dialog(model = createDialogModel(dialogVisible))
    }
}

/**
 * Post the review to the server.
 */
fun postReview(success: () -> Unit, failure: () -> Unit) {
    RetrofitServiceImpl().postReview(
        review = ReviewDTO(
            companyId = MainActivity.id,
            comment = MainActivity.applicationState!!.commentState.value,
            score = MainActivity.applicationState!!.ratingState.value,
        ),
        success = success,
        failure = failure
    )
}

private fun onPostSuccess() {
    dialogVisible.value = true
}

private fun onPostFailure() {
    dialogVisible.value = true // TODO: Other modal content
}

private fun createTopBarModel(navigator: DestinationsNavigator?) =
    TopBar.Model(elements = listOf(
        ButtonRenderable(model = ButtonRenderable.Model(
            text = "Close",
            onClick = {
                //Set "Anonymous" if nothing in state
                if(MainActivity.applicationState!!.userNameState.value.isEmpty()) {
                    MainActivity.applicationState!!.userNameState.value = "Anonymous"
                }
                navigator?.navigate(ReviewsScreenDestination)
            }
        )),
        TextRenderable(model = TextRenderable.Model(
            text = MainActivity.applicationState?.companyNameState!!.value
        )),
        ButtonRenderable(model = ButtonRenderable.Model(
            text = "Save",
            onClick = { postReview({ onPostSuccess() }, { onPostFailure() }) }
        ))
    ))

private fun createDialogModel(dialogVisible: MutableState<Boolean>) =
    Dialog.Model(
        paddingValues = PaddingValues(
            start = Dimension.Padding._16.value,
            end = Dimension.Padding._16.value,
            top = Dimension.Padding._16.value,
            bottom = Dimension.Padding._0.value,
        ),
        visible = dialogVisible,
        elements = listOf(
            HeaderRenderable(model = HeaderBase.Props(
                type = HeaderType._1,
                text = "Thank you for your review"
            )),
            BodyRenderable(model = BodyBase.Props(
                type = BodyType._1,
                text = "You're helping others make smarter decisions every day.",
                textAlign = TextAlign.Center
            )),
            DividerRenderable(model = DividerBase.Model()),
            ButtonRenderable(model = ButtonRenderable.Model(
                text = "Okay!",
                onClick = { dialogVisible.value = false },
                paddingValues = PaddingValues(
                    start = Dimension.Padding._96.value,
                    end = Dimension.Padding._96.value,
                    top = Dimension.Padding._16.value,
                    bottom = Dimension.Padding._16.value,
                )
            ))
        )
    )

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MyReviewScreen(null)
}
