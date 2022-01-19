package com.example.poem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poem.databinding.FragmentBackBinding


class BackFragment : Fragment() {
    private lateinit var binding: FragmentBackBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentBackBinding.inflate(inflater)

        val inputData = arguments?.getString("key")
        binding.textView.text= inputData


        return binding.root
    }



}