package com.example.navigationandmvvm.ViewsAndViewModels.profiles

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfilesViewModel : ViewModel(), DefaultLifecycleObserver {


    private val _text = MutableLiveData<String>().apply {
        value = "This is Profiles Fragment"
    }

    val text: LiveData<String> = _text

}