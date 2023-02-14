package com.example.hittareviewapplication.ui.molecules

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.hittareviewapplication.R
import com.example.hittareviewapplication.ui.atoms.Icon
import com.example.hittareviewapplication.ui.tokens.Dimension.Padding

/**
 * Icon for a user.
 */
@Composable
fun UserIcon(resId: Int = R.drawable.ic_user_icon) {
    Icon(props = Icon.Props(
        resId = resId,
        padding = Padding._0,
        tintResId = R.color.secondary
    ))
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    UserIcon(R.drawable.ic_user_icon)
}