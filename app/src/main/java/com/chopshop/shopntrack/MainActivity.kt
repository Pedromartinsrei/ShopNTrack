package com.chopshop.shopntrack

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chopshop.shopntrack.databinding.ActivityAddShopBinding
import com.chopshop.shopntrack.shop.AddShopActivity
import com.chopshop.shopntrack.databinding.ActivityMainBinding
import com.chopshop.shopntrack.shop.Shop
import com.chopshop.shopntrack.shop.ShopActivity
import com.chopshop.shopntrack.shop.ShopAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private var shopList = ArrayList<Shop>();
    private val shopAdapter = ShopAdapter()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layout.shopList.adapter = shopAdapter
        binding.layout.shopList.layoutManager = LinearLayoutManager(this)


        if(shopList.isEmpty()) {
            binding.layout.emptyView.visibility = View.VISIBLE
        }
        else{
            binding.layout.emptyView.visibility = View.INVISIBLE
            binding.layout.shopList.visibility = View.VISIBLE
            shopAdapter.updateList(shopList)
            shopAdapter.notifyDataSetChanged()
        }


        setSupportActionBar(binding.toolbar)

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                // There are no request codes
                addShop(shopList, result.data)

                if(shopList.isEmpty()) {
                    binding.layout.emptyView.visibility = View.VISIBLE
                }
                else{
                    binding.layout.emptyView.visibility = View.INVISIBLE
                    binding.layout.shopList.visibility = View.VISIBLE
                }

                shopAdapter.updateList(shopList)
                shopAdapter.notifyDataSetChanged()
            }
        }

        binding.layout.shopList.setOnClickListener{
            val intent = Intent(this, ShopActivity::class.java)
            resultLauncher.launch(intent)
        }

        binding.actionAddShop.setOnClickListener{
            val intent = Intent(this, AddShopActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun addShop(shopList: ArrayList<Shop>,data: Intent?){
        val newShopName = data?.getStringExtra("shopName")
        val newShopType = data?.getStringExtra("shopType")
        val newShop = Shop(newShopName.toString(), newShopType.toString())
        shopList.add(newShop)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /*override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
}