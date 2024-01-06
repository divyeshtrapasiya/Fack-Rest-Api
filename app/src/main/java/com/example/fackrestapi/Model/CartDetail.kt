package com.example.fackrestapi.Model

import com.google.gson.annotations.SerializedName

data class CartDetail(

	@field:SerializedName("CartDetail")
	val cartDetail: List<CartDetailItem?>? = null
)

data class CartDetailItem(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("__v")
	val v: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("userId")
	val userId: Int,

	@field:SerializedName("products")
	val products: List<ProductsItem> = ArrayList()
)

data class ProductsItem(

	@field:SerializedName("quantity")
	val quantity: Int? = null,

	@field:SerializedName("productId")
	val productId: Int? = null
)
