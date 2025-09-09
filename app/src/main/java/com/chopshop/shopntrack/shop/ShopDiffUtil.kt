package com.chopshop.shopntrack.shop

import androidx.recyclerview.widget.DiffUtil


object ShopDiffUtil : DiffUtil.ItemCallback<Shop>() {
    override fun areItemsTheSame(oldItem: Shop, newItem: Shop): Boolean {
        //This is to check if the item its self is the same this will use the equality function of the object.
        //Alternatively if you are using a database and have a id you can you that.
        return oldItem.getName() == newItem.getName()
    }

    override fun areContentsTheSame(oldItem: Shop, newItem: Shop): Boolean {
        //This Goes a bit deeper and checks to make sure the data of the object is the same.
        return oldItem.getName() == newItem.getName() && oldItem.getType() == newItem.getType()
    }

}

