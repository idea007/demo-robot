package com.dafay.demo.robot.ui.page.bezier

import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dafay.demo.lib.base.ui.base.BaseFragment
import com.dafay.demo.robot.R
import com.dafay.demo.robot.databinding.FragmentBezierBinding
import com.dafay.demo.robot.databinding.FragmentMagicBezierBinding

class MagicValueFragment : BaseFragment(R.layout.fragment_magic_bezier) {
    override val binding: FragmentMagicBezierBinding by viewBinding()

    override fun initViews() {
        super.initViews()
        binding.sbSeekbar.max = 1000000
        binding.sbSeekbar.progress = (0.55191 * 1000000).toInt()
        binding.sbSeekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var radio = progress.toFloat() / 1000000
                binding.mcbvMagic.setProgress(radio)
                binding.tvMagic.text = "当前数值：${radio}"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

}