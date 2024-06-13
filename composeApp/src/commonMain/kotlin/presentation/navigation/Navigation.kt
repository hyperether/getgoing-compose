package presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import di.DependencyProvider
import presentation.navigation.Arguments.USER_ID
import presentation.scenes.getgoing.GetGoingScreen
import presentation.scenes.getgoing.GetGoingViewModel
import presentation.scenes.profile.ProfileScreen
import presentation.scenes.profile.ProfileViewModel

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

        composable(
            route = "${Screen.ProfileScreen.route}/{$USER_ID}",
            arguments = listOf(navArgument(USER_ID) { type = NavType.LongType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getLong(USER_ID)
            val viewModel: ProfileViewModel =
                viewModel { ProfileViewModel(DependencyProvider.repository) }
            ProfileScreen(
                userId = userId!!,
                viewModel = viewModel,
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}