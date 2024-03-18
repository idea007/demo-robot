package com.dafay.demo.robot.data

import android.graphics.Paint
import android.graphics.PointF
import java.util.ArrayList

/**
 * 定义一段三阶贝塞尔曲线
 */
open class Curve {
    // 锚点一
    var anchorPoint1 = PointF(0f, 0f)

    // 控制点一
    var contPoint1 = PointF(0f, 0f)

    // 锚点二
    var anchorPoint2 = PointF(0f, 0f)

    // 控制点二
    var contPoint2 = PointF(0f, 0f)

    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (other !is Curve) {
            return false
        }
        return this.anchorPoint1.x == other.anchorPoint1.x &&
                this.anchorPoint1.y == other.anchorPoint1.y &&
                this.contPoint1.x == other.contPoint1.x &&
                this.contPoint1.y == other.contPoint1.y &&
                this.contPoint2.x == other.contPoint2.x &&
                this.contPoint2.y == other.contPoint2.y &&
                this.anchorPoint2.x == other.anchorPoint2.x &&
                this.anchorPoint2.y == other.anchorPoint2.y
    }
}

/**
 * 四段贝塞尔曲线组成一个形状
 */
open class CurveShape {

    // 四段贝塞尔曲线之间的链接状态 （现在只考虑首尾相连的情况，不考虑交叉想连）
    var isLink = true
    var centerX = 0f
    var centerY = 0f

    //半径 做为一个基础值，所有的计算都基于这个值
    var radius = 0f

    //存储四段贝塞尔曲线
    val curveList = ArrayList<Curve>()

    override fun equals(other: Any?): Boolean {
        if (this == null && other == null) {
            return true
        }
        other ?: return false

        if (other is CurveShape) {
            if (this.curveList.size != other.curveList.size) {
                return false
            }
            for (i in 0 until this.curveList.size) {
                if (!this.curveList[i].equals(other.curveList[i])) {
                    return false
                }
            }
            return this.isLink == other.isLink &&
                    this.centerX == other.centerX &&
                    this.centerY == other.centerY
        } else {
            return false
        }

    }

}


/** 控制一个 CurveShapeView 的绘制形状 作用于 onDraw
 * @param shapeType 形状类型
 * @interpolatorType 加速类型
 * @isDelay 是否是延迟     true 就是不执行动画
 * @radiusRatio radius 比例 ，用了改变形状大小 因为中心点就是view的中心，大小由radius控制
 * @targetColor 要变化到的颜色
 * @centerXRatio  这里通过比例来确定相对于中心点的位置
 * @centerYRatio 这里通过比例来确定相对于中心点的位置
 */
open class DrawInfo {
    var shapeType: String = CurveShapeFactory.形状_圆形
    var isLink: Boolean = true
    var radiusRatio: Float = 0.75f
    var targetColor: Int = Constants.TRANSPARENT_COLOR
    var centerXRatio: Float = 1f
    var centerYRatio: Float = 1f
    var paintStrokeWidthRatio: Float = 0f
    var paintSytle: Paint.Style = Paint.Style.FILL_AND_STROKE
    var paintCap: Paint.Cap = Paint.Cap.ROUND

    var duration: Long = Constants.DEFAULT_DURATION
    var interpolatorType: Int = 8
    var isDelay: Boolean = false

    constructor(
        radiusRatio: Float = 0.75f,
        targetColor: Int = Constants.TRANSPARENT_COLOR,
        animType: String = CurveShapeFactory.形状_圆形,
        isLink: Boolean = true,
        duration: Long = Constants.DEFAULT_DURATION,
        interpolatorType: Int = 8, isDelay: Boolean = false,
        centerXRatio: Float = 1f, centerYRatio: Float = 1f,
        paintStrokeWidthRatio: Float = 0f,
        paintSytle: Paint.Style = Paint.Style.FILL_AND_STROKE,
        paintCap: Paint.Cap = Paint.Cap.ROUND
    ) {
        this.radiusRatio = radiusRatio
        this.targetColor = targetColor
        this.shapeType = animType
        this.isLink = isLink
        this.duration = duration
        this.interpolatorType = interpolatorType
        this.isDelay = isDelay
        this.centerXRatio = centerXRatio
        this.centerYRatio = centerYRatio
        this.paintStrokeWidthRatio = paintStrokeWidthRatio
        this.paintSytle = paintSytle
        this.paintCap = paintCap
    }
}


/**
 * 主要 VurveShapeView 属性  transition ,scale,alpha,rotate
 */
open class ViewPropertyInfo {

    var translationXRatio: Float = 0f
    var translationYRatio: Float = 0f
    var scaleX: Float = 1f
    var scaleY: Float = 1f
    var alpha: Float = 1f
    var rotation: Float = 0f
    var rotationX: Float = 0f
    var rotationY: Float = 0f

    // 是否需要变换
    var isNedeChange = true

    // 是否比较过
    var isHaveCompute = false

    var duration: Long = Constants.DEFAULT_DURATION
    var interpolatorType: Int = 8
    var isDelay: Boolean = false

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


