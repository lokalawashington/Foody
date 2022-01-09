package com.ifixhubke.foody.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.ifixhubke.foody.databinding.FragmentConfirmationCustomDialogBinding


class ConfirmationCustomDialog() : DialogFragment() {
private lateinit var binding : FragmentConfirmationCustomDialogBinding
private lateinit var textView : TextView
private lateinit var tableNumber : String
private lateinit var foodQuantity : String
private lateinit var food : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmationCustomDialogBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        textView = binding.cardTxt

       // textView.text = "You are about to order to ${food} X${foodQuantity} on table number ${tableNumber} \\n \\n Are you sure you want to proceed with the order?"

        binding.proceedAction.setOnClickListener {
            Toast.makeText(requireContext(), "Proceed", Toast.LENGTH_SHORT).show()
            val dialog = ConfirmationCustomDialog()

            dialog.dialog?.dismiss()
        }
        binding.cancelAction.setOnClickListener {
            Toast.makeText(requireContext(), "Cancel", Toast.LENGTH_SHORT).show()
            ConfirmationCustomDialog().dialog?.dismiss()
        }
        return view
    }

}