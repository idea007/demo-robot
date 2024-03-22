package com.dafay.demo.robot.ui.page.test

import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dafay.demo.lib.base.ui.base.BaseFragment
import com.dafay.demo.robot.R
import com.dafay.demo.robot.databinding.FragmentRobotTestBinding
import com.dafay.demo.robot.data.role.OliveRole

/**
 * 表情预览
 */
class RobotTestFragment : BaseFragment(R.layout.fragment_robot_test) {
    override val binding: FragmentRobotTestBinding by viewBinding()


    override fun initViews() {
        binding.sbSeekbar1.max = 100
        binding.rvRobot.changePose(OliveRole.poseDefault(), true, 1f)
    }

    override fun bindListener() {
        super.bindListener()
        binding.sbSeekbar1.max = 100
        binding.sbSeekbar1.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.rvRobot.setProgress(progress.toFloat() / 100)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        binding.btnChange1.setOnClickListener {
            binding.rvRobot.changePose(OliveRole.poseTrunLeft(), true, 1f)
            binding.sbSeekbar1.progress = 100
        }

        binding.btnChange2.setOnClickListener {
            binding.rvRobot.changePose(OliveRole.poseTurnLeftCloseEyes(), true, 1f)
            binding.sbSeekbar1.progress = 100
        }

        binding.btnActionLeftLook.setOnClickListener {
            binding.rvRobot.execAction(OliveRole.actionLookLeft())
        }

        binding.btnActionRightLook.setOnClickListener {
            binding.rvRobot.execAction(OliveRole.actionLookRight())
        }

        binding.btnActionLeftMove.setOnClickListener {
            binding.rvRobot.execAction(OliveRole.actionLeftMove())
        }

        binding.btnAnimLuffing.setOnClickListener {
            binding.rvRobot.luffingAnim()
        }
    }

}