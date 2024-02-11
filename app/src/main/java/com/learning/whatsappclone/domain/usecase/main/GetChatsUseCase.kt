package com.learning.whatsappclone.domain.usecase.main

import com.learning.whatsappclone.data.model.main.ChatsResponse
import com.learning.whatsappclone.data.utils.Resource
import com.learning.whatsappclone.domain.repository.main.MainRepository
import retrofit2.Response

class GetChatsUseCase(private val mainRepository: MainRepository) {
    suspend fun execute():Resource<ChatsResponse> = mainRepository.getChats()
}