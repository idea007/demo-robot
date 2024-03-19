package com.dafay.demo.robot.utils

import android.animation.Animator
import android.animation.ValueAnimator

/**
 * @Des
 * @Author lipengfei
 * @Date 2024/3/19
 */
class AnimUtils {
}

interface AnimExecCallback{
   fun onAnimationAllFinish()
}

interface MultiAnimatorListener : ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    override fun onAnimationUpdate(animation: ValueAnimator) {

    }

    override fun onAnimationStart(animation: Animator) {

    }

    override fun onAnimationEnd(animation: Animator) {

    }

    override fun onAnimationCancel(animation: Animator) {

    }

    override fun onAnimationRepeat(animation: Animator) {

    }

}