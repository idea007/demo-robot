package com.dafay.demo.robot.ui.view

import android.animation.ArgbEvaluator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.dafay.demo.robot.data.CSVVisualInfo
import com.dafay.demo.robot.data.CurveShape
import com.dafay.demo.robot.data.CurveShapeFactory
import com.dafay.demo.robot.data.DrawInfo
import com.dafay.demo.robot.data.ViewPropertyInfo
import com.dafay.demo.robot.data.getCurrentCurveShape
import com.dafay.demo.robot.data.getCurveShapePaths
import java.util.*

public class CurveShapeView @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val TAG = CurveShapeView::class.java.name


    // 默认颜色 透明
    private var DEFAULT_COLOR = Color.TRANSPARENT

    // 默认 mRadiusRatio 比例，这个比例相对于 mCenterX
    private val DEFAULT_RADIUS_RATIO = 0.8f

    // View 宽高
    private var viewWidth = 0f
    private var viewHeight = 0f
    private var centerX = 0f


    // 画笔
    private val paint: Paint by lazy { Paint(Paint.ANTI_ALIAS_FLAG) }        //画笔


    // 用于颜色渐变处理
    private val argbEvaluator = ArgbEvaluator()//渐变色计算类
    private var startColor: Int = DEFAULT_COLOR
    private var endColor: Int = DEFAULT_COLOR

    private var startStrokeWidth = 0f
    private var endStrokeWidth = 0f

    private var paintCap = Paint.Cap.ROUND
    private var radiusRatio: Float = DEFAULT_RADIUS_RATIO

    private var curProgress: Float = 0f
    private lateinit var startCurveShape: CurveShape
    private lateinit var endCurveShape: CurveShape

    var paths = ArrayList<Path>()

    private var initCurveShapeType: String = CurveShapeFactory.形状_圆形
    private var drawInfo: DrawInfo? = null

    init {
        initPaint()
    }

    private fun initPaint() {
        Log.i(TAG, "---- init()")
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeCap = paintCap
        paint.color = DEFAULT_COLOR
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.w(TAG, "---- onSizeChanged()")
        viewWidth = w.toFloat()
        viewHeight = h.toFloat()
        centerX = viewWidth / 2
        startStrokeWidth = centerX * 0f
        endStrokeWidth = centerX * 0f
        paint.strokeWidth = startStrokeWidth
        initStartAndEndCurveShape(initCurveShapeType)
    }


    fun resetRadiusRadio(radiusRadio: Float) {
        if (radiusRadio != radiusRatio) {
            radiusRatio = radiusRadio
            initStartAndEndCurveShape(initCurveShapeType)
            invalidate()
        }
    }

    fun updateEndCurveShapeRadiusRadio(animType: String, radiusRadio: Float) {
        if (radiusRadio != this.radiusRatio) {
            this.radiusRatio = radiusRadio
            endCurveShape = CurveShapeFactory.getCurveGroupByType(
                animType,
                endCurveShape.isLink,
                endCurveShape.radius,
                centerX,
                radiusRatio,
                centerX,
                radiusRatio
            )
            invalidate()
        }
    }

    fun updateStrokeWidthRatio(strokeWidthRatio: Float) {
        this.endStrokeWidth = centerX * strokeWidthRatio
        this.startStrokeWidth = centerX * strokeWidthRatio / 2
        invalidate()
    }

    private fun initStartAndEndCurveShape(type: String) {
        initCurveShapeType = type

        startCurveShape = CurveShapeFactory.getCurveGroupByType(
            CurveShapeFactory.形状_圆形,
            true,
            radiusRatio,
            centerX,
            1f,
            centerX,
            1f
        )
        endCurveShape = startCurveShape
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCurveShape(canvas)
    }


    private fun drawCurveShape(canvas: Canvas) {
        if (startColor != endColor) {
            paint.color = argbEvaluator.evaluate(curProgress, startColor, endColor) as Int
        }

        if (startStrokeWidth != endStrokeWidth) {
            paint.strokeWidth = startStrokeWidth + (endStrokeWidth - startStrokeWidth) * curProgress
        }

        paths =
            startCurveShape.getCurrentCurveShape(endCurveShape, curProgress).getCurveShapePaths()
        for (path in paths) {
            canvas.drawPath(path, paint)
        }
    }

    fun setProgress(progress: Float) {
        curProgress = progress
        invalidate()
    }


    // 是否需要变换
    private var isNedeChange = true

    // 是否比较过
    private var isHaveCompute = false

    fun changeEndCurveShape(orderInfo: DrawInfo, isInvalidate: Boolean = false) {
        this.drawInfo = orderInfo
        endCurveShape = CurveShapeFactory.getCurveGroupByType(
            orderInfo.shapeType,
            orderInfo.isLink,
            orderInfo.radiusRatio,
            centerX,
            orderInfo.centerXRatio,
            centerX,
            orderInfo.centerYRatio
        )
        invalidate()
    }

    fun changeCurveShape(orderInfo: DrawInfo, isInvalidate: Boolean = false) {
        Log.w(TAG, "---- changeCurveGroup")
        this.drawInfo = orderInfo
        if (!orderInfo.isDelay) {
            isNedeChange = true
            isHaveCompute = false
            // start target curvegroup的设置
            if (curProgress > 0f && curProgress < 1f) {
                startCurveShape = startCurveShape.getCurrentCurveShape(endCurveShape, curProgress)
            } else {
                startCurveShape = endCurveShape
            }

            endCurveShape = CurveShapeFactory.getCurveGroupByType(
                orderInfo.shapeType,
                orderInfo.isLink,
                orderInfo.radiusRatio,
                centerX,
                orderInfo.centerXRatio,
                centerX,
                orderInfo.centerYRatio
            )

            if (!isHaveCompute) {
                isHaveCompute = true
                if (endCurveShape.equals(startCurveShape) && !isNadeUpdatePaint(orderInfo)) {
                    isNedeChange = false
                } else {
                    updatePaint(orderInfo)
                }
            }
        }
        if (isInvalidate) {
            invalidate()
        }

    }

    private fun isNadeUpdatePaint(orderInfo: DrawInfo): Boolean {

        var isNadeUpdatePaint = false

        startStrokeWidth = paint.getStrokeWidth()
        endStrokeWidth = centerX * orderInfo.paintStrokeWidthRatio

        if (startStrokeWidth != endStrokeWidth) {
            isNadeUpdatePaint = true
        }

        startColor = paint.getColor()
        endColor = orderInfo.targetColor

        if (startColor != endColor) {
            isNadeUpdatePaint = true
        }

        if (paint.style != orderInfo.paintSytle) {
            paint.style = orderInfo.paintSytle
            isNadeUpdatePaint = true
        }

        if (paint.strokeCap != orderInfo.paintCap) {
            isNadeUpdatePaint = true
            paint.strokeCap = orderInfo.paintCap
        }

        return isNadeUpdatePaint

    }


    // 根据切换到的状态更新画笔
    private fun updatePaint(orderInfo: DrawInfo) {

        startStrokeWidth = paint.getStrokeWidth()
        endStrokeWidth = centerX * orderInfo.paintStrokeWidthRatio

        startColor = paint.getColor()
        endColor = orderInfo.targetColor

        paint.style = orderInfo.paintSytle
        paint.strokeCap = orderInfo.paintCap
    }

    fun getCurrentVisualInfo(): CSVVisualInfo {
        var viewPropertyInfo = getCurrentViewPropertyInfo()
        var drawInfo: DrawInfo = getCurrentDrawInfo()
        val visualInfo = CSVVisualInfo(drawInfo, viewPropertyInfo);
        return visualInfo
    }

    private fun getCurrentViewPropertyInfo(): ViewPropertyInfo {
        var viewPropertyInfo = ViewPropertyInfo()
        viewPropertyInfo.translationXRatio = this.translationX / this.centerX
        viewPropertyInfo.translationYRatio = this.translationY / this.centerX
        viewPropertyInfo.scaleX = this.scaleX
        viewPropertyInfo.scaleY = this.scaleY
        viewPropertyInfo.alpha = this.alpha
        viewPropertyInfo.rotation = this.rotation
        viewPropertyInfo.rotationX = this.rotationX
        viewPropertyInfo.rotationY = this.rotationY
        return viewPropertyInfo
    }



    private fun getCurrentDrawInfo(): DrawInfo {
        return drawInfo?:DrawInfo()
    }


}
