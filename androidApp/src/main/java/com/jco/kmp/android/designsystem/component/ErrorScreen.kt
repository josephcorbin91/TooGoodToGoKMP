package com.jco.kmp.android.designsystem.component
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jco.kmp.android.R

@Composable
fun ErrorScreen() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(),
        text = stringResource(R.string.error)
    )
}