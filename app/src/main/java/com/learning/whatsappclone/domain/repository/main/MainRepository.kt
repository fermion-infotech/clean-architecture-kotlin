package com.learning.whatsappclone.domain.repository.main

import com.learning.whatsappclone.data.model.main.ChatsResponse
import com.learning.whatsappclone.data.utils.Resource

interface MainRepository {
    suspend fun getChats(): Resource<ChatsResponse>
}