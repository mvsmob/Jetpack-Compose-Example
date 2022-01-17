package com.mandarine.jetpackcomposeexample.presentation.screens.second_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mandarine.jetpackcomposeexample.data.remote.dto.PostResponse
import com.mandarine.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme
import org.koin.androidx.compose.get

@Composable
fun SecondScreen(viewModel: SecondScreenViewModel = get()) {

    val state = viewModel.state.value
    SecondScreenContent(screenState = state)
}

@Composable
fun SecondScreenContent(screenState: PostState) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(screenState.posts!!) { posts ->
                Text(text = posts.title, fontSize = 20.sp)
            }
        }
        if (screenState.error.isNotBlank()) {
            Text(
                text = screenState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .align(Alignment.Center)
            )
        }
        if (screenState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun MainScreenPreview() {
    JetpackComposeExampleTheme() {
        SecondScreenContent(
            screenState = PostState(
                posts = listOf(
                    PostResponse(
                        body = "body",
                        title = "title",
                        id = 1,
                        userId = 1
                    )
                )
            )
        )
    }
}