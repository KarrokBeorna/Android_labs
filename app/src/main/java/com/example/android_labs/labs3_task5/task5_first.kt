package com.example.android_labs.labs3_task5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.android_labs.R
import com.example.android_labs.databinding.Activity1Labs3Task5Binding

class task5_first : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Activity1Labs3Task5Binding.inflate(layoutInflater)

        binding.toSecond.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_task5_first_to_task5_second)
        }
        binding.toFourth.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_task5_first_to_task5_fourth)
        }
        return binding.root
    }

}