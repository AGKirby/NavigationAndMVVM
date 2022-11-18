package com.example.navigationandmvvm.ViewsAndViewModels.profiles

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationandmvvm.databinding.FragmentProfilesBinding

class ProfilesFragment : AppCompatActivity() {

    private lateinit var _binding: FragmentProfilesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create binding
        _binding = FragmentProfilesBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val textView: TextView = _binding.profileTextHeader

        val profilesViewModel = ViewModelProvider(this).get(ProfilesViewModel::class.java)
        lifecycle.addObserver(profilesViewModel)

        profilesViewModel.text.observe(this) {
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