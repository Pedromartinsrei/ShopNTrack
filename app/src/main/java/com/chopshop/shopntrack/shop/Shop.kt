package com.chopshop.shopntrack.shop

import android.util.Log

class Shop(private var name: String, private var type: String){

    fun getName(): String {
        return name
    }

    fun getType(): String {
        return type
    }

    fun printShop(){
        //println(name + "\n" + type)
        Log.i("Current Items", name + "\n" + type); // Example of a debug log
    }
}