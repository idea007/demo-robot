package com.dafay.demo.robot.ui.view

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.LinearInterpolator
import android.widget.RelativeLayout
import com.dafay.demo.robot.data.Constants
import com.dafay.demo.robot.data.DrawInfo
import com.dafay.demo.robot.data.EmoteInfo
import com.dafay.demo.robot.data.PoseInfo
import com.dafay.demo.robot.data.ViewPropertyInfo
import com.dafay.demo.robot.data.VisualInfo
import com.dafay.demo.robot.data.face.OliveFace
import com.dafay.demo.robot.data.getCurrentViewPropertyInfo
import com.dafay.demo.robot.data.role.OliveRole
import com.dafay.demo.robot.data.updateViewPropertyByProgress
import com.dafay.demo.robot.databinding.LayoutRobotViewBinding
import com.dafay.demo.robot.utils.AnimExecCallback
import com.dafay.demo.robot.utils.MultiAnimatorListener
import com.dafay.demo.robot.utils.ViewAnimDelegate


class RobotView @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var _binding: LayoutRobotViewBinding? = null
    private val binding get() = _binding!!

    private var centerX = 0f

    private var curProgress: Float = 0f
    private lateinit var startPoseInfo: PoseInfo
    private lateinit var endPoseInfo: PoseInfo

    private val selfViewAnimDelegate: ViewAnimDelegate by lazy {
        ViewAnimDelegate(this, centerX)
    }

    private val headViewAnimDelegate: ViewAnimDelegate by lazy {
        ViewAnimDelegate(binding.flHeadContainer, centerX)
    }

    private val trayViewAnimDelegate: ViewAnimDelegate by lazy {
        ViewAnimDelegate(binding.flTrayContainer, centerX)
    }


    init {
        _binding = LayoutRobotViewBinding.inflate(LayoutInflater.from(context), this)
        initViews()
    }

    private fun initViews() {
        startPoseInfo = PoseInfo(EmoteInfo())
        endPoseInfo = PoseInfo(EmoteInfo())
        binding.cvTrayShape.changeVisualInfo(OliveRole.getTrayVisualInfo1(), true, 1f)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w.toFloat() / 2
    }

    fun changePose(poseInfo: PoseInfo, isInvalidate: Boolean = true, progress: Float = 0f) {
        this.curProgress = progress
        binding.fvFace.changeEmote(poseInfo.emoteInfo, isInvalidate, progress)
        // 是否改变颜色
//        binding.cvTrayShape.changeVisualInfo(poseInfo.trayVisualInfo, isInvalidate, progress)
        endPoseInfo = poseInfo
        if (centerX == 0f) {
            return
        }
        startPoseInfo.robotViewPropertyInfo = this.getCurrentViewPropertyInfo(centerX)
        startPoseInfo.headViewPropertyInfo = binding.flHeadContainer.getCurrentViewPropertyInfo(centerX)
        this.updateViewPropertyByProgress(centerX, startPoseInfo.robotViewPropertyInfo, poseInfo.robotViewPropertyInfo, progress)
        binding.flHeadContainer.updateViewPropertyByProgress(
            centerX,
            startPoseInfo.headViewPropertyInfo,
            poseInfo.headViewPropertyInfo,
            progress
        )
    }

    fun setProgress(progress: Float) {
        this.curProgress = progress
        binding.fvFace.setProgress(progress)
        binding.cvTrayShape.setProgress(progress)
        this.updateViewPropertyByProgress(centerX, startPoseInfo.robotViewPropertyInfo, endPoseInfo.robotViewPropertyInfo, progress)
        binding.flHeadContainer.updateViewPropertyByProgress(
            centerX,
            startPoseInfo.headViewPropertyInfo,
            endPoseInfo.headViewPropertyInfo,
            progress
        )
        updateTrayViewByHeadViewProperty()
    }

    /**
     * 根据头部属性去更改底部影子的属性
     */
    private fun updateTrayViewByHeadViewProperty() {
        binding.flTrayContainer.apply {
            val headViewPropertyInfo = binding.flHeadContainer.getCurrentViewPropertyInfo(centerX)
            scaleY = 1f + (headViewPropertyInfo.translationYRatio / 0.25f) * 0.08f
            scaleX = 1f + (headViewPropertyInfo.translationYRatio / 0.25f) * 0.08f
        }
    }

    // 整体一起执行动画
    private var actionValueAnimator = ValueAnimator.ofFloat(0f, 1f)
    fun execAction(posts: ArrayList<PoseInfo>, callback: AnimExecCallback? = null) {
        if (posts.isNullOrEmpty()) {
            return
        }
        changePose(posts[0])
        cancelActionAnim()
        actionValueAnimator.setDuration(posts[0].duration)
        val listener = object : MultiAnimatorListener {
            override fun onAnimationUpdate(valueAnimator: ValueAnimator) {
                if (!posts[0].isDelay) {
                    setProgress(valueAnimator.animatedValue as Float)
                }
            }

            override fun onAnimationEnd(animation: Animator) {
                if (!posts[0].isDelay) {
                    setProgress(1f)
                }
                posts.removeAt(0)
                if (posts.isEmpty()) {
                    callback?.onAnimationAllFinish()
                } else {
                    execAction(posts, callback)
                }
            }
        }
        actionValueAnimator.addUpdateListener(listener)
        actionValueAnimator.addListener(listener)
        actionValueAnimator.start()
    }

    private fun cancelActionAnim() {
        actionValueAnimator.removeAllUpdateListeners()
        actionValueAnimator.removeAllListeners()
        actionValueAnimator.cancel()
    }

    fun execEmotesAnim(
        emotes: ArrayList<EmoteInfo>,
        emotesCallback: AnimExecCallback? = null
    ) {
        binding.fvFace.execAnim(emotes, emotesCallback)
    }

    fun luffingAnim() {
        val DEFALUT_SPEED = 1
        // 上下摆动的进度
        var curLuffingProgress = 0
        var luffingValueAnimator = ValueAnimator.ofFloat(0f, 1f)
        luffingValueAnimator.setInterpolator(LinearInterpolator())
        luffingValueAnimator.setDuration(1000 * 60 * 60 * 24)
        luffingValueAnimator.addUpdateListener(ValueAnimator.AnimatorUpdateListener { animator ->
            curLuffingProgress += DEFALUT_SPEED
            binding.flHeadContainer.translationY = centerX * Math.sin(Math.toRadians((curLuffingProgress % 360).toDouble()))
                .toFloat() / 4
            updateTrayViewByHeadViewProperty()
        })
        luffingValueAnimator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        cancelActionAnim()
        _binding = null
    }
}
