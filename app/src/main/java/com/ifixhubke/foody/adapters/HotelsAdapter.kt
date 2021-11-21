package com.ifixhubke.foody.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ifixhubke.foody.databinding.HotelsRowBinding
import com.ifixhubke.foody.models.HotelModels


class HotelsAdapter : ListAdapter<HotelModels,HotelsAdapter.HotelViewHolder>(HotelDiffutil){
    inner class HotelViewHolder(private val binding: HotelsRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: HotelModels?) {
            binding.hotelName.text=item?.hotelName
            Glide.with(binding.hotelImage)
                .load(item?.hotelImage)
                .into(binding.hotelImage)
        }

    }
    object HotelDiffutil:DiffUtil.ItemCallback<HotelModels>(){
        override fun areItemsTheSame(oldItem: HotelModels, newItem: HotelModels): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: HotelModels, newItem: HotelModels): Boolean {
            return oldItem.hotelId == newItem.hotelId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        return HotelViewHolder(HotelsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


}