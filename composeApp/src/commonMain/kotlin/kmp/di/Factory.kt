package kmp.di

import kmp.repository.room.AppDatabase

expect class Factory {
    fun getRoomDatabase(): AppDatabase
}