package com.learning.whatsappclone.data.model.main


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Status(
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("story_viewed")
    val storyViewed: Boolean
)