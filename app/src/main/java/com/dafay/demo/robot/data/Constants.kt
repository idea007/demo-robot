package com.dafay.demo.robot.data

import android.graphics.Color

/**
 *
 * @ClassName:      Constants$
 * @Description:    java类作用描述
 * @Author:         idea
 * @CreateDate:     2019-08-09$ 18:18$
 */

object Constants {


    // 一个常量，用来计算绘制圆形贝塞尔曲线控制点的位置
    const val C = 0.551915024494f

    // 默认动画执行时长 ms
    const val DEFAULT_DURATION: Long = 200

    // 透明色
    var TRANSPARENT_COLOR: Int = Color.TRANSPARENT

    // 头部 默认绘制信息
    val DEFAULT_DRAWINFO_HEAD = DrawInfo(0.8f)

    // 其它部分 默认绘制信息
    val DEFAULT_DRAWINFO_ORBIT = DrawInfo(0f)

    // 底部托盘 默认绘制信息
    val DEFAULT_DRAWINFO_TRAY = DrawInfo(0.3f)


    // 头部 默认动画信息
    val DEFAULT_RENDERINFO_HEAD = ObjectAnimInfo(0f, 0f, 1f, 0.75f)

    // 左眼 默认动画信息
    val DEFAULT_RENDERINFO_LEFT_ORBIT = ObjectAnimInfo(-0.3f)

    // 右眼 默认动画信息
    val DEFAULT_RENDERINFO_RIGHT_ORBIT = ObjectAnimInfo(0.3f)

    // 嘴巴 默认动画信息
    val DEFAULT_RENDERINFO_DOWN_ORBIT = ObjectAnimInfo(0f, 0.3f)

    // 托盘 默认动画信息
    val DEFAULT_RENDERINFO_TRAY = ObjectAnimInfo(0f, 0f, 1f, 0.2f)
}


/**
 * 主要控制 curveview 外部  transition ,scale,alpha,rotate
 */
open class ObjectAnimInfo {

    constructor(
        isDelay: Boolean = false,
        duration: Long = Constants.DEFAULT_DURATION,
        interpolatorType: Int = 8

    ) {
        this.duration = duration
        this.interpolatorType = interpolatorType
        this.isDelay = isDelay
    }

    constructor(
        translationXRatio: Float = 0f,
        translationYRatio: Float = 0f,
        scaleX: Float = 1f,
        scaleY: Float = 1f,
        alpha: Float = 1f,
        rotation: Float = 0f,
        rotationX: Float = 0f,
        rotationY: Float = 0f,

        duration: Long = Constants.DEFAULT_DURATION,
        interpolatorType: Int = 8,
        isDelay: Boolean = false
    ) {
        this.translationXRatio = translationXRatio
        this.translationYRatio = translationYRatio
        this.scaleX = scaleX
        this.scaleY = scaleY
        this.alpha = alpha
        this.rotation = rotation
        this.rotationX = rotationX
        this.rotationY = rotationY

        this.duration = duration
        this.interpolatorType = interpolatorType
        this.isDelay = isDelay
    }

    // 是否需要变换
    var isNedeChange = true

    // 是否比较过
    var isHaveCompute = false

    var duration: Long = Constants.DEFAULT_DURATION
    var interpolatorType: Int = 8
    var isDelay: Boolean = false

    var translationXRatio: Float = 0f
    var translationYRatio: Float = 0f

    var scaleX: Float = 1f
    var scaleY: Float = 1f

    var alpha: Float = 1f

    var rotation: Float = 0f
    var rotationX: Float = 0f
    var rotationY: Float = 0f


    override fun equals(other: Any?): Boolean {

        if (this == null && other == null) {
            return true
        }

        other ?: return false

        if (other is ObjectAnimInfo) {
            return this.translationXRatio == other.translationXRatio &&
                    this.translationYRatio == other.translationYRatio &&
                    this.scaleX == other.scaleX &&
                    this.scaleY == other.scaleY &&
                    this.alpha == other.alpha &&
                    this.rotation == other.rotation &&
                    this.rotationX == other.rotationX &&
                    this.rotationY == other.rotationY
        } else {
            return false
        }


    }
}