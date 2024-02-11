package com.learning.whatsappclone.data.utils

import retrofit2.Response

object ResponseToResource {
    inline fun <reified T : Any> responseToResource(response: Response<T>): Resource<T> {
        return if (response.isSuccessful) {
            response.body()?.let { result ->
                Resource.Success(result)
            } ?: run {
                Resource.Error("Response body is null")
            }
        } else {
            Resource.Error(response.message())
        }
    }

}