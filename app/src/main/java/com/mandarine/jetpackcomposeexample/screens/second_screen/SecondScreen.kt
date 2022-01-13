package com.mandarine.jetpackcomposeexample.screens.second_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mandarine.jetpackcomposeexample.R
import com.mandarine.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme
import org.koin.androidx.compose.get

@Composable
fun SecondScreen(viewModel: SecondScreenViewModel = get()) {
    SecondScreenContent()
}

@Composable
fun SecondScreenContent() {

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(R.string.second_screen_title))
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun MainScreenPreview() {
    JetpackComposeExampleTheme() {
        SecondScreenContent()
    }
}