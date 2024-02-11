package com.learning.whatsappclone.data.local

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.learning.whatsappclone.data.utils.Constants

class SecuredCryptoEncryptionHelper (private val context: Context): EncryptionHelper {
    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)


    override fun encrypt(key: String, data: String) {
        val sharedPreferences = EncryptedSharedPreferences.create(
            Constants.encryptionKey,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        with(sharedPreferences.edit()) {
            putString(key, data)
            apply()
        }
    }

    override fun decrypt(key: String): String {
        val sharedPreferences = EncryptedSharedPreferences.create(
            Constants.encryptionKey,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        return sharedPreferences.getString(key, "") ?: ""
    }

}