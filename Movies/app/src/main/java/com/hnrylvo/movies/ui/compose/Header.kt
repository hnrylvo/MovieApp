package com.hnrylvo.movies.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hnrylvo.movies.R
import com.hnrylvo.movies.ui.theme.AppTheme

@Composable
fun HomeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppTheme.colorScheme.primary)
            .padding(22.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.home_title),
            style = AppTheme.typography.titleLarge,
            color = AppTheme.colorScheme.onPrimary
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun HeaderPreview() {
    AppTheme {
        HomeHeader()
    }
}