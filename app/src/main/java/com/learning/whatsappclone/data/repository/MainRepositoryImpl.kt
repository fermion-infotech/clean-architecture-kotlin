package com.learning.whatsappclone.data.repository

import com.learning.whatsappclone.data.model.main.ChatsResponse
import com.learning.whatsappclone.data.repository.datasource.WhatsAppRemoteDataSource
import com.learning.whatsappclone.data.utils.Resource
import com.learning.whatsappclone.data.utils.ResponseToResource
import com.learning.whatsappclone.domain.repository.main.MainRepository

class MainRepositoryImpl(private val whatsAppRemoteDataSource: WhatsAppRemoteDataSource) :
    MainRepository {

    override suspend fun getChats(): Resource<ChatsResponse> =
        ResponseToResource.responseToResource(whatsAppRemoteDataSource.getChats())

}