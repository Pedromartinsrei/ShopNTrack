package com.chopshop.shopntrack.shop

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chopshop.shopntrack.databinding.ShopItemBinding

class ShopViewHolder(private val binding: ShopItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(shop:Shop){
        binding.shopName.text = shop.getName();
        binding.shopType.text = shop.getType();
    }


}