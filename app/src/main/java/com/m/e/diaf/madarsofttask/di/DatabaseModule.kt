package com.m.e.diaf.madarsofttask.di

import android.app.Application
import com.m.e.diaf.madarsofttask.database.DemoDatabase
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
    @Synchronized
    fun provideDbInstance(application: Application) :DemoDatabase{
        return Room.databaseBuilder(application , DemoDatabase::class.java , "mealDb")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(demoDatabase: DemoDatabase):MealsDao{
        return demoDatabase.getDao()
    }
}