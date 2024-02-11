package com.learning.whatsappclone.data.local

import android.content.Context
import com.learning.whatsappclone.data.local.SecuredSharedPreferences
import javax.inject.Inject

class SecureSharedPreferencesImpl @Inject constructor(
    private val context: Context,
    private val securedCryptoEncryptionHelper: SecuredCryptoEncryptionHelper
) : SecuredSharedPreferences {
    override fun saveString(key: String, data: String) =
        securedCryptoEncryptionHelper.encrypt(key, data)


    override fun getString(key: String): String = securedCryptoEncryptionHelper.decrypt(key)

}