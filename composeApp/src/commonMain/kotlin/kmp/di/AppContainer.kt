package kmp.di

import kmp.repository.GgRepositoryImpl

class AppContainer(
    private val factory: Factory
) {
    val appRepository: GgRepositoryImpl by lazy {
        GgRepositoryImpl(
            factory.getRoomDatabase(),
        )
    }
}