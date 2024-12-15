import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hnrylvo.movies.ui.theme.AppTheme

@Composable
fun MovieCard(
    imageUrl: String,
    movieTitle: String = "Movie Title",
    movieDescription: String = "Movie Description",
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .size(width = 160.dp, height = 280.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Box(
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = movieTitle,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.7f)
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(AppTheme.size.normal),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text(
                    text = movieTitle,
                    style = AppTheme.typography.titleNormal.copy(
                        color = Color.White,
                    ),
                )

                Text(
                    text = movieDescription,
                    style = AppTheme.typography.labelSmall.copy(
                        color = Color.White
                    ),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MovieCardPreview() {
    AppTheme {
        MovieCard(
            imageUrl = "https://imgsrv.crunchyroll.com/cdn-cgi/image/fit=contain,format=auto,quality=85,width=1200,height=675/catalog/crunchyroll/a249096c7812deb8c3c2c907173f3774.jpg",
            movieTitle = "Movie Title 2",
            movieDescription = "Movie Description"
        )
    }
}