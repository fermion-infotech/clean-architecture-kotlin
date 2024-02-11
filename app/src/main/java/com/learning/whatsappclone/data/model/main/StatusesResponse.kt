package com.learning.whatsappclone.data.model.main


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class StatusesResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("statuses")
    val statuses: List<Status>
)