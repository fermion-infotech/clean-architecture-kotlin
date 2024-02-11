package com.learning.whatsappclone.data.local

interface EncryptionHelper {
    fun encrypt(key:String, data: String)
    fun decrypt(key:String): String
}