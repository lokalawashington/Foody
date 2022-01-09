package com.ifixhubke.foody.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.ifixhubke.foody.databinding.FragmentOrderBinding


class OrderFragment : Fragment() {
    private lateinit var button: Button
    private lateinit var binding : FragmentOrderBinding
    private var tableNo = 1
    private var foodQuantity = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.orderFoodTableNumberMinus.setOnClickListener {
           if(tableNo > 1)
           {
               tableNo -= 1
           }
            val tableNoMinus = tableNo
            binding.orderTableNumber.text = tableNoMinus.toString()
        }
        binding.orderFoodTableNumberAdd.setOnClickListener {
            tableNo += 1
            val tableNoAdd = tableNo
            binding.orderTableNumber.text = tableNoAdd.toString()
        }
        binding.orderFoodQuantityMinus.setOnClickListener {
            if (foodQuantity > 1){
                foodQuantity -= 1
            }
            val toStr = foodQuantity
            binding.orderFoodQuantity.text = toStr.toString()
        }
        binding.orderFoodQuantityAdd.setOnClickListener {
            foodQuantity += 1
            val toStr = foodQuantity
            binding.orderFoodQuantity.text = toStr.toString()
        }
        binding.orderFoodBtn.setOnClickListener {
            showDialog()
        }


        return view
    }

    private fun showDialog() {
        ConfirmationCustomDialog().show(childFragmentManager,"Custom dialog")
    }

}