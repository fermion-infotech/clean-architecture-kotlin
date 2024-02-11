package com.learning.whatsappclone.data.room.db

import android.content.Context


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.learning.whatsappclone.data.room.dao.ChatsDao
import com.learning.whatsappclone.data.room.entity.Chats
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory


@Database(entities = [Chats::class], version = 1, exportSchema = false)
abstract class WhatsAppDb: RoomDatabase() {

    abstract fun chatsDao(): ChatsDao

    companion object {
        private const val SECRET_KEY = "whatsapp_app"
        fun buildEncryptedDb(context: Context): WhatsAppDb{
            val passphrase = SQLiteDatabase.getBytes(SECRET_KEY.toCharArray())

            val factory = SupportFactory(passphrase)

            return Room.databaseBuilder(
                context,
                WhatsAppDb::class.java,
                "app_database"
            ).openHelperFactory(factory)
                .build()
        }
    }
}