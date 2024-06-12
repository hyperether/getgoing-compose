package di

import kmp.repository.GgRepository
import presentation.scenes.getgoing.GetGoingViewModel

object DependencyProvider {
    var repository: GgRepository? = null
}