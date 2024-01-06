package com.example.fackrestapi

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fackrestapi.Interface.ProductApi
import com.example.fackrestapi.Model.AddProductModel
import com.example.fackrestapi.Model.AddRowProductDetail
import com.example.fackrestapi.databinding.ActivityDataEditPostMthodBinding
import retrofit2.Call
import retrofit2.Response

class DataEditPostMthodActivity : AppCompatActivity() {

    lateinit var binding: ActivityDataEditPostMthodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataEditPostMthodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

        binding.btnfromdata.setOnClickListener {


            var title = binding.Tiedttitle.text.toString()
            var price = binding.Tiedtprice.text.toString().toInt()
            var description = binding.Tiedtdescription.text.toString()
            var image = binding.Tiedtimage.text.toString()
            var catagory = binding.Tiedtcatagory.text.toString()

            var productapi = RetrofitHelper.getInstance().create(ProductApi::class.java)

            productapi.Addproduct(title, price, description, image, catagory)
                .enqueue(object : retrofit2.Callback<AddProductModel> {
                    override fun onResponse(
                        call: Call<AddProductModel>,
                        response: Response<AddProductModel>
                    ) {

                        if (response != null && response.isSuccessful) {

                            var i = Intent(this@DataEditPostMthodActivity,DataDisplayActivity::class.java)
                            i.putExtra("id",response.body().toString())
                            i.putExtra("title",title)
                            startActivity(i)

                            Log.e(TAG, "Fromdatacalling ====>: " + response.body())

                        }

                    }

                    override fun onFailure(call: Call<AddProductModel>, t: Throwable) {
                        Log.e(TAG, "onFailure: " + t.message)
                    }

                })


            binding.Tiedttitle.setText(null)
            binding.Tiedtdescription.setText(null)
            binding.Tiedtimage.setText(null)
            binding.Tiedtprice.setText(null)
            binding.Tiedtcatagory.setText(null)


        }

        binding.btnrowdata.setOnClickListener {


            var title = binding.Tiedttitle.text.toString()
            var price = binding.Tiedtprice.text.toString().toInt()
            var description = binding.Tiedtdescription.text.toString()
            var image = binding.Tiedtimage.text.toString()
            var catagory = binding.Tiedtcatagory.text.toString()

            var productapi = RetrofitHelper.getInstance().create(ProductApi::class.java)

            var model = AddRowProductDetail(title,price,description,image,catagory)

            productapi.AddrowDetail(model).enqueue(object : retrofit2.Callback<AddProductModel> {
                    override fun onResponse(
                        call: Call<AddProductModel>,
                        response: Response<AddProductModel>
                    ) {

                        if (response != null && response.isSuccessful) {

                            Log.e(TAG, " Rowdatacalling====>: " + response.body())

                        }

                    }

                    override fun onFailure(call: Call<AddProductModel>, t: Throwable) {
                        Log.e(TAG, "onFailure: " + t.message)
                    }

                })


            binding.Tiedttitle.setText(null)
            binding.Tiedtdescription.setText(null)
            binding.Tiedtimage.setText(null)
            binding.Tiedtprice.setText(null)
            binding.Tiedtcatagory.setText(null)


        }


    }
}