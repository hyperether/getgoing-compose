package kmp.di

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kmp.repository.room.AppDatabase
import kmp.repository.room.dbFileName
import kmp.repository.room.instantiateImpl
import platform.Foundation.NSHomeDirectory


actual class Factory {
    actual fun getRoomDatabase(): AppDatabase {
        val dbFilePath = NSHomeDirectory() + dbFileName
        return Room.databaseBuilder<AppDatabase>(
            name = dbFilePath,
            factory = {
                AppDatabase::class.instantiateImpl()
            }
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}