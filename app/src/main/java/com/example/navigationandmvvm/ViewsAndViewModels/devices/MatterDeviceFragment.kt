package com.example.navigationandmvvm.ViewsAndViewModels.devices

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.navigationandmvvm.ViewsAndViewModels.manageDevices.ManageDevicesFragment
import com.example.navigationandmvvm.databinding.FragmentMatterDeviceBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MatterDeviceFragment : Fragment() {

    private lateinit var _binding: FragmentMatterDeviceBinding

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val matterDeviceViewModel =
            ViewModelProvider(this).get(MatterDeviceViewModel::class.java)

        lifecycle.addObserver(matterDeviceViewModel)
        _binding = FragmentMatterDeviceBinding.inflate(inflater, container, false)

        /** Devices List Recycle View **/
        val devicesListRecyclerView = binding.devicesList

        // Setup recycler view for the devices list
        devicesListRecyclerView.layoutManager = GridLayoutManager(context, 3)
        devicesListRecyclerView.adapter = MatterDevicesAdapter(listOf())

        matterDeviceViewModel.devices.observe(viewLifecycleOwner) { devices ->
            devicesListRecyclerView.adapter = MatterDevicesAdapter(devices)
        }

        /** Dynamic set UI elements **/
        val addNewDeviceButton: FloatingActionButton = binding.addDevicesBtn

        // Setup Interactions Within Devices View
        addNewDeviceButton.setOnClickListener {
            val intent = Intent(activity, ManageDevicesFragment::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}