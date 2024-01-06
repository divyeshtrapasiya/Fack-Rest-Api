package com.example.fackrestapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fackrestapi.Model.ProductItem
import com.example.fackrestapi.R

class ProductAdapter(var data: List<ProductItem>?, var onitemselect  : ((id : Int, position : Int)->Unit)) : RecyclerView.Adapter<ProductAdapter.MyviewHolder>() {
    class MyviewHolder(v : View ) : RecyclerView.ViewHolder(v) {

        var txtid: TextView = v.findViewById(R.id.txtid)
        var txttitle: TextView = v.findViewById(R.id.txttitle)
        var txtcategory: TextView = v.findViewById(R.id.txtcategory)
        var txtdescription: TextView = v.findViewById(R.id.txtdescription)
        var txtrating: TextView = v.findViewById(R.id.txtrating)
        var txtprice: TextView = v.findViewById(R.id.txtprice)
        var Imgimage: ImageView = v.findViewById(R.id.Imgimage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        var holder = MyviewHolder(v)
        return holder
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {


        holder.itemView.setOnClickListener{

            onitemselect.invoke(data?.get(position)?.id!!,position)

        }

        holder.txtid.text = data?.get(position)?.id.toString()
        holder.txttitle.text = data?.get(position)?.title.toString()
        holder.txtcategory.text = data?.get(position)?.category.toString()
        holder.txtdescription.text = data?.get(position)?.description.toString()
        holder.txtrating.text = data?.get(position)?.ratings.toString()
        holder.txtprice.text = data?.get(position)?.price.toString()


        Glide.with(holder.itemView.context).load(data?.get(position)?.image).into(holder.Imgimage)

    }

    override fun getItemCount(): Int {
        return data?.size!!
    }
}