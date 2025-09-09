package com.chopshop.shopntrack.shop

import android.annotation.SuppressLint
import android.content.Intent
import android.renderscript.RenderScript.Priority
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity.RESULT_OK
import androidx.recyclerview.widget.ListAdapter
import com.chopshop.shopntrack.databinding.ShopItemBinding
import kotlin.math.log

class ShopAdapter: ListAdapter<Shop, ShopViewHolder>(ShopDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val binding = ShopItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ShopViewHolder(binding);
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val shop = getItem(position)

        holder.bind(shop)
    }



    @SuppressLint("NotifyDataSetChanged")
    fun updateList(shopList: List<Shop>) {
        this.submitList(shopList)
    }

}