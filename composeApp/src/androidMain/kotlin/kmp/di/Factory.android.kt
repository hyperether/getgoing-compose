package kmp.di

import android.app.Application
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kmp.repository.room.AppDatabase
import kmp.repository.room.dbFileName
import kotlinx.coroutines.Dispatchers

actual class Factory(private val app: Application) {
    actual fun getRoomDatabase(): AppDatabase {
        val dbFile = app.getDatabasePath(dbFileName)
        return Room.databaseBuilder<AppDatabase>(app, dbFile.absolutePath)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}