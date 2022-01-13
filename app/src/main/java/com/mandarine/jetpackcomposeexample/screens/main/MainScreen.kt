package com.mandarine.jetpackcomposeexample.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.mandarine.jetpackcomposeexample.R
import com.mandarine.jetpackcomposeexample.screens.Screen
import com.mandarine.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme
import org.koin.androidx.compose.get

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = get()
) {
    MainScreenContent(
        onContinueClicked = { navController.navigate(Screen.SecondScreen.route) }
    )
}

@Composable
fun MainScreenContent(onContinueClicked: () -> Unit) {

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = onContinueClicked) {
                Text(stringResource(R.string.action_go_to))
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun MainScreenPreview() {
    JetpackComposeExampleTheme() {
        MainScreenContent(onContinueClicked = {})
    }
}