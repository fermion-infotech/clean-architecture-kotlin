package com.learning.whatsappclone.data.local

interface SecuredSharedPreferences {
    fun saveString(key: String, data: String)
    fun getString(key: String): String
}