package com.example.android_labs.labs3_task5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.android_labs.R
import com.example.android_labs.databinding.Activity2Labs3Task5Binding

class Task5_second : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Activity2Labs3Task5Binding.inflate(layoutInflater)

        binding.toFirst.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_task5_second_to_task5_first)
        }
        binding.toThird.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_task5_second_to_task5_third)
        }
        return binding.root
    }

}