    override fun equals(other: Any?): Boolean {

        if (this == null && other == null) {
            return true
        }

        other ?: return false

        if (other is ViewPropertyInfo) {
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

/**
 * 协调 CurveShapeView 的位置和绘制等
 */
open class CSVVisualInfo {
    var drawInfo = DrawInfo()
    var viewPropertyInfo = ViewPropertyInfo()

    constructor(drawInfo: DrawInfo, viewPropertyInfo: ViewPropertyInfo) {
        this.drawInfo = drawInfo
        this.viewPropertyInfo = viewPropertyInfo
    }
}

/**
 * 表情信息
 */
open class EmoteInfo {
    var duration: Long = Constants.DEFAULT_DURATION
    var interpolatorType: Int = 8
    var isDelay: Boolean = false

    var faceVisualInfo = CSVVisualInfo(DrawInfoConst.DEFAULT_DRAWINFO_FACE, ViewPropertyInfoConst.DEFAULT_RENDERINFO_FACE)
    var leftEyeVisualInfo = CSVVisualInfo(DrawInfoConst.DEFAULT_DRAWINFO_ORBIT, ViewPropertyInfoConst.DEFAULT_RENDERINFO_LEFT_ORBIT)
    var leftCheekVisualInfo = CSVVisualInfo(DrawInfoConst.DEFAULT_DRAWINFO_ORBIT, ViewPropertyInfoConst.DEFAULT_RENDERINFO_LEFT_ORBIT)
    var rightEyeVisualInfo = CSVVisualInfo(DrawInfoConst.DEFAULT_DRAWINFO_FACE, ViewPropertyInfoConst.DEFAULT_RENDERINFO_RIGHT_ORBIT)
    var rightCheekVisualInfo = CSVVisualInfo(DrawInfoConst.DEFAULT_DRAWINFO_FACE, ViewPropertyInfoConst.DEFAULT_RENDERINFO_RIGHT_ORBIT)
    var mouseVisualInfo = CSVVisualInfo(DrawInfoConst.DEFAULT_DRAWINFO_ORBIT, ViewPropertyInfoConst.DEFAULT_RENDERINFO_DOWN_ORBIT)

}

///**
// * 主要用于 控制 draw 形状等
// */
//open class DrawInfoGroup() {
//
//    constructor(
//        isDelay: Boolean = false,
//        duration: Long = Constants.DEFAULT_DURATION,
//        interpolatorType: Int = 8
//
//    ) : this() {
//        this.duration = duration
//        this.interpolatorType = interpolatorType
//        this.isDelay = isDelay
//    }
//
//    // 头部形状
//    var firstHeadOrderInfo = DrawInfoConst.DEFAULT_DRAWINFO_FACE
//
//    // 左眼
//    var firstLeftEyeOrderInfo = DrawInfoConst.DEFAULT_DRAWINFO_ORBIT
//    var secondLeftEyeOrderInfo = DrawInfoConst.DEFAULT_DRAWINFO_ORBIT
//
//    // 右眼
//    var firstRightEyeOrderInfo = DrawInfoConst.DEFAULT_DRAWINFO_ORBIT
//    var secondRightEyeOrderInfo = DrawInfoConst.DEFAULT_DRAWINFO_ORBIT
//
//    // 嘴
//    var firstMouseOrderInfo = DrawInfoConst.DEFAULT_DRAWINFO_ORBIT
//
//    // 底部托盘
//    var trayOrderInfo = DrawInfoConst.DEFAULT_DRAWINFO_TRAY
//
//
//    var duration: Long = Constants.DEFAULT_DURATION
//    var interpolatorType: Int = 8
//    var isDelay: Boolean = false
//
//}
//
///**
// * 主要用于 控制 transition,scale,rotation 等信息
// */
//open class ObjectAnimInfoGroup() {
//
//    var duration: Long = Constants.DEFAULT_DURATION
//    var interpolatorType: Int = 8
//    var isDelay: Boolean = false
//
//    constructor(
//        isDelay: Boolean = false,
//        duration: Long = Constants.DEFAULT_DURATION,
//        interpolatorType: Int = 8
//
//    ) : this() {
//        this.duration = duration
//        this.interpolatorType = interpolatorType
//        this.isDelay = isDelay
//    }
//
//
//    // 头部形状
//    var firstHeadRenderInfo = Constants.DEFAULT_RENDERINFO_HEAD
//
//    // 左眼
//    var firstLeftEyeRenderInfo = Constants.DEFAULT_RENDERINFO_LEFT_ORBIT
//    var secondLeftEyeRenderInfo = Constants.DEFAULT_RENDERINFO_LEFT_ORBIT
//
//    // 右眼
//    var firstRightEyeRenderInfo = Constants.DEFAULT_RENDERINFO_RIGHT_ORBIT
//    var secondRightEyeRenderInfo = Constants.DEFAULT_RENDERINFO_RIGHT_ORBIT
//
//    // 嘴
//    var firstMouseRenderInfo = Constants.DEFAULT_RENDERINFO_DOWN_ORBIT
//
//    // 底部托盘
//    var trayRenderInfo = Constants.DEFAULT_RENDERINFO_TRAY
//
//
//}
//
//open class DrawAndAnimInfoGroup() {
//    var renderInfoGroup = ObjectAnimInfoGroup()
//    var orderInfoGroup = DrawInfoGroup()
//}
