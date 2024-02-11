package com.learning.whatsappclone.presentation.di

import com.learning.whatsappclone.domain.repository.main.MainRepository
import com.learning.whatsappclone.domain.usecase.main.GetChatsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetChatsUseCase(mainRepository: MainRepository): GetChatsUseCase = GetChatsUseCase(mainRepository)
}