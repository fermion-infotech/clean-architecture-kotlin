package com.learning.whatsappclone.presentation.di

import com.learning.whatsappclone.data.repository.MainRepositoryImpl
import com.learning.whatsappclone.data.repository.datasource.WhatsAppRemoteDataSource
import com.learning.whatsappclone.domain.repository.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesMainRepository(whatsAppRemoteDataSource: WhatsAppRemoteDataSource): MainRepository =
        MainRepositoryImpl(whatsAppRemoteDataSource)
}