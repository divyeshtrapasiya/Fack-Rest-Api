package com.example.fackrestapi.Model

import com.google.gson.annotations.SerializedName

data class ProductList(

	@field:SerializedName("Product")
	val productsList: ArrayList<ProductItem> = ArrayList()
)

data class Ratings(

	@field:SerializedName("rate")
	val rate: Any? = null,

	@field:SerializedName("count")
	val count: Int? = null
)

data class ProductItem(

    @field:SerializedName("image")
	val image: String,

    @field:SerializedName("price")
	val price: Any,

    @field:SerializedName("rating")
	val ratings: Ratings,

    @field:SerializedName("description")
	val description: String,

    @field:SerializedName("id")
	val id: Int,

    @field:SerializedName("title")
	val title: String,

    @field:SerializedName("category")
	val category: String,
)
