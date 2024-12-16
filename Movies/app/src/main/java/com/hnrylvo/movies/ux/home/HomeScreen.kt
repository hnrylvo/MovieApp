package com.hnrylvo.movies.ux.home

import MovieCard
import MovieSkeletonCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hnrylvo.movies.data.utils.ApiConstants
import com.hnrylvo.movies.ui.compose.HomeHeader
import com.hnrylvo.movies.ui.theme.AppTheme
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {
    val viewModel = remember { HomeViewModel() }

    LaunchedEffect(Unit) {
        viewModel.getMovies()
    }

    Home( viewModel )
}

@Composable
fun Home(viewModel: HomeViewModel) {
    val isLoading by viewModel.isLoading
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(160.dp),
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(12.dp)
            ) {
                items(10) {
                    MovieSkeletonCard()
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Header()
                MovieList(
                    viewModel,
                    onMovieClick = { title ->
                        scope.launch {
                            snackbarHostState.showSnackbar(title)
                        }
                    }
                )
            }
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun MovieList(
    viewModel: HomeViewModel,
    onMovieClick: (String) -> Unit
) {
    val movies by viewModel.movies.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(movies.size) { index ->
            val movie = movies[index]
            val fullImageUrl = ApiConstants.IMG_BASE_URL + movie.imageUrl
            MovieCard(
                imageUrl = fullImageUrl,
                movieTitle = movie.movieTitle,
                movieDescription = movie.movieDescription,
                onClick = { onMovieClick(movie.movieTitle) }
            )
        }
    }
}

@Composable
fun Header() {
    HomeHeader()
}

@Preview(showSystemUi = true)
@Composable
fun MovieScreenPreview() {
    AppTheme {
        HomeScreen()
    }
}