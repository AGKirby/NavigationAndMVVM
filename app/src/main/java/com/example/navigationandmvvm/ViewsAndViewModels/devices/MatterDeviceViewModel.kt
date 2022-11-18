package com.example.navigationandmvvm.ViewsAndViewModels.devices

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MatterDeviceViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Matter Devices Fragment"
    }
    val text: LiveData<String> = _text

}