package com.dafay.demo.robot.ui.face

import android.graphics.Color
import com.dafay.demo.robot.data.CurveShapeFactory
import com.dafay.demo.robot.data.DrawInfo
import com.dafay.demo.robot.data.EmoteInfo
import com.dafay.demo.robot.data.ViewPropertyInfo
import com.dafay.demo.robot.data.VisualInfo

/**
 * @Des
 * @Author lipengfei
 * @Date 2024/3/18
 */
object NuomiFace : BaseFace() {
    override val face: String = "小糯米"

    private val DEFAULT_HEAD_COLOR = Color.parseColor("#eae9ea")
    private val DEFAULT_EYE_COLOR = Color.parseColor("#000000")
    private val EYE_ORBIT_COLOR = Color.parseColor("#90f8b3c1")


    fun getEmote1(): EmoteInfo {
        var emoteInfo = EmoteInfo()
        emoteInfo.faceVisualInfo = VisualInfo(
            DrawInfo(
                0.75f,
                DEFAULT_HEAD_COLOR,
                CurveShapeFactory.形状_椭圆_窝窝头形状
            ), ViewPropertyInfo(0f, 0.1f, 1f, 1f)
        )
        emoteInfo.leftEyeVisualInfo = VisualInfo(DrawInfo(0.05f, DEFAULT_EYE_COLOR), ViewPropertyInfo(-0.3f, -0.22f))
        emoteInfo.leftCheekVisualInfo = VisualInfo(DrawInfo(0.1f, EYE_ORBIT_COLOR), ViewPropertyInfo(-0.35f, -0.1f, 1f, 0.3f))
        emoteInfo.rightEyeVisualInfo = VisualInfo(DrawInfo(0.05f, DEFAULT_EYE_COLOR), ViewPropertyInfo(0.3f, -0.22f))
        emoteInfo.rightCheekVisualInfo = VisualInfo(DrawInfo(0.1f, EYE_ORBIT_COLOR), ViewPropertyInfo(0.35f, -0.1f, 1f, 0.3f))
        emoteInfo.mouseVisualInfo =
            VisualInfo(DrawInfo(0.2f, DEFAULT_EYE_COLOR, CurveShapeFactory.形状_下半圆_1), ViewPropertyInfo(0f, 0.1f))
        return emoteInfo
    }

}