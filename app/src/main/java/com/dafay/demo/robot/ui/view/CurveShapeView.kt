package com.dafay.demo.robot.ui.view

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.dafay.demo.lib.base.utils.debug
import com.dafay.demo.robot.data.VisualInfo
import com.dafay.demo.robot.data.CurveShape
import com.dafay.demo.robot.data.DrawInfo
import com.dafay.demo.robot.data.EmoteInfo
import com.dafay.demo.robot.data.ViewPropertyInfo
import com.dafay.demo.robot.data.getCurrentCurveShape
import com.dafay.demo.robot.data.getCurrentViewPropertyInfo
import com.dafay.demo.robot.data.getCurveShape
import com.dafay.demo.robot.data.getCurveShapePaths
import com.dafay.demo.robot.data.updateViewPropertyByProgress
import com.dafay.demo.robot.utils.AnimExecCallback
import com.dafay.demo.robot.utils.MultiAnimatorListener
import com.google.gson.Gson

class CurveShapeView @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    // 默认颜色 透明
    private var DEFAULT_COLOR = Color.TRANSPARENT

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

    private var curProgress: Float = 0f
    private lateinit var startVisualInfo: VisualInfo
    private lateinit var endVisualInfo: VisualInfo

    // 起始时的 curveShape
    private var startCurveShape: CurveShape? = null
    // 缓存绘制过程中生成的 curveShape，以便发送切换时作为起始
    private var cacheCurCurveShape: CurveShape? = null

    init {
        debug("init()")
        initPaint()
        initStartAndEndVisualInfo()
    }

    private fun initPaint() {
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeCap = paintCap
        paint.color = DEFAULT_COLOR
    }

    private fun initStartAndEndVisualInfo() {
        startVisualInfo = VisualInfo(DrawInfo(), ViewPropertyInfo())
        endVisualInfo = VisualInfo(DrawInfo(), ViewPropertyInfo())
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        debug("onSizeChanged()")
        viewWidth = w.toFloat()
        viewHeight = h.toFloat()
        centerX = viewWidth / 2
        startStrokeWidth = centerX * 0f
        endStrokeWidth = centerX * 0f
        paint.strokeWidth = startStrokeWidth
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCurveShape(canvas)
    }

    private fun drawCurveShape(canvas: Canvas) {
        // 与 changeVisualInfo 呼应，这个时候 centerX >0
        if (startCurveShape == null) {
            this.startCurveShape = startVisualInfo.drawInfo.getCurveShape(centerX)
            updatePaint(endVisualInfo.drawInfo)
            if (curProgress > 0) {
                updateViewPropertyByProgress(centerX,startVisualInfo.viewPropertyInfo, endVisualInfo.viewPropertyInfo, curProgress)
            }
        }
        if (startColor != endColor) {
            paint.color = argbEvaluator.evaluate(curProgress, startColor, endColor) as Int
        }
        if (startStrokeWidth != endStrokeWidth) {
            paint.strokeWidth = startStrokeWidth + (endStrokeWidth - startStrokeWidth) * curProgress
        }
        startCurveShape?.let {
            cacheCurCurveShape = it.getCurrentCurveShape(endVisualInfo.drawInfo.getCurveShape(centerX), curProgress)
            val paths = cacheCurCurveShape!!.getCurveShapePaths()
            for (path in paths) {
                canvas.drawPath(path, paint)
            }
        }
    }

    /**
     * 切换
     */
    fun changeVisualInfo(visualInfo: VisualInfo, isInvalidate: Boolean = true, progress: Float = 0f) {
        this.curProgress = progress
        this.startVisualInfo = getCurrentVisualInfo()
        this.endVisualInfo = visualInfo
        debug("changeVisualInfo()")
        // 如果 changeVisualInfo 时，还没有进行测量，直接返回，延迟到 onDraw 里面执行切换后的逻辑
        if (centerX <= 0) {
            return
        }
        if (cacheCurCurveShape != null) {
            this.startCurveShape = cacheCurCurveShape
        } else {
            this.startCurveShape = startVisualInfo.drawInfo.getCurveShape(centerX)
        }
        if (curProgress > 0) {
            updateViewPropertyByProgress(centerX,startVisualInfo.viewPropertyInfo, endVisualInfo.viewPropertyInfo, curProgress)
        }
        updatePaint(endVisualInfo.drawInfo)
        if (isInvalidate) {
            invalidate()
        }
    }

    fun setProgress(progress: Float) {
        curProgress = progress
        updateViewPropertyByProgress(centerX,startVisualInfo.viewPropertyInfo, endVisualInfo.viewPropertyInfo, curProgress)
        invalidate()
    }

    fun updateStrokeWidthRatio(endStrokeWidthRatio: Float, startStrokeWidthRatio: Float = 0f) {
        this.endStrokeWidth = centerX * endStrokeWidthRatio
        this.startStrokeWidth = centerX * startStrokeWidthRatio
        invalidate()
    }

    /**
     * 是否需要更新画笔
     */
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

    /**
     * 根据切换到的状态更新画笔
     */
    private fun updatePaint(targetDrawInfo: DrawInfo) {
        startStrokeWidth = paint.getStrokeWidth()
        endStrokeWidth = centerX * targetDrawInfo.paintStrokeWidthRatio
        startColor = paint.getColor()
        endColor = targetDrawInfo.targetColor
        paint.style = targetDrawInfo.paintSytle
        paint.strokeCap = targetDrawInfo.paintCap
    }

    /**
     * 获取当前的 visualInfo
     */
    fun getCurrentVisualInfo(): VisualInfo {
        var viewPropertyInfo = getCurrentViewPropertyInfo()
        var drawInfo: DrawInfo = getCurrentDrawInfo()
        val visualInfo = VisualInfo(drawInfo, viewPropertyInfo);
        return visualInfo
    }

    private fun getCurrentViewPropertyInfo(): ViewPropertyInfo {
        if (centerX <= 0f) {
            return return endVisualInfo.viewPropertyInfo
        }
        return this.getCurrentViewPropertyInfo(this.centerX)
    }

    private fun getCurrentDrawInfo(): DrawInfo {
        var drawInfo = DrawInfo()
        drawInfo.shapeType = endVisualInfo.drawInfo.shapeType
        drawInfo.isLink = endVisualInfo.drawInfo.isLink
        drawInfo.radiusRatio = endVisualInfo.drawInfo.radiusRatio
        drawInfo.targetColor = paint.color
        drawInfo.centerXRatio = endVisualInfo.drawInfo.centerXRatio
        drawInfo.centerYRatio = endVisualInfo.drawInfo.centerYRatio
        drawInfo.paintStrokeWidthRatio = endVisualInfo.drawInfo.paintStrokeWidthRatio
        drawInfo.paintSytle = endVisualInfo.drawInfo.paintSytle
        drawInfo.paintCap = endVisualInfo.drawInfo.paintCap
        return drawInfo
    }

    // 动画执行
    private var actionValueAnimator = ValueAnimator.ofFloat(0f, 1f)
    fun execAnim(visualInfos: ArrayList<VisualInfo>, callback: AnimExecCallback? = null) {
        if (visualInfos.isNullOrEmpty()) {
            return
        }
        changeVisualInfo(visualInfos[0])
        cancelAnim()
        actionValueAnimator.setDuration(visualInfos[0].duration)
        val listener = object : MultiAnimatorListener {
            override fun onAnimationUpdate(valueAnimator: ValueAnimator) {
                if (!visualInfos[0].isDelay) {
                    setProgress(valueAnimator.animatedValue as Float)
                }
            }
            override fun onAnimationEnd(animation: Animator) {
                if (!visualInfos[0].isDelay) {
                    setProgress(1f)
                }
                visualInfos.removeAt(0)
                if (visualInfos.isEmpty()) {
                    callback?.onAnimationAllFinish()
                } else {
                    execAnim(visualInfos, callback)
                }
            }
        }
        actionValueAnimator.addUpdateListener(listener)
        actionValueAnimator.addListener(listener)
        actionValueAnimator.start()
    }

    fun cancelAnim() {
        actionValueAnimator.removeAllUpdateListeners()
        actionValueAnimator.removeAllListeners()
        actionValueAnimator.cancel()
    }
}
