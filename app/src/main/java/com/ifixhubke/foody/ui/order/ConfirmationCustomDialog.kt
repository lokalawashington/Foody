package com.ifixhubke.foody.ui.order

import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hover.sdk.api.HoverParameters
import com.ifixhubke.foody.R
import com.ifixhubke.foody.databinding.FragmentConfirmationCustomDialogBinding
import com.ifixhubke.foody.utils.Constants.TILL_NO_ACTION_ID
import timber.log.Timber

private const val TAG = "ConfirmationCustomDialog"

class ConfirmationCustomDialog() : DialogFragment(R.layout.fragment_confirmation_custom_dialog) {
    private lateinit var binding: FragmentConfirmationCustomDialogBinding
    private lateinit var textView: TextView
    private lateinit var tableNumber: String
    private lateinit var foodQuantity: String
    private lateinit var food: String
    private val args: ConfirmationCustomDialogArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmationCustomDialogBinding.inflate(layoutInflater, container, false)

        val order = args.order

        val view = binding.root
        textView = binding.cardTxt

        // textView.text = "You are about to order to ${food} X${foodQuantity} on table number ${tableNumber} \\n \\n Are you sure you want to proceed with the order?"

        binding.cardTxt.text =
            "You are about to order ${order.numberOfOrders} ${order.foodName} on table number ${order.tableNumber} \n \n Are you sure you want to proceed with the order? "

        binding.proceedAction.setOnClickListener {
            Toast.makeText(requireContext(), "Proceed", Toast.LENGTH_SHORT).show()

            completePayment(
                "1",
                "5021237",
                requireContext()
            )

            ConfirmationCustomDialog().dialog?.dismiss()
        }
        binding.cancelAction.setOnClickListener {
            Toast.makeText(requireContext(), "Cancel", Toast.LENGTH_SHORT).show()
            ConfirmationCustomDialog().dialog?.dismiss()
            findNavController().navigate(R.id.action_confirmationCustomDialog_to_orderFragment)
        }
        return view
    }


    private fun completePayment(amount: String, tillNo: String, context: Context) {
        try {
            val intent = HoverParameters.Builder(context)
                .request(TILL_NO_ACTION_ID)
                .extra("till", tillNo)
                .extra("amount", amount)
                .buildIntent()

            startActivityForResult(intent, 0)
        } catch (e: Exception) {
            Timber.d("Hover Error: ${e.localizedMessage}")
            Toast.makeText(requireContext(), "Hover Error: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        try {
            if (requestCode == 0 && resultCode == RESULT_OK) {

                Toast.makeText(
                    requireContext(), "You will receive an M-Pesa confirmation message shortly",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (requestCode == 0 && resultCode == RESULT_CANCELED) {

                Toast.makeText(requireContext(), data?.getStringExtra("error"), Toast.LENGTH_SHORT)
                    .show()
                Timber.d("onActivityResult: ${data?.getStringExtra("error")}")
            }
        } catch (e: Exception) {
            Timber.d("onActivityResult: ${e.localizedMessage}")
        }
    }
}