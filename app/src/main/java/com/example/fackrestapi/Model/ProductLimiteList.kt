package com.example.fackrestapi.Model

import com.google.gson.annotations.SerializedName

data class ProductLimiteList(

	@field:SerializedName("ProductLimiteList")
	val productLimiteList: List<ProductLimiteListItem?>? = null
)

data class ProductLimiteListItem(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("price")
	val price: Any,

	@field:SerializedName("rating")
	val rating: Ratingse,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("category")
	val category: String
)

data class Ratingse(

	@field:SerializedName("rate")
	val rate: Any? = null,

	@field:SerializedName("count")
	val count: Int? = null
)
