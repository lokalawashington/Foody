package com.ifixhubke.foody.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ifixhubke.foody.databinding.FragmentConfirmationCustomDialogBinding


class ConfirmationCustomDialog() : DialogFragment() {
private lateinit var binding : FragmentConfirmationCustomDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmationCustomDialogBinding.inflate(layoutInflater, container, false)
        val view = binding.root



        return view
    }

}