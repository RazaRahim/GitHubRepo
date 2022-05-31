package com.dev.trendrepo.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.trendingrepo.data.model.Item
import com.dev.trendrepo.databinding.MainScreenItemBinding
class MainScreenFragmentAdapter(
    private var mContext: Context,
    private var mData: List<Item>,
) :
    RecyclerView.Adapter<MainScreenVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainScreenVH {
        return MainScreenVH(
            MainScreenItemBinding.inflate(
                LayoutInflater.from(mContext),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: MainScreenVH, position: Int) {
        val item = mData[position]
        holder.binding.textViewTitle.text = item.full_name
        holder.binding.textViewDesc.text = item.description

    }

    override fun getItemCount(): Int = mData.count()
}


class MainScreenVH(itemView: MainScreenItemBinding) : RecyclerView.ViewHolder(itemView.root) {
    var binding: MainScreenItemBinding = itemView
}