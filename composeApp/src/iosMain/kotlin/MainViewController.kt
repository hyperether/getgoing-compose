import androidx.compose.ui.window.ComposeUIViewController
import kmp.di.Factory
import kmp.repository.GgRepositoryImpl

fun MainViewController() = ComposeUIViewController {
    val repository = GgRepositoryImpl(Factory().getRoomDatabase())
    App(repository)
}