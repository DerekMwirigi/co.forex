package com.example.morgan.ui.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.morgan.R
import com.example.morgan.utils.OnRecyclerViewItemClick
import java.lang.ref.WeakReference

class HomeOptionPrimaryViewHolder (itemView: View, listener: OnRecyclerViewItemClick) : RecyclerView.ViewHolder(itemView), View.OnClickListener,
    View.OnLongClickListener {
    private val listenerWeakReference: WeakReference<OnRecyclerViewItemClick> = WeakReference(listener)
    var itemVew: View
    var label: TextView
    var description: TextView
    var image: ImageView
    init {
        this.itemVew = itemView
        label = itemView.findViewById(R.id.tvLabel)
        description = itemView.findViewById(R.id.tvDescription)
        image = itemView.findViewById(R.id.imgImage)
        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }
    override fun onLongClick(p0: View?): Boolean {
        listenerWeakReference.get()?.onLongClickListener(adapterPosition)
        return true
    }
    override fun onClick(v: View?) {
        listenerWeakReference.get()?.onClickListener(adapterPosition)
    }
}