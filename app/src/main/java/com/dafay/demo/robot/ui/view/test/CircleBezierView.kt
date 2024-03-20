package com.dafay.demo.robot.ui.view.test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * @Des
 * @Author lipengfei
 * @Date 2024/3/20
 */

class CircleBezierView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null) : View(context, attrs) {
    private val C = 0.551915024494f

    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var centerX = 0
    private var centerY = 0
    private val radius = 200f // 圆的半径
    private val fittingValue = radius * C // 控制点距离锚点的距离

    private val anchors = FloatArray(8) // 顺时针记录绘制圆形的四个数据点
    private val conts = FloatArray(16) // 顺时针记录绘制圆形的八个控制点


    // 模拟从圆形变成心形
    private var isAnimActivate = false
    private val duration = 1000f // 变化总时长
    private var current = 0f // 当前已进行时长
    private val count = 100f // 将时长总共划分多少份
    private val piece = duration / count // 每一份的时长

    init {
        paint.color = Color.BLACK
        paint.strokeWidth = 8f
        paint.style = Paint.Style.STROKE
        paint.textSize = 60f


        // 初始化数据点
        anchors[0] = 0f
        anchors[1] = radius
        anchors[2] = radius
        anchors[3] = 0f
        anchors[4] = 0f
        anchors[5] = -radius
        anchors[6] = -radius
        anchors[7] = 0f

        // 初始化控制点
        conts[0] = anchors[0] + fittingValue
        conts[1] = anchors[1]
        conts[2] = anchors[2]
        conts[3] = anchors[3] + fittingValue
        conts[4] = anchors[2]
        conts[5] = anchors[3] - fittingValue
        conts[6] = anchors[4] + fittingValue
        conts[7] = anchors[5]
        conts[8] = anchors[4] - fittingValue
        conts[9] = anchors[5]
        conts[10] = anchors[6]
        conts[11] = anchors[7] - fittingValue
        conts[12] = anchors[6]
        conts[13] = anchors[7] + fittingValue
        conts[14] = anchors[0] - fittingValue
        conts[15] = anchors[1]
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2
        centerY = h / 2
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCoordinateSystem(canvas) // 绘制坐标系
        canvas.translate(centerX.toFloat(), centerY.toFloat()) // 将坐标系移动到画布中央
        canvas.scale(1f, -1f) // 翻转Y轴
        drawAuxiliaryLine(canvas)

        // 绘制贝塞尔曲线
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 8f
        val path = Path().apply {
            moveTo(anchors[0], anchors[1])
            cubicTo(conts[0], conts[1], conts[2], conts[3], anchors[2], anchors[3])
            cubicTo(conts[4], conts[5], conts[6], conts[7], anchors[4], anchors[5])
            cubicTo(conts[8], conts[9], conts[10], conts[11], anchors[6], anchors[7])
            cubicTo(conts[12], conts[13], conts[14], conts[15], anchors[0], anchors[1])
        }
        canvas.drawPath(path, paint)
        toHeartAnim()
    }

    fun startToHeartAnim() {
        isAnimActivate = true
        postInvalidate()
    }

    private fun toHeartAnim() {
        if (!isAnimActivate) {
            return
        }
        current += piece
        if (current < duration) {
            anchors[1] -= 120 / count
            conts[7] += 80 / count
            conts[9] += 80 / count
            conts[4] -= 20 / count
            conts[10] += 20 / count
            postInvalidateDelayed(piece.toLong())
        }
    }

    // 绘制辅助线
    private fun drawAuxiliaryLine(canvas: Canvas) {
        // 绘制数据点和控制点
        paint.color = Color.GRAY
        paint.strokeWidth = 20f
        run {
            var i = 0
            while (i < 8) {
                canvas.drawPoint(anchors[i], anchors[i + 1], paint)
                i += 2
            }
        }
        run {
            var i = 0
            while (i < 16) {
                canvas.drawPoint(conts[i], conts[i + 1], paint)
                i += 2
            }
        }

        // 绘制辅助线
        paint.strokeWidth = 4f
        var i = 2
        var j = 2
        while (i < 8) {
            canvas.drawLine(anchors[i], anchors[i + 1], conts[j], conts[j + 1], paint)
            canvas.drawLine(anchors[i], anchors[i + 1], conts[j + 2], conts[j + 3], paint)
            i += 2
            j += 4
        }
        canvas.drawLine(anchors[0], anchors[1], conts[0], conts[1], paint)
        canvas.drawLine(anchors[0], anchors[1], conts[14], conts[15], paint)
    }

    // 绘制坐标系(x,y轴)
    private fun drawCoordinateSystem(canvas: Canvas) {
        canvas.save() // 绘制做坐标系
        canvas.translate(centerX.toFloat(), centerY.toFloat()) // 将坐标系移动到画布中央
        canvas.scale(1f, -1f) // 翻转Y轴
        val tempPaint = Paint()
        tempPaint.color = Color.RED
        tempPaint.strokeWidth = 5f
        tempPaint.style = Paint.Style.STROKE
        canvas.drawLine(0f, -2000f, 0f, 2000f, tempPaint)
        canvas.drawLine(-2000f, 0f, 2000f, 0f, tempPaint)
        canvas.restore()
    }
}

