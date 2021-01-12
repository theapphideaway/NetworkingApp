package com.ianschoenrock.networking.Interfaces

import Models.PostElement
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface IPostService {
    @GET("posts")
    fun getPostResponseAsync(): Deferred<List<PostElement>>
}