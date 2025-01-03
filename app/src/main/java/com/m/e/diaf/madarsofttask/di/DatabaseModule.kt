package com.m.e.diaf.madarsofttask.di

import android.app.Application
import androidx.room.Room
import com.m.e.diaf.madarsofttask.database.DataUserDao
import com.m.e.diaf.madarsofttask.database.DataUserDatabase
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
    fun provideDbInstance(application: Application): DataUserDatabase {
        return Room.databaseBuilder(
            application,
            DataUserDatabase::class.java,
            "datauserdatabase"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(dataUserDatabase: DataUserDatabase): DataUserDao {
        return dataUserDatabase.getDao()
    }
}


