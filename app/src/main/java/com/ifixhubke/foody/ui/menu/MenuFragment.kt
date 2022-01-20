package com.ifixhubke.foody.ui.menu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.database.*
import com.ifixhubke.foody.adapters.MenuAdapter
import com.ifixhubke.foody.databinding.FragmentMenuBinding
import com.ifixhubke.foody.models.MenuItems
import java.util.ArrayList

private const val TAG = "MenuFragment"
class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private val args: MenuFragmentArgs by navArgs()
    private lateinit var menuItems: MenuItems
    private lateinit var databaseReference: DatabaseReference
    private val menuAdapter by lazy {
        MenuAdapter(MenuAdapter.OnClickListener {item ->

            Toast.makeText(requireContext(), "${item.menuName}", Toast.LENGTH_SHORT).show()
            val action = MenuFragmentDirections.actionMenuFragmentToOrderFragment(item,args.hotelargs)
            findNavController().navigate(action)

        })
    }

    private val menuArrayList: ArrayList<MenuItems> = ArrayList<MenuItems>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_menu, container, false)
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.d(TAG, "onCreateView: ${args.hotelargs.hotelMenu}")
        databaseReference = FirebaseDatabase.getInstance().reference

        databaseReference.child("menus").child(args.hotelargs.hotelName.toString())
            .addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.d(TAG, "Hotel: ${args.hotelargs.hotelName} "+"onDataChange: ${snapshot}")

                    if (snapshot.exists()){
                        for (i in snapshot.children){
                            val myMenuItems = i.getValue(MenuItems::class.java)
                            if (myMenuItems != null){
                                //args.hotelargs.hotelMenu?.let { menuArrayList.add(it) }
                                menuArrayList.add(myMenuItems)
                                Log.d(TAG, "onDataChange: $menuArrayList")
                            }
                        }
                        menuAdapter.submitList(menuArrayList)
                        binding.menuRecycler.adapter = menuAdapter
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Menu items do not exist",
                            Toast.LENGTH_SHORT
                        ).show()
                    }



                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(requireContext(), "An error $error occurred", Toast.LENGTH_SHORT)
                        .show()
                }

            })

        return view
    }
}