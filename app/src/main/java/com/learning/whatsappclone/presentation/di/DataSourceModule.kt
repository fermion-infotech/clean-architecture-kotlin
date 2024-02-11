package com.learning.whatsappclone.presentation.di

import com.learning.whatsappclone.data.api.WhatsAppNetworkService
import com.learning.whatsappclone.data.repository.datasource.WhatsAppRemoteDataSource
import com.learning.whatsappclone.data.repository.datasourceimpl.WhatsAppRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideWhatsAppRemoteDataSource(networkService: WhatsAppNetworkService): WhatsAppRemoteDataSource = WhatsAppRemoteDataSourceImpl(networkService)

}