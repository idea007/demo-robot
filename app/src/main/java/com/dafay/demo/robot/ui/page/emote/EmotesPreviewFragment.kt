package com.dafay.demo.robot.ui.page.emote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dafay.demo.lib.base.ui.base.BaseFragment
import com.dafay.demo.robot.R
import com.dafay.demo.robot.data.DrawAndAnimInfoGroup
import com.dafay.demo.robot.databinding.FragmentEmotesPreviewBinding
import com.dafay.demo.robot.ui.face.OliveFace

/**
 * 表情预览
 */
class EmotesPreviewFragment : BaseFragment(R.layout.fragment_emotes_preview) {
    override val binding: FragmentEmotesPreviewBinding by viewBinding()

    private val emotes = ArrayList<DrawAndAnimInfoGroup>().apply {
        add(OliveFace.getShapeOne())
    }



    override fun initViews() {
        super.initViews()
    }

}