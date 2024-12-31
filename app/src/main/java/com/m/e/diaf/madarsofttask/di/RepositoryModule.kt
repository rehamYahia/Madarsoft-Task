package com.m.e.diaf.madarsofttask.di

import com.m.e.diaf.madarsofttask.database.DataUserDao
import com.m.e.diaf.madarsofttask.repository.DataUserRepoImp
import com.m.e.diaf.madarsofttask.repository.DataUserRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepo( dataUserDao:DataUserDao):DataUserRepo{
        return DataUserRepoImp(dataUserDao )
    }
}