package com.dafay.demo.robot.ui.face

import android.graphics.Color
import android.graphics.Paint
import com.dafay.demo.robot.data.CSVVisualInfo
import com.dafay.demo.robot.data.Constants
import com.dafay.demo.robot.data.CurveShapeFactory
import com.dafay.demo.robot.data.DrawInfo
import com.dafay.demo.robot.data.EmoteInfo
import com.dafay.demo.robot.data.ViewPropertyInfo

/**
 * @Des
 * @Author lipengfei
 * @Date 2024/3/18
 */
object OliveFace : BaseFace() {
    override val face: String = "小白"

    private val DEFAULT_FACE_COLOR = Color.parseColor("#ffffff")
    private val DEFAULT_EYE_COLOR = Color.parseColor("#0000FF")

    fun getShapeOne(
        isDelay: Boolean = false,
        duration: Long = Constants.DEFAULT_DURATION,
        interpolatorType: Int = 8
    ): EmoteInfo {
        var emoteInfo = EmoteInfo()
        emoteInfo.faceVisualInfo =
            CSVVisualInfo(DrawInfo(0.8f, DEFAULT_FACE_COLOR, CurveShapeFactory.形状_椭圆_1), ViewPropertyInfo(0f, 0f, 1f, 1f))
        emoteInfo.leftEyeVisualInfo = CSVVisualInfo(
            DrawInfo(
                0.15f,
                DEFAULT_EYE_COLOR,
                CurveShapeFactory.线_叉号_1, false,
                Constants.DEFAULT_DURATION,
                8,
                false,
                1f,
                1f,
                0.05f,
                Paint.Style.FILL_AND_STROKE,
                Paint.Cap.ROUND
            ), ViewPropertyInfo(-0.35f, 0.1f)
        )
        emoteInfo.rightEyeVisualInfo = CSVVisualInfo(
            DrawInfo(
                0.15f,
                DEFAULT_EYE_COLOR,
                CurveShapeFactory.线_叉号_1, false,
                Constants.DEFAULT_DURATION,
                8,
                false,
                1f,
                1f,
                0.05f,
                Paint.Style.FILL_AND_STROKE,
                Paint.Cap.ROUND
            ), ViewPropertyInfo(0.35f, 0.1f)
        )
        emoteInfo.isDelay = isDelay
        emoteInfo.duration = duration
        emoteInfo.interpolatorType = interpolatorType
        return emoteInfo
    }


}