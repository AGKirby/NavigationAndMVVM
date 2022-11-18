package com.example.navigationandmvvm.ViewsAndViewModels.manageDevices

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationandmvvm.databinding.FragmentManageDevicesBinding

class ManageDevicesFragment : AppCompatActivity() {

    private lateinit var _binding: FragmentManageDevicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = FragmentManageDevicesBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val manageDevicesViewModel = ViewModelProvider(this).get(ManageDevicesViewModel::class.java)
        lifecycle.addObserver(manageDevicesViewModel)

        val textView: TextView = _binding.manageDevicesTextHeader
        val addNewDeviceBtn: Button = _binding.addNewDeviceBtn

        manageDevicesViewModel.text.observe(this) {
            textView.text = it
        }

        addNewDeviceBtn.setOnClickListener {
            // TODO Alex will fill in logic
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