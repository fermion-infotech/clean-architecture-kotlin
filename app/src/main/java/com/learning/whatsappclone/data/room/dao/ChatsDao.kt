package com.learning.whatsappclone.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import com.learning.whatsappclone.data.room.entity.Chats

@Dao
interface ChatsDao {

    @Insert
    suspend fun insert(chats: Chats)
}