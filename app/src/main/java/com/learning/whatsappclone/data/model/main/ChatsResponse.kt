package com.learning.whatsappclone.data.model.main


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ChatsResponse(
    @SerializedName("chats")
    val chats: List<Chat>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)