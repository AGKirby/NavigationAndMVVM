package com.example.navigationandmvvm.ViewsAndViewModels.manageDevices

import androidx.lifecycle.*

class ManageDevicesViewModel : ViewModel(), DefaultLifecycleObserver {

    private val _text = MutableLiveData<String>().apply {
        value = "Manage Devices Fragment"
    }
    val text: LiveData<String> = _text

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
    }
}