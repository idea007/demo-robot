package com.dafay.demo.robot.ui.page.emote

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dafay.demo.lib.base.ui.base.BaseFragment
import com.dafay.demo.robot.R
import com.dafay.demo.robot.data.EmoteInfo
import com.dafay.demo.robot.databinding.FragmentEmotesPreviewBinding
import com.dafay.demo.robot.ui.face.OliveFace

/**
 * 表情预览
 */
class EmotesPreviewFragment : BaseFragment(R.layout.fragment_emotes_preview) {
    override val binding: FragmentEmotesPreviewBinding by viewBinding()
    private lateinit var emoteAdapter: EmoteAdapter
    private val emotes = ArrayList<EmoteInfo>().apply {
        add(OliveFace.getEmoteOne())
        add(OliveFace.getEmote2())
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
    }

    override fun initializeData() {
        emoteAdapter.setDatas(emotes)
    }

}