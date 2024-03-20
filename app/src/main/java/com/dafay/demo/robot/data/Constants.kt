package com.dafay.demo.robot.data

import android.graphics.Color


object DrawInfoConst{
    // 头部 默认绘制信息
    val DEFAULT_DRAWINFO_FACE = DrawInfo(0.8f)

    // 其它部分 默认绘制信息
    val DEFAULT_DRAWINFO_ORBIT = DrawInfo(0f)

    // 底部托盘 默认绘制信息
    val DEFAULT_DRAWINFO_TRAY = DrawInfo(0.3f)

}
object ViewPropertyInfoConst{

    // 头部 默认动画信息
    val DEFAULT_RENDERINFO_FACE = ViewPropertyInfo(0f, 0f, 1f, 0.75f)

    // 左眼 默认动画信息
    val DEFAULT_RENDERINFO_LEFT_ORBIT = ViewPropertyInfo(-0.3f)

    // 右眼 默认动画信息
    val DEFAULT_RENDERINFO_RIGHT_ORBIT = ViewPropertyInfo(0.3f)

    // 嘴巴 默认动画信息
    val DEFAULT_RENDERINFO_DOWN_ORBIT = ViewPropertyInfo(0f, 0.3f)

    // 托盘 默认动画信息
    val DEFAULT_RENDERINFO_TRAY = ViewPropertyInfo(0f, 0f, 1f, 0.2f)
}



object Constants {

    // 一个常量，用来计算绘制圆形贝塞尔曲线控制点的位置
    const val C = 0.551915024494f

    // 默认动画执行时长 ms
    const val DEFAULT_DURATION: Long = 200

    // 透明色
    var TRANSPARENT_COLOR: Int = Color.TRANSPARENT

    // 托盘 默认动画信息
    val DEFAULT_RENDERINFO_TRAY = ViewPropertyInfo(0f, 0f, 1f, 0.2f)
}


