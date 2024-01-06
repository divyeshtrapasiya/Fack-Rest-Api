package com.example.fackrestapi.Interface

import com.example.fackrestapi.Model.AddProductModel
import com.example.fackrestapi.Model.AddRowProductDetail
import com.example.fackrestapi.Model.CartDetailItem
import com.example.fackrestapi.Model.ProductDetail
import com.example.fackrestapi.Model.ProductItem
import com.example.fackrestapi.Model.ProductLimiteListItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {


    @GET("/products")
    suspend fun getproduct() : Response<List<ProductItem>>

    // =============== path perameter ============
    @GET("/products/{id}")
    suspend fun getproductdetail(@Path("id") productId : Int) : Response<ProductDetail>

    //==================== Query perameter =======================
    @GET("/carts")
    suspend fun getcartDetail(@Query("userId") userId : Int) : Response<List<CartDetailItem>>


    //========================== from data ======================


    @FormUrlEncoded
    @POST("/products")
    fun Addproduct(@Field("title") title: String, @Field("price") price: Int, @Field("description") description: String,
                   @Field("image") image: String, @Field("catagory") catagory: String) : Call<AddProductModel>


    // ======================== row data ================

    @POST("/products")
    fun AddrowDetail(@Body model: AddRowProductDetail):Call<AddProductModel>






    @GET("/products")
    suspend fun getQuery(@Query("limit") limit : Int) : Response<List<ProductLimiteListItem>>

}

