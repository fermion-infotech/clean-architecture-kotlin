package com.learning.whatsappclone.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.learning.whatsappclone.presentation.manager.NetworkStatus
import com.learning.whatsappclone.presentation.manager.NetworkStatusManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NetworkStatusViewModel @Inject constructor(private val networkStatusManager: NetworkStatusManager) :
    ViewModel() {
    private val _networkStatus = networkStatusManager.networkStatus
    val networkStatus: LiveData<NetworkStatus> get() = _networkStatus
}