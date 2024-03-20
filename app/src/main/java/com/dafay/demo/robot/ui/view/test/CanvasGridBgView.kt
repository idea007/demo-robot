package com.dafay.demo.robot.ui.view.test

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.dafay.demo.lib.base.utils.dp2px

/**
 * @Des
 * @Author lipengfei
 * @Date 2024/3/20
 */

class CanvasGridBgView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    View(context, attrs, defStyleAttr) {
    // 画笔
    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    // View 宽高
    private var viewWidth = 0
    private var viewHeight = 0
    private var centerX = 0
    private var centerY = 0
    var redColor = Color.parseColor("#ff2d55")

    init {
        paint.style = Paint.Style.FILL
        paint.color = redColor
        paint.isAntiAlias = true
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewWidth = w
        viewHeight = h
        centerX = viewWidth / 2
        centerY = viewHeight / 2
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCoordinateSystem(canvas) // 绘制坐标系
        drawCenterPoint(canvas) //绘制中心点
    }

    private fun drawCenterPoint(canvas: Canvas) {
        canvas.drawCircle(centerX.toFloat(), centerY.toFloat(), 3f, paint)
        val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.color = Color.parseColor("#50ff2d55")
        textPaint.textSize = 30f
        textPaint.textAlign = Paint.Align.CENTER
        val text = String.format("(%d,%d)", centerX, centerY)
        canvas.drawText(text, (centerX + 70).toFloat(), (centerY + 20).toFloat(), textPaint)
    }

    // 绘制坐标系
    private fun drawCoordinateSystem(canvas: Canvas) {
        val redColor = Color.parseColor("#ff2d55")
        val lightRedColor = Color.parseColor("#50ff2d55")
        val fuzhuPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        fuzhuPaint.color = redColor
        fuzhuPaint.strokeWidth = 6f
        fuzhuPaint.style = Paint.Style.STROKE
        canvas.drawLine(0f, 0f, viewWidth.toFloat(), 0f, fuzhuPaint)
        canvas.drawLine(0f, 0f, 0f, viewHeight.toFloat(), fuzhuPaint)
        fuzhuPaint.color = lightRedColor
        fuzhuPaint.strokeWidth = 1f
        val unit = 10.dp2px
        var i = unit
        while (i < viewWidth) {
            canvas.drawLine(i.toFloat(), 0f, i.toFloat(), viewHeight.toFloat(), fuzhuPaint)
            i += unit
        }
        var j = unit
        while (j < viewHeight) {
            canvas.drawLine(0f, j.toFloat(), viewWidth.toFloat(), j.toFloat(), fuzhuPaint)
            j += unit
        }
        val radius = 30f
        var angle = 150.0
        val pointF10 = PointF(viewWidth.toFloat(), 0f)
        val pointF11 = PointF()
        pointF11.x = (pointF10.x + Math.cos(Math.toRadians(angle)) * radius).toFloat()
        pointF11.y = (pointF10.y + Math.sin(Math.toRadians(angle)) * radius).toFloat()
        fuzhuPaint.strokeWidth = 3f
        fuzhuPaint.color = redColor
        canvas.drawLine(pointF10.x, pointF10.y, pointF11.x, pointF11.y, fuzhuPaint)
        val pointF20 = PointF(0f, viewHeight.toFloat())
        angle = 300.0
        val pointF21 = PointF()
        pointF21.x = (pointF20.x + Math.cos(Math.toRadians(angle)) * radius).toFloat()
        pointF21.y = (pointF20.y + Math.sin(Math.toRadians(angle)) * radius).toFloat()
        fuzhuPaint.strokeWidth = 3f
        fuzhuPaint.color = redColor
        canvas.drawLine(pointF20.x, pointF20.y, pointF21.x, pointF21.y, fuzhuPaint)
        val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.color = redColor
        textPaint.textSize = 40f
        textPaint.textAlign = Paint.Align.CENTER
        canvas.drawText("x", pointF11.x, pointF11.y + 30, textPaint)
        canvas.drawText("y", pointF21.x + 30, pointF21.y, textPaint)
    }
}

