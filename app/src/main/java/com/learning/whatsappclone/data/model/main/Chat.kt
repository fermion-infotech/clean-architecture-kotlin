package com.learning.whatsappclone.data.model.main


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Chat(
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("recent_message")
    val recentMessage: String,
    @SerializedName("recent_message_from")
    val recentMessageFrom: String,
    @SerializedName("unread_message")
    val unreadMessage: Int
)