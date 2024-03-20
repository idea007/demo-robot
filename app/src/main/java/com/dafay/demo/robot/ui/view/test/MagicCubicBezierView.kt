package com.dafay.demo.robot.ui.view.test

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

/**
 * 三次 bezier 拟合 1/4 圆弧
 * @param context
 * @param attrs
 * @param defStyleAttr
 */
public class MagicCubicBezierView @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var progress = 0.551915024494f


    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    // 拟合圆的半径
    private var radius = 0f
    private var viewWidth = 0f
    private var viewHeight = 0f

    /**
     * 这里模拟 ps 中锚点概念，路径上的点是锚点，锚点两边用了调整曲线的点为控制点
     */
    // 锚点一
    private var anchorPoint1 = PointF(0f, 0f)

    // 控制点一
    private var contPoint1 = PointF(0f, 0f)

    // 锚点二
    private var anchorPoint2 = PointF(0f, 0f)

    // 控制点二
    private var contPoint2 = PointF(0f, 0f)

    init {
        paint.setColor(Color.BLACK)
        paint.setStyle(Paint.Style.STROKE)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewWidth = w.toFloat()
        viewHeight = h.toFloat()
        radius = w.toFloat() / 2 - 16
    }

    /**
     * 计算锚点和控制点位置
     * 以 centerX,centerY 作为中心点
     */
    private fun computePoints() {
        anchorPoint1.apply {
            x = 0f
            y = radius
        }

        anchorPoint2.apply {
            x = radius
            y = 0f
        }

        contPoint1.apply {
            x = radius * progress
            y = radius
        }

        contPoint2.apply {
            x = radius
            y = radius * progress
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        computePoints()
        drawCurve(canvas)
        drawAuxiliary(canvas)
    }

    private fun drawCurve(canvas: Canvas) {
        canvas.save()
        canvas.translate(viewWidth / 2, viewHeight / 2) // 将坐标系移动到画布中央
        canvas.scale(1f, -1f) // 翻转Y轴
        paint.setStrokeWidth(2f)
        paint.color = Color.GRAY
        canvas.drawCircle(0f, 0f, radius, paint)
        paint.setStrokeWidth(4f)
        paint.color = Color.RED
        val path = Path().apply {
            moveTo(anchorPoint1.x, anchorPoint1.y)
            cubicTo(contPoint1.x, contPoint1.y, contPoint2.x, contPoint2.y, anchorPoint2.x, anchorPoint2.y)
        }
        canvas.drawPath(path, paint)
        canvas.restore()
    }

    fun setProgress(progress: Float) {
        this.progress = progress
        invalidate()
    }

    /**
     * 画参考
     * @param canvas
     */
    private fun drawAuxiliary(canvas: Canvas) {
        paint.color = Color.GRAY
        canvas.save()
        canvas.translate(viewWidth / 2, viewHeight / 2) // 将坐标系移动到画布中央
        canvas.scale(1f, -1f) // 翻转Y轴
        paint.setStrokeWidth(12f)
        // 圆心点
        canvas.drawPoint(0f, 0f, paint)

        canvas.drawPoint(anchorPoint1.x, anchorPoint1.y, paint)
        canvas.drawPoint(anchorPoint2.x, anchorPoint2.y, paint)
        canvas.drawPoint(contPoint1.x, contPoint1.y, paint)
        canvas.drawPoint(contPoint2.x, contPoint2.y, paint)
        // 绘制辅助线
        paint.setStrokeWidth(4f)
        canvas.drawLine(anchorPoint1.x, anchorPoint1.y, contPoint1.x, contPoint1.y, paint)
        canvas.drawLine(anchorPoint2.x, anchorPoint2.y, contPoint2.x, contPoint2.y, paint)
        canvas.restore()
        paint.setStrokeWidth(2f)
        paint.color = Color.BLUE
        // 画对角线
        canvas.drawLine(viewWidth, 0f, 0f, viewHeight, paint)
    }
}
