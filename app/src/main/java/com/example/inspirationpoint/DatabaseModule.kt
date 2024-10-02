package com.example.inspirationpoint

import android.app.Application
import androidx.room.Room
import com.example.inspirationpoint.data.AppDatabase
import com.example.inspirationpoint.data.DaoMessage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideDaoMessage(db: AppDatabase): DaoMessage {
        return db.daoMessage()
    }
}