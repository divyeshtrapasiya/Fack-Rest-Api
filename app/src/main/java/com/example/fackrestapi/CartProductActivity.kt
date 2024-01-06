package com.example.fackrestapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fackrestapi.Adapter.CartAdapter
import com.example.fackrestapi.Adapter.ProductAdapter
import com.example.fackrestapi.Interface.ProductApi
import com.example.fackrestapi.Model.CartDetailItem
import com.example.fackrestapi.databinding.ActivityCartProductBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CartProductActivity : AppCompatActivity() {

    lateinit var binding: ActivityCartProductBinding

    lateinit var adapter: CartAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

        var cartproductapi = RetrofitHelper.getInstance().create(ProductApi::class.java)

        GlobalScope.launch {

            var product = cartproductapi.getcartDetail(1)

            var datalist: List<CartDetailItem>? = product.body()

            runOnUiThread {

                adapter = CartAdapter(datalist)

                var manager = LinearLayoutManager(this@CartProductActivity, LinearLayoutManager.VERTICAL, false)
                binding.recycleview.layoutManager = manager

                binding. recycleview.adapter = adapter

            }

        }

    }
}
