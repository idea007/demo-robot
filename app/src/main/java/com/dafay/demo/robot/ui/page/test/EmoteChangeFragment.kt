package com.dafay.demo.robot.ui.page.test

import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dafay.demo.lib.base.ui.base.BaseFragment
import com.dafay.demo.robot.R
import com.dafay.demo.robot.databinding.FragmentCurveShapeChangeBinding
import com.dafay.demo.robot.databinding.FragmentEmoteChangeBinding
import com.dafay.demo.robot.ui.face.NuomiFace
import com.dafay.demo.robot.ui.face.OliveFace

/**
 * 表情预览
 */
class EmoteChangeFragment : BaseFragment(R.layout.fragment_emote_change) {
    override val binding: FragmentEmoteChangeBinding by viewBinding()


    override fun initViews() {
        binding.sbSeekbar1.max = 100
        binding.fvFace.changeEmote(OliveFace.getEmote1())
    }

    override fun bindListener() {
        super.bindListener()
        binding.sbSeekbar1.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.fvFace.setProgress(progress.toFloat() / 100)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        binding.btnChange1.setOnClickListener {
            binding.fvFace.changeEmote(NuomiFace.getEmote1())
            binding.sbSeekbar1.progress = 0
        }

        binding.btnChange2.setOnClickListener {
            binding.fvFace.changeEmote(OliveFace.getEmote1())
            binding.sbSeekbar1.progress = 0
        }
    }
}