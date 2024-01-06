package com.example.fackrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fackrestapi.Adapter.QueryProductAdapter
import com.example.fackrestapi.Interface.ProductApi
import com.example.fackrestapi.Model.ProductLimiteListItem
import com.example.fackrestapi.databinding.ActivityQueryDataBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QueryDataActivity : AppCompatActivity() {

    lateinit var binding: ActivityQueryDataBinding
    lateinit var adapter : QueryProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQueryDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

        var productapi = RetrofitHelper.getInstance().create(ProductApi::class.java)

        GlobalScope.launch {

            var product = productapi.getQuery(5)

            var datalist: List<ProductLimiteListItem>? = product.body()

            runOnUiThread {

                adapter = QueryProductAdapter(datalist)

                var manager = LinearLayoutManager(this@QueryDataActivity, LinearLayoutManager.VERTICAL, false)
                binding.recycleview.layoutManager = manager

                binding. recycleview.adapter = adapter


            }

        }
    }
}