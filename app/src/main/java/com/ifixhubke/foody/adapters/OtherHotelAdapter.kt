package com.ifixhubke.foody.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ifixhubke.foody.databinding.OtherHotelsRowBinding
import com.ifixhubke.foody.models.HotelModels


class OtherHotelAdapter(private val onClickListener: OnClickListener):ListAdapter<HotelModels,OtherHotelAdapter.OtherHotelViewHolder>(OtherHotelDiffutil){
    inner class OtherHotelViewHolder(private val binding: OtherHotelsRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: HotelModels?) {
            binding.hotelName2.text = item?.hotelName
            Glide.with(binding.hotelImage2)
                .load(item?.hotelImage)
                .into(binding.hotelImage2)
        }

    }
    object OtherHotelDiffutil:DiffUtil.ItemCallback<HotelModels>(){
        override fun areItemsTheSame(oldItem: HotelModels, newItem: HotelModels): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: HotelModels, newItem: HotelModels): Boolean {
            return oldItem.hotelId == newItem.hotelId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherHotelViewHolder {
        return OtherHotelViewHolder(OtherHotelsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: OtherHotelViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }

    }
    class OnClickListener(val clickListener: (hotelModel: HotelModels) -> Unit) {
        fun onClick(hotelModel: HotelModels) = clickListener(hotelModel)}

}