package com.ifixhubke.foody.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ifixhubke.foody.databinding.OtherHotelsRowBinding
import com.ifixhubke.foody.models.HotelModel

class OtherHotelAdapter:ListAdapter<HotelModel.HotelModelItem,OtherHotelAdapter.OtherHotelViewHolder>(Hotel2Diffutil) {
    inner class OtherHotelViewHolder(private val binding: OtherHotelsRowBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HotelModel.HotelModelItem?) {
            binding.hotelName2.text=item?.hotelName
            Glide.with(binding.hotelImage2)
                .load("")
                .into(binding.hotelImage2)
        }
    }

    object Hotel2Diffutil:DiffUtil.ItemCallback<HotelModel.HotelModelItem>() {
        override fun areItemsTheSame(
            oldItem: HotelModel.HotelModelItem,
            newItem: HotelModel.HotelModelItem
        ): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(
            oldItem: HotelModel.HotelModelItem,
            newItem: HotelModel.HotelModelItem
        ): Boolean {
            return oldItem.hotelName==newItem.hotelName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherHotelViewHolder {
        return OtherHotelViewHolder(OtherHotelsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: OtherHotelViewHolder, position: Int) {
        val item=getItem(position)
        holder.bind(item)
    }
}