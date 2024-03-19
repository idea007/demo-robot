package com.dafay.demo.robot.ui.page.emote

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dafay.demo.lib.base.ui.base.BaseFragment
import com.dafay.demo.robot.R
import com.dafay.demo.robot.data.EmoteInfo
import com.dafay.demo.robot.databinding.FragmentEmotesPreviewBinding
import com.dafay.demo.robot.ui.face.DanboFace
import com.dafay.demo.robot.ui.face.EmojiFace
import com.dafay.demo.robot.ui.face.NuomiFace
import com.dafay.demo.robot.ui.face.OliveFace

/**
 * 表情预览
 */
class EmotesPreviewFragment : BaseFragment(R.layout.fragment_emotes_preview) {
    override val binding: FragmentEmotesPreviewBinding by viewBinding()
    private lateinit var emoteAdapter: EmoteAdapter
    private val emotes = ArrayList<EmoteInfo>().apply {
        add(OliveFace.getEmote1())
        add(OliveFace.getEmote2())
        add(OliveFace.getEmote3())
        add(EmojiFace.getEmote1())
        add(DanboFace.getEmote1())
        add(NuomiFace.getEmote1())
    }

    override fun initViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        emoteAdapter = EmoteAdapter()
        binding.rvRecyclerview.apply {
            val linearLayoutManager = LinearLayoutManager(requireContext())
            linearLayoutManager.orientation = RecyclerView.HORIZONTAL
            this.layoutManager = linearLayoutManager
            this.adapter = emoteAdapter
        }
        emoteAdapter.onItemListener=object :EmoteAdapter.EmoteHolder.OnItemListener{
            override fun onItemClick(position: Int, emoteInfo: EmoteInfo) {
                binding.fvFace1.changeEmote(emoteInfo)
                binding.fvFace2.changeEmote(emoteInfo)
                binding.fvFace3.changeEmote(emoteInfo)
            }
        }
    }

    override fun initializeData() {
        emoteAdapter.setDatas(emotes)
    }
}