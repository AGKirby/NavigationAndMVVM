package com.example.navigationandmvvm.ViewsAndViewModels.manageGroups

import androidx.lifecycle.*

class ManageGroupsViewModel : ViewModel(), DefaultLifecycleObserver {

    private val _text = MutableLiveData<String>().apply {
        value = "Manage Groups Fragment"
    }
    val text: LiveData<String> = _text

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
    }
}