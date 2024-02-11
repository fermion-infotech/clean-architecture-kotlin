package com.learning.whatsappclone.presentation.di

import com.learning.whatsappclone.domain.usecase.main.GetChatsUseCase
import com.learning.whatsappclone.presentation.viewmodelfactory.MainViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelFactoryModule {

    @Provides
    @Singleton
    fun providesMainViewModelFactory(getChatsUseCase: GetChatsUseCase): MainViewModelFactory = MainViewModelFactory(getChatsUseCase)
}