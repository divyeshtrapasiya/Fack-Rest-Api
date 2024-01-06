package com.example.fackrestapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fackrestapi.Model.CartDetailItem
import com.example.fackrestapi.R

class CartAdapter(var data: List<CartDetailItem>?) : RecyclerView.Adapter<CartAdapter.MyviewHolder>(){
    class MyviewHolder (v : View) : RecyclerView.ViewHolder(v){

        var txtid: TextView = v.findViewById(R.id.txtid)
        var txtuserId: TextView = v.findViewById(R.id.txtuserId)
        var txtproducts: TextView = v.findViewById(R.id.txtproducts)
        var txtdate: TextView = v.findViewById(R.id.txtdate)
        var txtv: TextView = v.findViewById(R.id.txtv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {

        var v = LayoutInflater.from(parent.context).inflate(R.layout.cart_item,parent,false)
        var holder = MyviewHolder(v)
        return holder

    }

    override fun getItemCount(): Int {

        return data?.size!!

    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        holder.txtid.text = data?.get(position)?.id.toString()
        holder.txtuserId.text = data?.get(position)?.userId.toString()
        holder.txtproducts.text = data?.get(position)?.products.toString()
        holder.txtdate.text = data?.get(position)?.date.toString()
        holder.txtv.text = data?.get(position)?.v.toString()

    }
}