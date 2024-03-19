package com.dafay.demo.robot.ui.view

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.dafay.demo.robot.data.EmoteInfo
import com.dafay.demo.robot.data.PoseInfo
import com.dafay.demo.robot.databinding.LayoutFaceViewBinding
import com.dafay.demo.robot.utils.AnimExecCallback
import com.dafay.demo.robot.utils.MultiAnimatorListener


class FaceView @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var _binding: LayoutFaceViewBinding? = null
    val binding get() = _binding!!

    private var curProgress: Float = 0f

    init {
        _binding = LayoutFaceViewBinding.inflate(LayoutInflater.from(context), this)
        initViews()
    }

    private fun initViews() {

    }

    fun changeEmote(emoteInfo: EmoteInfo, isInvalidate: Boolean = true, progress: Float = 0f) {
        this.curProgress = progress
        binding.cvFaceOrbit.changeVisualInfo(emoteInfo.faceVisualInfo, isInvalidate, progress)
        binding.cvLeftCheekOrbit.changeVisualInfo(emoteInfo.leftCheekVisualInfo, isInvalidate, progress)
        binding.cvLeftEyeOrbit.changeVisualInfo(emoteInfo.leftEyeVisualInfo, isInvalidate, progress)
        binding.cvRightCheekOrbit.changeVisualInfo(emoteInfo.rightCheekVisualInfo, isInvalidate, progress)
        binding.cvRightEyeOrbit.changeVisualInfo(emoteInfo.rightEyeVisualInfo, isInvalidate, progress)
        binding.cvMouseOrbit.changeVisualInfo(emoteInfo.mouseVisualInfo, isInvalidate, progress)
    }

    fun setProgress(progress: Float) {
        this.curProgress = progress
        binding.cvFaceOrbit.setProgress(progress)
        binding.cvLeftCheekOrbit.setProgress(progress)
        binding.cvLeftEyeOrbit.setProgress(progress)
        binding.cvRightCheekOrbit.setProgress(progress)
        binding.cvRightEyeOrbit.setProgress(progress)
        binding.cvMouseOrbit.setProgress(progress)
    }

    // 动画执行
    private var actionValueAnimator = ValueAnimator.ofFloat(0f, 1f)
    fun execAnim(emoteInfos: ArrayList<EmoteInfo>, callback: AnimExecCallback? = null) {
        if (emoteInfos.isNullOrEmpty()) {
            return
        }
        changeEmote(emoteInfos[0])
        cancelAnim()
        actionValueAnimator.setDuration(emoteInfos[0].duration)
        val listener = object : MultiAnimatorListener {
            override fun onAnimationUpdate(valueAnimator: ValueAnimator) {
                if (!emoteInfos[0].isDelay) {
                    setProgress(valueAnimator.animatedValue as Float)
                }
            }

            override fun onAnimationEnd(animation: Animator) {
                if (!emoteInfos[0].isDelay) {
                    setProgress(1f)
                }
                emoteInfos.removeAt(0)
                if (emoteInfos.isEmpty()) {
                    callback?.onAnimationAllFinish()
                } else {
                    execAnim(emoteInfos, callback)
                }
            }
        }
        actionValueAnimator.addUpdateListener(listener)
        actionValueAnimator.addListener(listener)
        actionValueAnimator.start()
    }

    fun cancelAnim() {
        actionValueAnimator.removeAllUpdateListeners()
        actionValueAnimator.removeAllListeners()
        actionValueAnimator.cancel()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        cancelAnim()
        _binding = null
    }
}
