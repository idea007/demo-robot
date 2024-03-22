package com.dafay.demo.robot.ui.page.test

import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dafay.demo.lib.base.ui.base.BaseFragment
import com.dafay.demo.robot.R
import com.dafay.demo.robot.data.EmoteInfo
import com.dafay.demo.robot.data.ViewPropertyInfo
import com.dafay.demo.robot.data.face.OliveFace
import com.dafay.demo.robot.databinding.FragmentRobotTestBinding
import com.dafay.demo.robot.data.role.OliveRole
import com.dafay.demo.robot.utils.AnimExecCallback

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

        binding.btnActionLefeLoke.setOnClickListener {
            binding.rvRobot.execAction(OliveRole.actionLeftLook())
        }

        binding.btnAnimLuffing.setOnClickListener {
            binding.rvRobot.luffingAnim()
//            binding.rvRobot.execEmotesAnim(arrayListOf(OliveFace.getEmote1(duration = 1000)), null)
        }
    }

//    private fun luffingAnim() {
//        var trayContainerViewPropertyInfos = ArrayList<ViewPropertyInfo>().apply {
//            add(ViewPropertyInfo(duration = 1000, scaleY = 1.1f, scaleX = 0.88f))
//            add(ViewPropertyInfo(duration = 1000, scaleY = 1f, scaleX = 1f))
//            add(ViewPropertyInfo(duration = 1000, scaleY = 1.1f, scaleX = 0.88f))
//            add(ViewPropertyInfo(duration = 1000, scaleY = 1f, scaleX = 1f))
//        }
//        var headViewPropertyInfos = ArrayList<ViewPropertyInfo>().apply {
//            add(ViewPropertyInfo(duration = 1000, translationYRatio = -0.1f))
//            add(ViewPropertyInfo(duration = 1000, translationYRatio = 0f))
//            add(ViewPropertyInfo(duration = 1000, translationYRatio = 0.1f))
//            add(ViewPropertyInfo(duration = 1000, translationYRatio = 0f))
//        }
//        binding.rvRobot.separateExecAnim(trayContainerViewPropertyInfos = trayContainerViewPropertyInfos,
//            headViewPropertyInfos = headViewPropertyInfos, headViewPropertyInfosCallback = object : AnimExecCallback {
//                override fun onAnimationAllFinish() {
//                    luffingAnim()
//                }
//            }
//        )
//    }
}