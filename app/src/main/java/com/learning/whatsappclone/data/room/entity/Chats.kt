package com.learning.whatsappclone.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chats")
class Chats {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}