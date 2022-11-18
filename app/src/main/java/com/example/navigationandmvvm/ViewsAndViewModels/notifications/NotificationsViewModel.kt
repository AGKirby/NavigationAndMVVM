package com.example.navigationandmvvm.ViewsAndViewModels.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This Fragmented Page will be used to get access to the rest of the other " +
                "pages it will be deleted after all views are finalized"
    }

    val text: LiveData<String> = _text
}