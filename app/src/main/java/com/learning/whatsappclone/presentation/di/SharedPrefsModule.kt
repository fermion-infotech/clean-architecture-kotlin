package com.learning.whatsappclone.presentation.di

import android.content.Context
import com.learning.whatsappclone.data.local.SecureSharedPreferencesImpl
import com.learning.whatsappclone.data.local.SecuredCryptoEncryptionHelper
import com.learning.whatsappclone.data.local.SecuredSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharedPrefsModule {

    @Provides
    @Singleton
    fun provideSecuredCryptoEncryptionHelper(@ApplicationContext context: Context): SecuredCryptoEncryptionHelper = SecuredCryptoEncryptionHelper(context)

    @Provides
    @Singleton
    fun provideSecureSharedPreferences(@ApplicationContext context: Context,securedCryptoEncryptionHelper: SecuredCryptoEncryptionHelper): SecuredSharedPreferences = SecureSharedPreferencesImpl(context, securedCryptoEncryptionHelper)

}