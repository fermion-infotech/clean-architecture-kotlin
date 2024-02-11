package com.learning.whatsappclone.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.whatsappclone.data.model.main.ChatsResponse
import com.learning.whatsappclone.data.utils.Resource
import com.learning.whatsappclone.domain.usecase.main.GetChatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getChatsUseCase: GetChatsUseCase): ViewModel() {
    private val chatsMutable: MutableLiveData<Resource<ChatsResponse>> = MutableLiveData()
    val chats: LiveData<Resource<ChatsResponse>> get() = chatsMutable

    fun getChats() = viewModelScope.launch {
        chatsMutable.postValue(Resource.Loading())
        delay(2000)
        val chatResponse = getChatsUseCase.execute()
        chatsMutable.postValue(chatResponse)
    }

}