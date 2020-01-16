package com.example.morgan.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.morgan.R
import com.example.morgan.models.main.home.HomeOptionPrimary
import com.example.morgan.utils.OnRecyclerViewItemClick

class HomeOptionPrimaryAdapter (private var modelList: List<HomeOptionPrimary>?, private val recyclerListener: OnRecyclerViewItemClick) : RecyclerView.Adapter<HomeOptionPrimaryViewHolder>() {
    var itemView: View? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeOptionPrimaryViewHolder {
        itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_homeoption_primary, parent, false)
        return HomeOptionPrimaryViewHolder(itemView!!, recyclerListener)
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: HomeOptionPrimaryViewHolder, position: Int) {
        val model = modelList!![position]
        holder.label.text = model.label
        holder.description.text = model.description
        Glide.with(itemView!!)
            .load(model.image)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return if (null != modelList) modelList!!.size else 0
    }

    fun refresh(modelList: List<HomeOptionPrimary>) {
        this.modelList = modelList
        notifyDataSetChanged()
    }
}