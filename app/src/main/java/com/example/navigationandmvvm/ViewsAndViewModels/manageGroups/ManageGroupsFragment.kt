package com.example.navigationandmvvm.ViewsAndViewModels.manageGroups

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationandmvvm.databinding.FragmentManageGroupsBinding

class ManageGroupsFragment : AppCompatActivity() {

    private lateinit var _binding: FragmentManageGroupsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = FragmentManageGroupsBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val manageGroupsViewModel = ViewModelProvider(this).get(ManageGroupsViewModel::class.java)
        lifecycle.addObserver(manageGroupsViewModel)

        val textView: TextView = _binding.manageGroupsTextHeader

        manageGroupsViewModel.text.observe(this) {
            textView.text = it
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}