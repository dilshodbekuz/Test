package com.example.android

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.databinding.ItemRvBinding

class ProductAdapter(val item:List<Product>):RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    class ViewHolder(val binding: ItemRvBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = item[position]
        holder.binding.image.setImageResource(items.image)
        holder.binding.name.text = items.name
        holder.binding.price.text = items.price.toString()
    }

    override fun getItemCount(): Int {
        return item.count()
    }
}