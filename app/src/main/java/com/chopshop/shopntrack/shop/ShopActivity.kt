package com.chopshop.shopntrack.shop

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chopshop.shopntrack.R

class ShopActivity : AppCompatActivity()  {
    //private lateinit var binding: ActivityAddShopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = ActivityAddShopBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        //setSupportActionBar(binding.toolbar)


        /*val navController = findNavController(R.id.nav_host_fragment_content_add_shop)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        */

        //val myLayout = binding.layout;
    }

    private fun addShop(shopName: String,shopType: String){
        Toast.makeText(this,"New shop added!", Toast.LENGTH_LONG).show()
        val intent = Intent()
        intent.putExtra("shopName",shopName)
        intent.putExtra("shopType",shopType)
        setResult(RESULT_OK, intent)
        this.finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        /*val navController = findNavController(R.id.nav_host_fragment_content_add_shop)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
                */
        return true;
    }
}