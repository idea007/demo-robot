package com.dafay.demo.robot.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.dafay.demo.robot.data.EmoteInfo
import com.dafay.demo.robot.databinding.LayoutFaceViewBinding


class FaceView @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var _binding: LayoutFaceViewBinding? = null
    val binding get() = _binding!!


    private var curProgress: Float = 0f
    private lateinit var startEmoteInfo: EmoteInfo
    private lateinit var endEmoteInfo: EmoteInfo

    init {
        _binding = LayoutFaceViewBinding.inflate(LayoutInflater.from(context), this)
        initViews()
    }

    private fun initViews() {

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        initStartAndEndFaceInfo()
    }

    private fun initStartAndEndFaceInfo() {
        startEmoteInfo = EmoteInfo()
        endEmoteInfo = startEmoteInfo
    }


    fun changeEmote(emoteInfo: EmoteInfo, isInvalidate: Boolean = true, progress: Float? = null) {
        // 获取当前状态的 EmoteInfo
        var tempEmoteInfo = EmoteInfo()
        tempEmoteInfo.faceVisualInfo = binding.cvFaceOrbit.getCurrentVisualInfo()
        startEmoteInfo = tempEmoteInfo
        endEmoteInfo = emoteInfo
        binding.cvFaceOrbit.changeVisualInfo(emoteInfo.faceVisualInfo,true,1f)
        binding.cvLeftCheekOrbit.changeVisualInfo(emoteInfo.leftCheekVisualInfo,true,1f)
        binding.cvLeftEyeOrbit.changeVisualInfo(emoteInfo.leftEyeVisualInfo,true,1f)
        binding.cvRightCheekOrbit.changeVisualInfo(emoteInfo.rightCheekVisualInfo,true,1f)
        binding.cvRightEyeOrbit.changeVisualInfo(emoteInfo.rightEyeVisualInfo,true,1f)
        binding.cvMouseOrbit.changeVisualInfo(emoteInfo.mouseVisualInfo,true,1f)
    }


    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _binding = null
    }


}
