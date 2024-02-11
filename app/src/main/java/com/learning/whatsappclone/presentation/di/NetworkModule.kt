package com.learning.whatsappclone.presentation.di

import com.learning.whatsappclone.BuildConfig
import com.learning.whatsappclone.data.api.WhatsAppNetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val certificatePinning = CertificatePinner.Builder()
        .add("jsonplaceholder.typicode.com", "sha256/JCmeBpzLgXemYfoqqEoVJlU/givddwcfIXpwyaBk52I=")
        .add("jsonplaceholder.typicode.com", "sha256/81Wf12bcLlFHQAfJluxnzZ6Frg+oJ9PWY/Wrwur8viQ=")
        .add("jsonplaceholder.typicode.com", "sha256/hxqRlPTu1bMS/0DITB1SSu0vd4u/8l8TjPgfaAp63Gc=")
        .build()


    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient
            .Builder()
            .certificatePinner(certificatePinning)
            .addInterceptor(loggingInterceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request: Request =
                    chain.request().newBuilder().addHeader("accept", "application/json").build()
                return@addInterceptor chain.proceed(request)
            }
            .build()

        return Retrofit.Builder().baseUrl(BuildConfig.baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
    }

    @Provides
    @Singleton
    fun provideNetworkService(retrofit: Retrofit): WhatsAppNetworkService =
        retrofit.create(WhatsAppNetworkService::class.java)

}