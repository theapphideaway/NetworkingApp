package com.ianschoenrock.networkingapp.Posts

import Models.PostElement
import Services.PostService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {

    val posts = MutableLiveData<List<PostElement>>()

    fun getPosts(){
        val postService = PostService()
        MainScope().launch(Dispatchers.Unconfined) {
            val postResponse = postService.getPosts()
                .getPostResponseAsync().await()
            posts.postValue(postResponse)
        }
    }
}