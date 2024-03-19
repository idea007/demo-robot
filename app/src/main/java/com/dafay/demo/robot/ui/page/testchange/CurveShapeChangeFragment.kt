package com.dafay.demo.robot.ui.page.testchange

import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dafay.demo.lib.base.ui.base.BaseFragment
import com.dafay.demo.robot.R
import com.dafay.demo.robot.databinding.FragmentCurveShapeChangeBinding
import com.dafay.demo.robot.ui.face.OliveFace

/**
 * 表情预览
 */
class CurveShapeChangeFragment : BaseFragment(R.layout.fragment_curve_shape_change) {
    override val binding: FragmentCurveShapeChangeBinding by viewBinding()


    override fun initViews() {
        binding.sbSeekbar1.max = 100
        binding.cvShape.changeVisualInfo(OliveFace.getEmote2().leftEyeVisualInfo, true, 1f)
    }

    override fun bindListener() {
        super.bindListener()
        binding.sbSeekbar1.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.cvShape.setProgress(progress.toFloat() / 100)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        binding.btnChange.setOnClickListener {
            binding.cvShape.changeVisualInfo(OliveFace.getEmote3().leftEyeVisualInfo, true, 0f)
            binding.sbSeekbar1.progress = 0
        }
    }
}