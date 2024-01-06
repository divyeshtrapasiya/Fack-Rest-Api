package com.example.fackrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fackrestapi.Interface.ProductApi
import com.example.fackrestapi.databinding.ActivityDataDisplayBinding

class DataDisplayActivity : AppCompatActivity() {

    lateinit var binding: ActivityDataDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

        var id = intent.getStringExtra("id")

        binding.txtid.setText(id)





    }
}