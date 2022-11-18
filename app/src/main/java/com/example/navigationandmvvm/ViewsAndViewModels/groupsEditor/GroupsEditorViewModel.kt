package com.example.navigationandmvvm.ViewsAndViewModels.groupsEditor

import androidx.lifecycle.*

class GroupsEditorViewModel : ViewModel(), DefaultLifecycleObserver {

    private val _text = MutableLiveData<String>().apply {
        value = "Groups Editor Fragment"
    }
    val text: LiveData<String> = _text

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
    }
}