package com.learning.whatsappclone.presentation.di

import com.learning.whatsappclone.data.room.dao.ChatsDao
import com.learning.whatsappclone.data.room.db.WhatsAppDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    @Provides
    @Singleton
    fun provideChatsDao(whatsAppDb: WhatsAppDb): ChatsDao = whatsAppDb.chatsDao()
}