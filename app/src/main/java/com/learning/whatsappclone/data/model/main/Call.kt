package com.learning.whatsappclone.data.model.main


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Call(
    @SerializedName("call_type")
    val callType: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)