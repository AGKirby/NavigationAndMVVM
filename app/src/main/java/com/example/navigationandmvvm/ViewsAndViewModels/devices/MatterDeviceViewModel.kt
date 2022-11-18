package com.example.navigationandmvvm.ViewsAndViewModels.devices

import android.media.Image
import androidx.lifecycle.*

class MatterDeviceViewModel : ViewModel(), DefaultLifecycleObserver {
    /** Encapsulated data **/
    private val _devices = MutableLiveData<List<DevicesListItem>>().apply {
        value = listOf()
    }

    /** Public Accessors **/
    val devices : LiveData<List<DevicesListItem>> = _devices

    // Each Device List Entity
    class DevicesListItem {
        var label: String = ""
        var image: Image? = null

        constructor(label: String, image: Image) {
            this.label = label
            this.image = image
        }

        constructor()
    }

    /** Lifecycle Handlers **/
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
    }
}