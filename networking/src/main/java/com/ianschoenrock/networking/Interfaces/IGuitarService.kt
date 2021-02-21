package com.ianschoenrock.networking.Interfaces

import Models.GuitarResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface IGuitarService {
    @GET("guitar")
    fun getPostResponseAsync(): Deferred<GuitarResponse>
}