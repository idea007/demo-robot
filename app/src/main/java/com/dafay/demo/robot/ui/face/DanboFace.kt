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
object DanboFace : BaseFace() {
    override val face: String = "纸盒"
    private val DEFAULT_FACE_COLOR = Color.parseColor("#6d6247")
    private val DEFAULT_EYE_COLOR = Color.parseColor("#801c1e1d")


    fun getEmote1(): EmoteInfo {
        var emoteInfo = EmoteInfo()
        emoteInfo.faceVisualInfo =
            VisualInfo(DrawInfo(1.0f, DEFAULT_FACE_COLOR, CurveShapeFactory.形状_正方形), ViewPropertyInfo(0f, 0f, 1f, 0.68f))
        emoteInfo.leftEyeVisualInfo = VisualInfo(DrawInfo(0.1f, DEFAULT_EYE_COLOR), ViewPropertyInfo(-0.28f, -0.1f))
        emoteInfo.rightEyeVisualInfo = VisualInfo(DrawInfo(0.1f, DEFAULT_EYE_COLOR), ViewPropertyInfo(0.28f, -0.1f))
        emoteInfo.mouseVisualInfo =
            VisualInfo(DrawInfo(0.3f, DEFAULT_EYE_COLOR, CurveShapeFactory.形状_三角形_1), ViewPropertyInfo(0f, 0.24f, 1f, 0.6f))
        return emoteInfo
    }

}