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
public class CubicBezierView @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val C = 0.551915024494f // 常量，绘制圆形贝塞尔曲线控制点的位置，拟合圆的最佳系数


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
        paint.setStrokeWidth(8f)
        paint.setStyle(Paint.Style.STROKE)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewWidth = w.toFloat()
        viewHeight = h.toFloat()
        radius = w.toFloat() / 2
        computePoints()

    }

    /**
     * 计算锚点和控制点位置
     */
    private fun computePoints() {
        anchorPoint1.apply {
            x = radius
            y = 0f
        }

        anchorPoint2.apply {
            x = viewWidth
            y = radius
        }

        contPoint1.apply {
            x = radius + radius * C
            y = 0f
        }

        contPoint2.apply {
            x = viewWidth
            y = radius - radius * C
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val path = Path().apply {
            moveTo(anchorPoint1.x, anchorPoint1.y)
            cubicTo(contPoint1.x, contPoint1.y, contPoint2.x, contPoint2.y, anchorPoint2.x, anchorPoint2.y)
        }
        canvas.drawPath(path, paint)

        drawAuxiliary(canvas)
    }
    /**
     * 画参考
     * @param canvas
     */
    private fun drawAuxiliary(canvas: Canvas) {
        paint.color = Color.GRAY

        paint.setStrokeWidth(16f)
        // 圆心点
        canvas.drawPoint(radius, radius, paint)
        canvas.drawPoint(anchorPoint1.x, anchorPoint1.y, paint)
        canvas.drawPoint(anchorPoint2.x, anchorPoint2.y, paint)
        canvas.drawPoint(contPoint1.x, contPoint1.y, paint)
        canvas.drawPoint(contPoint2.x, contPoint2.y, paint)
        // 绘制辅助线
        paint.setStrokeWidth(12f)
        canvas.drawLine(anchorPoint1.x, anchorPoint1.y, contPoint1.x, contPoint1.y, paint)
        canvas.drawLine(anchorPoint2.x, anchorPoint2.y, contPoint2.x, contPoint2.y, paint)
    }
}
