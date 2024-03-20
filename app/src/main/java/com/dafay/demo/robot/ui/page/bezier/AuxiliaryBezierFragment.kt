package com.dafay.demo.robot.ui.page.bezier

import by.kirich1409.viewbindingdelegate.viewBinding
import com.dafay.demo.lib.base.ui.base.BaseFragment
import com.dafay.demo.robot.R
import com.dafay.demo.robot.databinding.FragmentAuxiliaryBezierBinding
import com.dafay.demo.robot.ui.view.test.BezierAuxiliaryView

/**
 * @Des 坐标系里面看 三阶贝塞尔曲线
 * @Author lipengfei
 * @Date 2024/3/20
 */
class AuxiliaryBezierFragment : BaseFragment(R.layout.fragment_auxiliary_bezier) {
    override val binding: FragmentAuxiliaryBezierBinding by viewBinding()

    override fun initViews() {
        binding.bavAuxilibary.listener = object : BezierAuxiliaryView.OnMappingDataListener {
            override fun onBezierOneDataUpdate(
                startToCenterDistance: Double,
                startToCenterAngle: Float,
                endToCenterDistance: Double,
                endToCenterAngle: Float,
                cont1ToStartDistance: Double,
                cont1ToStartAngle: Float,
                cont2ToEndDistance: Double,
                cont2ToEndAngle: Float
            ) {
                var info = "距离单位百分之一的宽度\n"
                info += "锚点一距离中心点距离：" + startToCenterDistance.toString() + "\n"
                info += "锚点一相对中心点角度：" + startToCenterAngle.toString() + "\n\n"

                info += "控制点一距离锚点一距离：" + cont1ToStartDistance.toString() + "\n"
                info += "控制点一相对锚点一角度：" + cont1ToStartAngle.toString() + "\n\n"

                info += "锚点二距离中心点距离：" + endToCenterDistance.toString() + "\n"
                info += "锚点二相对中心点角度：" + endToCenterAngle.toString() + "\n\n"

                info += "控制点二距离锚点二距离：" + cont2ToEndDistance.toString() + "\n"
                info += "控制点二相对锚点二角度：" + cont2ToEndAngle.toString() + "\n\n"

                binding.tvInfo.text = info
            }

        }
    }

}