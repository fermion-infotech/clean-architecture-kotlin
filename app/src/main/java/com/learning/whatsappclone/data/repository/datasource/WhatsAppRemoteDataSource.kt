package com.learning.whatsappclone.data.repository.datasource

import com.learning.whatsappclone.data.model.main.ChatsResponse
import retrofit2.Response

interface WhatsAppRemoteDataSource {
    suspend fun getChats(): Response<ChatsResponse>
}