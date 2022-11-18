package com.example.navigationandmvvm.ViewsAndViewModels.home

import Shared.Utility.CatApi
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment (Favorites Page)"
    }

    fun getDevices(){
        coroutineScope.launch {
            try {
                val response = CatApi.retrofitService.getDevices().await()
                println("getDevices success: $response")

            } catch (e: Exception) {
                Log.e(TAG, "parseBirthdays error: $e")
            }
        }
    }

    val text: LiveData<String> = _text
}