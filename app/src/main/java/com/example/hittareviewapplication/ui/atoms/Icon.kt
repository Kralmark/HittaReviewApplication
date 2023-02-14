package com.example.hittareviewapplication.ui.atoms

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.ui.tokens.Dimension.*


open class Icon {

    data class Props(
        val resId: Int,
        val padding: Padding = Padding._8,
        val size: Size = Size._32,
        var tintResId: Int? = null
    )
}

@Composable
fun Icon(props: Icon.Props) {
    // Box container for icon padding
    Box(modifier = Modifier.
        padding(props.padding.value)) {
        // Actual image
        Image(modifier = Modifier
            .size(props.size.value),
            painter = painterResource(
                id = props.resId
            ),
            contentDescription = null,
            colorFilter = if(props.tintResId != null) ColorFilter.tint(colorResource(id = props.tintResId!!)) else null,

        )
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    Icon(props = Icon.Props(
        resId = R.drawable.ic_user_icon,
        padding = Padding._8,
        size = Size._16,
        tintResId = R.color.secondary
    ))
}
