package com.learning.whatsappclone.data.model.main


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CallsResponse(
    @SerializedName("calls")
    val calls: List<Call>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)