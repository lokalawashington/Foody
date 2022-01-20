package com.ifixhubke.foody.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ifixhubke.foody.databinding.FragmentOrderBinding
import com.ifixhubke.foody.models.Order


class OrderFragment : Fragment() {
    private lateinit var button: Button
    private lateinit var order: Order
    private lateinit var binding : FragmentOrderBinding
    private var tableNo = 1
    private var foodQuantity = 1
    private val args: OrderFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root

        val food_order = args.foodOrder

        binding.orderFoodName.text = food_order.menuName.toString()

        binding.orderFoodBtn.text = food_order.menuPrice.toString()

        Glide.with(binding.orderFoodPic)
            .load(food_order.menuImage)
            .into(binding.orderFoodPic)

        Glide.with(binding.orderHotelPic)
            .load(args.hotelDet.hotelImage)
            .into(binding.orderHotelPic)


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
//            val bundle = Bundle().apply {
//                putSerializable("order",)
//            }

//            showDialog()
            order = Order(foodQuantity,tableNo.toString(),foodQuantity, food_order.menuName.toString())

            val action = OrderFragmentDirections.actionOrderFragmentToConfirmationCustomDialog(order)
            findNavController().navigate(action)
        }


        return view
    }

    private fun showDialog() {
        ConfirmationCustomDialog().show(childFragmentManager,"Custom dialog")
    }

}