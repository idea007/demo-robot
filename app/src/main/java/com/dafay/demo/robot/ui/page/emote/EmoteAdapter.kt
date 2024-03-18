package com.dafay.demo.robot.ui.page.emote

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.recyclerview.widget.RecyclerView
import com.dafay.demo.lib.base.ui.adapter.BaseAdapter
import com.dafay.demo.robot.data.Constants
import com.dafay.demo.robot.data.DrawAndAnimInfoGroup
import com.dafay.demo.robot.data.DrawInfo
import com.dafay.demo.robot.databinding.ItemCurveshapeBinding
import com.dafay.demo.robot.databinding.ItemEmoteBinding

/**
 * @ClassName HomeAdapter
 * @Desb
 * @Author lipengfei
 * @Date 2023/11/24 17:37
 */
class EmoteAdapter : BaseAdapter<DrawAndAnimInfoGroup>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EmoteHolder(ItemEmoteBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is EmoteHolder) {
            holder.onBindViewHolder(position, datas[position])
        }
    }

    class EmoteHolder : RecyclerView.ViewHolder {

        val binding: ItemEmoteBinding

        constructor(itemView: ItemEmoteBinding) : super(itemView.root) {
            binding = itemView
        }

        fun onBindViewHolder(position: Int, drawAndAnimInfoGroup: DrawAndAnimInfoGroup) {
          binding.fvFace.changeEmote(drawAndAnimInfoGroup)
        }
    }
}
