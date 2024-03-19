package com.dafay.demo.robot.ui.face

import android.graphics.Color
import android.graphics.Paint
import by.kirich1409.viewbindingdelegate.viewBindingLazy
import com.dafay.demo.robot.data.Constants
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
object EmojiFace : BaseFace() {
    override val face: String = "表情"
    private val DEFAULT_COLOR = Color.parseColor("#fbbc05")

    fun getEmote1(): EmoteInfo {
        var emoteInfo = EmoteInfo()
        emoteInfo.faceVisualInfo = VisualInfo(
            DrawInfo(
                0.7f, DEFAULT_COLOR, CurveShapeFactory.形状_圆形, true, Constants.DEFAULT_DURATION, 8,
                false, 1f, 1f, 0.05f, Paint.Style.STROKE
            ), ViewPropertyInfo(0f, 0f, 1f, 1f)
        )
        emoteInfo.leftEyeVisualInfo = VisualInfo(
            DrawInfo(
                0.09f,
                DEFAULT_COLOR,
                CurveShapeFactory.线_向上箭头_1,
                true,
                Constants.DEFAULT_DURATION,
                8,
                false,
                1f,
                1f,
                0.04f,
                Paint.Style.STROKE,
                Paint.Cap.ROUND
            ), ViewPropertyInfo(-0.3f, -0.2f, 1.2f)
        )
        emoteInfo.rightEyeVisualInfo = VisualInfo(
            DrawInfo(
                0.09f,
                DEFAULT_COLOR,
                CurveShapeFactory.线_向上箭头_1,
                true,
                Constants.DEFAULT_DURATION,
                8,
                false,
                1f,
                1f,
                0.04f,
                Paint.Style.STROKE,
                Paint.Cap.ROUND
            ), ViewPropertyInfo(0.3f, -0.2f, 1.2f)
        )
        emoteInfo.mouseVisualInfo = VisualInfo(
            DrawInfo(
                0.3f,
                DEFAULT_COLOR,
                CurveShapeFactory.形状_下半圆_1,
                true,
                Constants.DEFAULT_DURATION,
                8,
                false,
                1f,
                1f,
                0.04f,
                Paint.Style.STROKE,
                Paint.Cap.ROUND
            ), ViewPropertyInfo(0f, 0.2f, 1f, 1f)
        )

        return emoteInfo

    }


}