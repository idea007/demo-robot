package com.dafay.demo.robot.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.dafay.demo.robot.data.Constants
import com.dafay.demo.robot.data.CurveShape
import com.dafay.demo.robot.data.DrawAndAnimInfoGroup
import com.dafay.demo.robot.databinding.LayoutRobotViewBinding


class FaceView @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var _binding: LayoutRobotViewBinding? = null
    val binding get() = _binding!!



    private var curProgress: Float = 0f
    private lateinit var startDrawAndAnimInfoGroup: DrawAndAnimInfoGroup
    private lateinit var endDrawAndAnimInfoGroup: DrawAndAnimInfoGroup

    init {
        _binding = LayoutRobotViewBinding.inflate(LayoutInflater.from(context), this)
        initViews()
    }

    private fun initViews() {

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        initDefaultEmote()
        initStartAndEndFaceInfo()
    }

    private fun initStartAndEndFaceInfo() {
        startDrawAndAnimInfoGroup=DrawAndAnimInfoGroup()
    }

    // 初始化默认的表情
    private fun initDefaultEmote() {

        // 内部形状和颜色
        binding.cvHeadShape.resetRadiusRadio(Constants.DEFAULT_DRAWINFO_HEAD.radiusRatio)

        binding.cvLeftEyeOrbit1.resetRadiusRadio(Constants.DEFAULT_DRAWINFO_ORBIT.radiusRatio)
        binding.cvLeftEyeOrbit2.resetRadiusRadio(Constants.DEFAULT_DRAWINFO_ORBIT.radiusRatio)

        binding.cvRightEyeOrbit1.resetRadiusRadio(Constants.DEFAULT_DRAWINFO_ORBIT.radiusRatio)
        binding.cvRightEyeOrbit2.resetRadiusRadio(Constants.DEFAULT_DRAWINFO_ORBIT.radiusRatio)

        binding.cvMouseOrbit1.resetRadiusRadio(Constants.DEFAULT_DRAWINFO_ORBIT.radiusRatio)

        binding.cvTrayShape.resetRadiusRadio(Constants.DEFAULT_DRAWINFO_TRAY.radiusRatio)

    }

    fun changeEmote(drawAndAnimInfoGroup: DrawAndAnimInfoGroup) {

    }


    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _binding = null
    }




}
