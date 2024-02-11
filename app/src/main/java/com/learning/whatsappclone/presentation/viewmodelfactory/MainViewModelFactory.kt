package com.learning.whatsappclone.presentation.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learning.whatsappclone.domain.usecase.main.GetChatsUseCase
import com.learning.whatsappclone.presentation.viewmodel.MainViewModel

class MainViewModelFactory(private val getChatsUseCase: GetChatsUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getChatsUseCase) as T
    }
}