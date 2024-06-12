package presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import di.DependencyProvider
import presentation.scenes.getgoing.GetGoingScreen
import presentation.scenes.getgoing.GetGoingViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.GetGoingScreen.route) {
        composable(route = Screen.GetGoingScreen.route) {
            val viewModel: GetGoingViewModel =
                viewModel { GetGoingViewModel(DependencyProvider.repository) }
            GetGoingScreen(viewModel = viewModel,
                start = {

                },
                navigateTo = { navController.navigate(it) }
            )
        }

    }
}