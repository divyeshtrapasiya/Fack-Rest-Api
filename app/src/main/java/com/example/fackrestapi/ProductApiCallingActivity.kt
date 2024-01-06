package com.example.fackrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.fackrestapi.Interface.ProductApi
import com.example.fackrestapi.Model.ProductDetail
import com.example.fackrestapi.Model.ProductItem
import com.example.fackrestapi.databinding.ActivityProductApiCallingBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductApiCallingActivity : AppCompatActivity() {

    lateinit var binding  : ActivityProductApiCallingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductApiCallingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

        var productapi = RetrofitHelper.getInstance().create(ProductApi::class.java)



        GlobalScope.launch {

            var id = intent.getIntExtra("id",1)


            var product = productapi.getproductdetail(id)

            var data : ProductDetail?= product.body()


            runOnUiThread {

                if (data != null)
                {

                    binding.txtid.text = data.id.toString()
                    binding.txttitle.text = data.title.toString()
                    binding.txtcategory.text =data.category.toString()
                    binding.txtdescription.text = data.description.toString()
                    binding.txtrating.text =data.rating.toString()
                    binding.txtprice.text = data.price.toString()

                    Glide.with(binding.Imgimage).load(data.image).into(binding.Imgimage)


                }

            }

        }


    }
}