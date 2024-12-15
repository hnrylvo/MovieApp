package com.hnrylvo.movies

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hnrylvo.movies.ui.theme.AppTheme
import com.hnrylvo.movies.ux.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
fun AppPreview() {
    AppTheme {
        HomeScreen()
    }
}