package com.learning.whatsappclone.data.api

import com.learning.whatsappclone.data.model.main.CallsResponse
import com.learning.whatsappclone.data.model.main.ChatsResponse
import com.learning.whatsappclone.data.model.main.StatusesResponse
import retrofit2.Response
import retrofit2.http.GET

interface WhatsAppNetworkService {

    @GET("chatlist")
    suspend fun getChat(): Response<ChatsResponse>

    @GET()
    suspend fun getStatuses(): Response<StatusesResponse>

    @GET()
    suspend fun getCalls(): Response<CallsResponse>
}