package com.mandarine.jetpackcomposeexample.presentation.screens.onboarding

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
import com.mandarine.jetpackcomposeexample.presentation.screens.Screen
import com.mandarine.jetpackcomposeexample.presentation.screens.common.LottieExample
import com.mandarine.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme
import org.koin.androidx.compose.get

@Composable
fun OnboardingScreen(
    navController: NavController,
    viewModel: OnboardingViewModel = get()
) {
    OnboardingScreenContent(
        onContinueClicked = {
            viewModel.completeOnboarding()
            navController.navigate(Screen.Post.route) {
                popUpTo(id = 0)
            }
        }
    )
}

@Composable
fun OnboardingScreenContent(onContinueClicked: () -> Unit) {

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieExample()
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
        OnboardingScreenContent(onContinueClicked = {})
    }
}