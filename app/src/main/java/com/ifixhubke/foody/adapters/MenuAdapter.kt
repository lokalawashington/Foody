package com.ifixhubke.foody.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ifixhubke.foody.databinding.FragmentMenuBinding
import com.ifixhubke.foody.databinding.MenuRowBinding
import com.ifixhubke.foody.models.MenuItems


class MenuAdapter:ListAdapter<MenuItems,MenuAdapter.MenuViewHolder>(MenuDiffUtil){
    inner class MenuViewHolder(private val binding: MenuRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: MenuItems?) {
            binding.textViewFoodName.text=item?.menuName
            binding.textViewFoodPrice.text=item?.menuPrice
            Glide.with(binding.imageViewFood)
                .load(item?.menuImage)
                .into(binding.imageViewFood)
        }
    }
    object MenuDiffUtil:DiffUtil.ItemCallback<MenuItems>(){
        override fun areItemsTheSame(oldItem: MenuItems, newItem: MenuItems): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: MenuItems, newItem: MenuItems): Boolean {
            return oldItem.id==newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(MenuRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item=getItem(position)
        holder.bind(item)
    }
}