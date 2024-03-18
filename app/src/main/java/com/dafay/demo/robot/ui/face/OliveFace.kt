package com.dafay.demo.robot.ui.face

import android.graphics.Color
import android.graphics.Paint
import com.dafay.demo.robot.data.Constants
import com.dafay.demo.robot.data.CurveShapeFactory
import com.dafay.demo.robot.data.DrawAndAnimInfoGroup
import com.dafay.demo.robot.data.DrawInfo
import com.dafay.demo.robot.data.ObjectAnimInfo

/**
 * @Des
 * @Author lipengfei
 * @Date 2024/3/18
 */
object OliveFace :BaseFace(){
    override val face: String ="小白"

    private val DEFAULT_FACE_COLOR = Color.parseColor("#ffffff")
    private val DEFAULT_EYE_COLOR = Color.parseColor("#0000FF")





    fun getShapeOne(
        isDelay: Boolean = false,
        duration: Long = Constants.DEFAULT_DURATION,
        interpolatorType: Int = 8
    ): DrawAndAnimInfoGroup {

        var renderAndOrderGroup = DrawAndAnimInfoGroup()
        renderAndOrderGroup.renderInfoGroup.firstHeadRenderInfo = ObjectAnimInfo(0f, 0f, 1f, 1f)
        renderAndOrderGroup.renderInfoGroup.firstLeftEyeRenderInfo = ObjectAnimInfo(-0.35f, 0.1f)
        renderAndOrderGroup.renderInfoGroup.firstRightEyeRenderInfo = ObjectAnimInfo(0.35f, 0.1f)
        renderAndOrderGroup.renderInfoGroup.trayRenderInfo = Constants.DEFAULT_RENDERINFO_TRAY

        renderAndOrderGroup.renderInfoGroup.isDelay = isDelay
        renderAndOrderGroup.renderInfoGroup.duration = duration
        renderAndOrderGroup.renderInfoGroup.interpolatorType = interpolatorType


        renderAndOrderGroup.orderInfoGroup.firstHeadOrderInfo = DrawInfo(0.8f, DEFAULT_FACE_COLOR, CurveShapeFactory.形状_椭圆_1)
        renderAndOrderGroup.orderInfoGroup.firstLeftEyeOrderInfo = DrawInfo(
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
        )

        renderAndOrderGroup.orderInfoGroup.firstRightEyeOrderInfo = DrawInfo(
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
        )

        renderAndOrderGroup.orderInfoGroup.trayOrderInfo = DrawInfo(0.3f, DEFAULT_FACE_COLOR)

        return renderAndOrderGroup

    }


}