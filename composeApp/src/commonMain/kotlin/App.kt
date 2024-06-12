import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import di.DependencyProvider
import kmp.repository.GgRepositoryImpl
import kmp.repository.room.Route
import kmp.repository.room.RouteAddedCallback
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.navigation.NavGraph

@Composable
@Preview
fun App(repository: GgRepositoryImpl) {
    DependencyProvider.repository = repository
    LaunchedEffect(true) {
        repository.insertRoute(
            Route(0, 350, 400.0, 1000.0, "05.04.2024. 09:26:45", 0.0, 0.0, 2, 2000),
            object : RouteAddedCallback {
                override fun onRouteAdded(id: Long) {

                }
            })
    }

    MaterialTheme {
        NavGraph(rememberNavController())
    }
}