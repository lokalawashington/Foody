package com.ifixhubke.foody.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.*
import com.ifixhubke.foody.R
import com.ifixhubke.foody.adapters.HotelsAdapter
import com.ifixhubke.foody.adapters.OtherHotelAdapter
import com.ifixhubke.foody.databinding.FragmentDashboardBinding
import com.ifixhubke.foody.models.HotelModels
import java.util.*

private const val TAG = "DashboardFragment"
class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding

    private lateinit var databaseReference: DatabaseReference
    private lateinit var hotelAdopter :HotelsAdapter
    private lateinit var nearHotelAdopter :HotelsAdapter
    private lateinit var otherHotelAdapter :OtherHotelAdapter

    private val hotelArrayList: ArrayList<HotelModels> = ArrayList<HotelModels>()
    private val nearhotelArrayList: ArrayList<HotelModels> = ArrayList<HotelModels>()
    private val otherHotelArrayList: ArrayList<HotelModels> = ArrayList<HotelModels>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDashboardBinding.inflate(layoutInflater, container, false)
        databaseReference = FirebaseDatabase.getInstance().reference


        binding.searchHotel.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(editable: Editable?) {filter(editable.toString())
            }

        })
        hotelAdopter = HotelsAdapter(HotelsAdapter.OnClickListener { hotel ->
            val action = DashboardFragmentDirections.actionDashboardFragmentToMenuFragment(hotel)
            findNavController().navigate(action)
            Log.d(TAG, "onCreateView: ${hotel.hotelMenu}")
        })
        nearHotelAdopter = HotelsAdapter(HotelsAdapter.OnClickListener { hotel ->
            val action = DashboardFragmentDirections.actionDashboardFragmentToMenuFragment(hotel)
            findNavController().navigate(action)
        })
        otherHotelAdapter = OtherHotelAdapter(OtherHotelAdapter.OnClickListener { hotel ->
            val action = DashboardFragmentDirections.actionDashboardFragmentToMenuFragment(hotel)
            findNavController().navigate(action)
        })


        getPopularHotels()
        getNearByHotels()
        getOtherHotels()
        return binding.root
    }

    private fun getPopularHotels() {
        databaseReference.child("popular_hotels")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (i in snapshot.children) {
                            val hotelModels: HotelModels? = i.getValue(HotelModels::class.java)
                            if (hotelModels != null) {
                                hotelArrayList.add(hotelModels)
                            }
                        }
                        hotelAdopter.submitList(hotelArrayList)
                        binding.hotelRecycler.adapter = hotelAdopter
                    } else {
                        Toast.makeText(requireContext(), "Data Does not Exist", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }

    private fun getNearByHotels() {
        databaseReference.child("nearby_hotels")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (i in snapshot.children) {
                            val hotelModels: HotelModels? = i.getValue(HotelModels::class.java)
                            if (hotelModels != null) {
                                nearhotelArrayList.add(hotelModels)
                            }
                        }
                        nearHotelAdopter.submitList(nearhotelArrayList)
                        binding.nearByHotelRecycler.adapter = nearHotelAdopter
                    } else {
                        Toast.makeText(requireContext(), "Data Does not exist", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                }
            })
    }

    private fun getOtherHotels() {
        databaseReference.child("hotels")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (i in snapshot.children) {
                            val hotelModels: HotelModels? = i.getValue(HotelModels::class.java)
                            if (hotelModels != null) {
                                otherHotelArrayList.add(hotelModels)
                            }
                        }
                        otherHotelAdapter.submitList(otherHotelArrayList)
                        binding.otherHotelRecycler.adapter = otherHotelAdapter
                    } else {
                        Toast.makeText(requireContext(), "Data Does not exist", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                }
            })
    }

    fun filter(e: String) {
        val filteredlist: ArrayList<HotelModels> = ArrayList<HotelModels>()
        for (item in otherHotelArrayList) {
            if (item.hotelName!!.lowercase().contains(e.lowercase())) {
                filteredlist.add(item)
            }
        }
        otherHotelAdapter.submitList(filteredlist)
    }

}