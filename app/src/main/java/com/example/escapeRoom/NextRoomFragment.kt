package com.example.escapeRoom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.anagram.R
import com.example.anagram.databinding.FragmentNextRoomBinding
import com.example.anagram.databinding.FragmentStartBinding


class NextRoomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNextRoomBinding>(
            inflater, R.layout.fragment_next_room, container, false)

        return binding.root
    }

}