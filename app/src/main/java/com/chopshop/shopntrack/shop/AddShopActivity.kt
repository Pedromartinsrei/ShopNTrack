package com.chopshop.shopntrack.shop

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigator
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.chopshop.shopntrack.R
import com.chopshop.shopntrack.databinding.ActivityAddShopBinding

class AddShopActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAddShopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddShopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        /*val navController = findNavController(R.id.nav_host_fragment_content_add_shop)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        */

        val myLayout = binding.layout;

        myLayout.save.setOnClickListener{
            val name = myLayout.shopName.text;
            val type = myLayout.shopType.text;

            if(name.toString().isEmpty() && type.toString().isEmpty()){
                Toast.makeText(this,R.string.nothing_filled,Toast.LENGTH_SHORT).show()
            }
            else if(name.toString().isEmpty()){
                Toast.makeText(this,R.string.no_name,Toast.LENGTH_SHORT).show()
            }
            else if(type.toString().isEmpty()){
                Toast.makeText(this,R.string.no_type,Toast.LENGTH_SHORT).show()
            }
            else {
                addShop(name.toString(),type.toString())
            }
        }
    }

    private fun addShop(shopName: String,shopType: String){
        Toast.makeText(this,"New shop added!",Toast.LENGTH_LONG).show()
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