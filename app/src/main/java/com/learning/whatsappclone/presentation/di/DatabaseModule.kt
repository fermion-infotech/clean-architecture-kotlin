package com.learning.whatsappclone.presentation.di

import android.content.Context
import com.learning.whatsappclone.data.room.db.WhatsAppDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): WhatsAppDb {
        return WhatsAppDb.buildEncryptedDb(context)
    }

}