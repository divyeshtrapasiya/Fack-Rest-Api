package com.example.fackrestapi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fackrestapi.Adapter.ProductAdapter
import com.example.fackrestapi.Interface.ProductApi
import com.example.fackrestapi.Model.ProductItem
import com.example.fackrestapi.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {


        var productapi = RetrofitHelper.getInstance().create(ProductApi::class.java)

        GlobalScope.launch {

            var product = productapi.getproduct()

            var datalist: List<ProductItem>? = product.body()

            runOnUiThread {

                adapter = ProductAdapter(datalist, onitemselect = { id, position ->

                    var i = Intent(this@MainActivity, ProductApiCallingActivity::class.java)
                    var selectproduct = datalist?.get(position)?.id
                    i.putExtra("id", selectproduct)
                    startActivity(i)
                })

                var manager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                binding.recycleview.layoutManager = manager

               binding. recycleview.adapter = adapter
            }
        }

        binding.btncart.setOnClickListener {

            var i = Intent(this,CartProductActivity::class.java)
            startActivity(i)

        }
        binding.btnadd.setOnClickListener {

            var i = Intent(this,DataEditPostMthodActivity::class.java)
            startActivity(i)

        }

        binding.btnquery.setOnClickListener {

            var i = Intent(this,QueryDataActivity::class.java)
            startActivity(i)

        }

    }

}

