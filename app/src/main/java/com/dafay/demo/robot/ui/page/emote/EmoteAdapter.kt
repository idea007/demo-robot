package com.dafay.demo.robot.ui.page.emote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dafay.demo.lib.base.ui.adapter.BaseAdapter
import com.dafay.demo.robot.data.EmoteInfo
import com.dafay.demo.robot.databinding.ItemEmoteBinding

/**
 * @ClassName HomeAdapter
 * @Desb
 * @Author lipengfei
 * @Date 2023/11/24 17:37
 */
class EmoteAdapter : BaseAdapter<EmoteInfo>() {
    var onItemListener: EmoteHolder.OnItemListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EmoteHolder(ItemEmoteBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is EmoteHolder) {
            holder.onBindViewHolder(position, datas[position], onItemListener)
        }
    }

    class EmoteHolder : RecyclerView.ViewHolder {

        val binding: ItemEmoteBinding

        constructor(itemView: ItemEmoteBinding) : super(itemView.root) {
            binding = itemView
        }

        fun onBindViewHolder(position: Int, emoteInfo: EmoteInfo, onItemListener: OnItemListener?) {
            binding.fvFace.changeEmote(emoteInfo)
            binding.fvFace.setOnClickListener {
                onItemListener?.onItemClick(position, emoteInfo)
            }
        }

        interface OnItemListener {
            fun onItemClick(position: Int, emoteInfo: EmoteInfo)
        }
    }
}
