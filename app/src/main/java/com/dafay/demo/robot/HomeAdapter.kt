package com.dafay.demo.robot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dafay.demo.lib.base.ui.adapter.BaseAdapter
import com.dafay.demo.robot.data.HomeItem
import com.dafay.demo.robot.databinding.ItemHomeBinding

/**
 * @ClassName HomeAdapter
 * @Desb
 * @Author lipengfei
 * @Date 2023/11/24 17:37
 */
class HomeAdapter : BaseAdapter<HomeItem>() {

    var onItemClickListener: HomeViewHolder.OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeViewHolder(ItemHomeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeViewHolder) {
            holder.onBindViewHolder(position, datas[position], onItemClickListener)
        }
    }


    class HomeViewHolder : RecyclerView.ViewHolder {

        val binding: ItemHomeBinding

        constructor(itemView: ItemHomeBinding) : super(itemView.root) {
            binding = itemView
        }

        fun onBindViewHolder(position: Int, homeItem: HomeItem, onItemClickListener: OnItemClickListener?) {
            binding.tvTitle.text = homeItem.title
            binding.cvCardview.setOnClickListener {
                onItemClickListener?.onClickItem(it, position, homeItem)
            }
        }

        interface OnItemClickListener {
            fun onClickItem(view: View, position: Int, homeItem: HomeItem)
        }
    }
}
