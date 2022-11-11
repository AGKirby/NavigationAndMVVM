package com.example.navigationandmvvm.ViewsAndViewModels.devices

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navigationandmvvm.databinding.FragmentMatterDeviceBinding

class MatterDeviceFragment : Fragment() {

    private var _binding: FragmentMatterDeviceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val matterDeviceViewModel =
            ViewModelProvider(this).get(MatterDeviceViewModel::class.java)

        _binding = FragmentMatterDeviceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.matterDevicesTextHeader
        matterDeviceViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}