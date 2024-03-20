package com.dafay.demo.robot.utils

import android.animation.Animator
import android.animation.ValueAnimator
import android.view.View
import com.dafay.demo.robot.data.ViewPropertyInfo
import com.dafay.demo.robot.data.getCurrentViewPropertyInfo
import com.dafay.demo.robot.data.updateViewPropertyByProgress

class ViewAnimDelegate(val targetView: View, val ruler: Float) {

    private var startViewPropertyInfo: ViewPropertyInfo
    private var endViewPropertyInfo: ViewPropertyInfo
    private var curProgress: Float = 0f

    init {
        startViewPropertyInfo = targetView.getCurrentViewPropertyInfo(ruler)
        endViewPropertyInfo = targetView.getCurrentViewPropertyInfo(ruler)
    }


    fun changeViewPropertyInfo(viewPropertyInfo: ViewPropertyInfo) {
        startViewPropertyInfo = targetView.getCurrentViewPropertyInfo(ruler)
        endViewPropertyInfo = viewPropertyInfo
        curProgress = 0f

    }

    // 动画执行
    private var actionValueAnimator = ValueAnimator.ofFloat(0f, 1f)
    fun execAnim(viewPropertyInfos: ArrayList<ViewPropertyInfo>, callback: AnimExecCallback? = null) {
        if (viewPropertyInfos.isNullOrEmpty()) {
            return
        }
        changeViewPropertyInfo(viewPropertyInfos[0])
        cancelAnim()
        actionValueAnimator.setDuration(viewPropertyInfos[0].duration)
        val listener = object : MultiAnimatorListener {
            override fun onAnimationUpdate(valueAnimator: ValueAnimator) {
                if (!viewPropertyInfos[0].isDelay) {
                    setProgress(valueAnimator.animatedValue as Float)
                }
            }

            override fun onAnimationEnd(animation: Animator) {
                if (!viewPropertyInfos[0].isDelay) {
                    setProgress(1f)
                }
                viewPropertyInfos.removeAt(0)
                if (viewPropertyInfos.isEmpty()) {
                    callback?.onAnimationAllFinish()
                } else {
                    execAnim(viewPropertyInfos, callback)
                }
            }
        }
        actionValueAnimator.addUpdateListener(listener)
        actionValueAnimator.addListener(listener)
        actionValueAnimator.start()
    }

    private fun setProgress(progress: Float) {
        targetView.updateViewPropertyByProgress(ruler, startViewPropertyInfo, endViewPropertyInfo, progress)
    }

    fun cancelAnim() {
        actionValueAnimator.removeAllUpdateListeners()
        actionValueAnimator.removeAllListeners()
        actionValueAnimator.cancel()
    }


}