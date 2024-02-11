package com.learning.whatsappclone.data.repository.datasourceimpl

import com.learning.whatsappclone.data.api.WhatsAppNetworkService
import com.learning.whatsappclone.data.model.main.ChatsResponse
import com.learning.whatsappclone.data.repository.datasource.WhatsAppRemoteDataSource
import retrofit2.Response

class WhatsAppRemoteDataSourceImpl(private val networkService: WhatsAppNetworkService): WhatsAppRemoteDataSource {

    override suspend fun getChats(): Response<ChatsResponse> = networkService.getChat()
}