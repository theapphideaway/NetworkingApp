package com.ianschoenrock.networkingapp.Guitars

import Models.GuitarResponse
import Models.PostElement
import Services.GuitarService
import Services.PostService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class GuitarViewModel : ViewModel() {

    val guitarResponse = MutableLiveData<GuitarResponse>()

    fun getGuitars(){
        val guitarService = GuitarService()
        MainScope().launch(Dispatchers.Unconfined) {
            val postResponse = guitarService.getGuitars()
                .getPostResponseAsync().await()
            guitarResponse.postValue(postResponse)
        }
    }
}