package com.example.navigationandmvvm.ViewsAndViewModels.devices

import Shared.Models.Device
import android.media.Image
import android.util.Log
import androidx.lifecycle.*
import com.example.navigationandmvvm.R
import org.json.JSONObject

val MOCK_FAKE_DATA = """
    {
        "devices": [
            {
                "id": "a97a087b-9cdc-436f-ae17-bcdd20e916c2",
                "name": "mydevicename",
                "active": true,
                "wifi": "mywifi",
                "deviceType": "dimmer",
                "groups": [
                    "group1",
                    "group2"
                ]
            },
            {
                "id": "mydeviceid",
                "name": "mynewname",
                "active": true,
                "wifi": "mywifi",
                "deviceType": "dimmer",
                "groups": [
                    "group1"
                ]
            }
        ]
    }
""".trimIndent()


class MatterDeviceViewModel : ViewModel(), DefaultLifecycleObserver {
    private val _TAG = MatterDeviceViewModel::class.java.simpleName

    /** Encapsulated data **/
    private val _devices = MutableLiveData<List<DevicesListItem>>().apply {
        value = listOf()
    }

    /** Public Accessors **/
    val devices : LiveData<List<DevicesListItem>> = _devices

    // Each Device List Entity
    class DevicesListItem {
        var label: String = ""
        var image: Int = -1

        constructor(label: String, image: Int) {
            this.label = label
            this.image = image
        }

        constructor()
    }

    /** Lifecycle Handlers **/
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        // TODO: Replace mock data with AWS-prod server data from HTTP GET
        val devicesList = mutableListOf<Device>()

        val data = JSONObject(MOCK_FAKE_DATA).getJSONArray("devices")
        for ( i in 0 until data.length() ) {
            try {
                devicesList.add(Device(data.getJSONObject(i)))
            } catch (e : Exception) {
                Log.e(_TAG, "Parsing devices list error: $e")
            }
        }

        // Generate mutable DevicesListItem
        val mutableDevicesList = mutableListOf<DevicesListItem>()
        devicesList.forEach {
            // TODO: The structure of DeviceListItem might be wrong?
            mutableDevicesList.add(DevicesListItem(it.getDeviceName(), R.drawable.ic_dashboard_black_24dp))
        }

        _devices.postValue(mutableDevicesList)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
    }
}