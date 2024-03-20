package com.dafay.demo.robot.ui.view.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View


class BezierAuxiliaryView : View {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()

    }


    // 画笔
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)        //画笔

    private var centerX: Int = 0
    private var centerY: Int = 0

    private var viewWidth = 0
    private var mViewHeight = 0

    private var start: PointF = PointF(0f, 0f)
    private var end: PointF = PointF(0f, 0f)
    private var control1: PointF = PointF(0f, 0f)
    private var control2: PointF = PointF(0f, 0f)


    private var start2: PointF = PointF(0f, 0f)
    private var end2: PointF = PointF(0f, 0f)
    private var control21: PointF = PointF(0f, 0f)
    private var control22: PointF = PointF(0f, 0f)


    private var mAllPointF = ArrayList<PointF>()

    private var EDFAULT_UNIT:Float=0f


    private fun init() {
        paint!!.style = Paint.Style.STROKE
        paint.strokeWidth = 5f
        paint!!.color = Color.WHITE
        paint!!.isAntiAlias = true

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewWidth = w
        mViewHeight = h

        centerX = w / 2
        centerY = h / 2

        EDFAULT_UNIT=w.toFloat()/100

        // 初始化数据点和控制点的位置
        start.x = centerX - 200f
        start.y = centerY.toFloat()
        end.x = centerX + 200f
        end.y = centerY.toFloat()
        control1.x = centerX.toFloat()
        control1.y = centerY - 100f
        control2.x = centerX.toFloat()
        control2.y = centerY + 100f



        start2.x = centerX - 200f
        start2.y = centerY.toFloat() / 4
        end2.x = centerX + 200f
        end2.y = centerY.toFloat() / 4
        control21.x = centerX.toFloat()
        control21.y = centerY / 4 - 50f
        control22.x = centerX.toFloat()
        control22.y = centerY / 4 + 100f


        mAllPointF.add(start)
        mAllPointF.add(end)
        mAllPointF.add(control1)
        mAllPointF.add(control2)


        mAllPointF.add(start2)
        mAllPointF.add(end2)
        mAllPointF.add(control21)
        mAllPointF.add(control22)
    }


    private var mCurPoint: PointF? = null // 当前移动的控制点
    private val REGION_WIDTH = 30  // 合法区域宽度
    override fun onTouchEvent(event: MotionEvent): Boolean {


        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }

            MotionEvent.ACTION_MOVE -> {
                var x = event.x
                var y = event.y
                if (mCurPoint == null) {
                    mCurPoint = getLegalControlPoint(x, y)
                }

                if (mCurPoint != null && isLegalTouchRegion(x, y)) {  // 判断手指移动区域是否合法
                    mCurPoint?.x = x
                    mCurPoint?.y = y
                    invalidate()
                }

            }

            MotionEvent.ACTION_UP -> {
                mCurPoint = null
            }


        }

        return true
    }

    /**
     * 获取合法控制点
     *
     * @param x
     * @param y
     * @return
     */
    private fun getLegalControlPoint(x: Float, y: Float): PointF? {
        val rectF = RectF()
        for (point in mAllPointF) {
            rectF.set(point.x - REGION_WIDTH, point.y - REGION_WIDTH, point.x + REGION_WIDTH, point.y + REGION_WIDTH)
            if (rectF.contains(x, y)) {
                return point
            }
        }
        return null
    }

    /**
     * 判断坐标是否在合法区域中
     *
     * @param x
     * @param y
     * @return
     */
    private fun isLegalTouchRegion(x: Float, y: Float): Boolean {
        if (x <= REGION_WIDTH || x >= viewWidth - REGION_WIDTH || y <= REGION_WIDTH || y >= mViewHeight - REGION_WIDTH) {
            return false
        }
        val rectF = RectF()
        for (point in mAllPointF) {
            if (mCurPoint != null && mCurPoint == point) { // 判断是否是当前控制点
                continue
            }
            rectF.set(point.x - REGION_WIDTH, point.y - REGION_WIDTH, point.x + REGION_WIDTH, point.y + REGION_WIDTH)
            if (rectF.contains(x, y)) {
                return false
            }
        }
        return true
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        drawAnchorAndContPoint(canvas)


        // 绘制辅助线
        paint.setStrokeWidth(2f)
        canvas.drawLine(start.x, start.y, control1.x, control1.y, paint)
        //canvas.drawLine(control1.x, control1.y, control2.x, control2.y, mPaint)
        canvas.drawLine(control2.x, control2.y, end.x, end.y, paint)


        canvas.drawLine(start2.x, start2.y, control21.x, control21.y, paint)
        //canvas.drawLine(control21.x, control21.y, control22.x, control22.y, mPaint)
        canvas.drawLine(control22.x, control22.y, end2.x, end2.y, paint)


        // 绘制贝塞尔曲线
        paint.setColor(Color.RED)
        paint.setStrokeWidth(4f)

        val path = Path()
        path.moveTo(start.x, start.y)
        path.cubicTo(control1.x, control1.y, control2.x, control2.y, end.x, end.y)
        canvas.drawPath(path, paint)









        val path2 = Path()
        path2.moveTo(start2.x, start2.y)
        path2.cubicTo(control21.x, control21.y, control22.x, control22.y, end2.x, end2.y)
        canvas.drawPath(path2, paint)



        paint.strokeWidth=1f
        paint.color= Color.parseColor("#330000FF")
        //绘制测算辅助线
        canvas.drawLine(start.x,start.y+100,start.x,start.y-100,paint)
        canvas.drawLine(end.x,end.y+100,end.x,end.y-100,paint)





        var startToCenterDistance=Math.sqrt((start.x-centerX)*(start.x-centerX)+(start.y-centerY)*(start.y-centerY).toDouble())*100/viewWidth
        var startToCenterAngle=getIncludedAngle(start, PointF(centerX.toFloat(),centerY.toFloat()))


        var endToCenterDistance=Math.sqrt((end.x-centerX)*(end.x-centerX)+(end.y-centerY)*(end.y-centerY).toDouble())*100/viewWidth
        var endToCenterAngle=getIncludedAngle(end, PointF(centerX.toFloat(),centerY.toFloat()))






        var cont1ToStartDistance=Math.sqrt((control1.x-start.x)*(control1.x-start.x)+(control1.y-start.y)*(control1.y-start.y).toDouble())*100/viewWidth
        var cont1ToStartAngle=getIncludedAngle(control1, start)

        var cont2ToEndDistance=Math.sqrt((control2.x-end.x)*(control2.x-end.x)+(control2.y-end.y)*(control2.y-end.y).toDouble())*100/viewWidth
        var cont2ToEndAngle=getIncludedAngle(control2, end)





        listener?.onBezierOneDataUpdate(startToCenterDistance,
                startToCenterAngle,
                endToCenterDistance,
                endToCenterAngle,
                cont1ToStartDistance,
                cont1ToStartAngle,
                cont2ToEndDistance,
                cont2ToEndAngle
        )



    }

    private fun getIncludedAngle(start: PointF, control1: PointF): Float {
        val x = start.x - control1.x
        val y = start.y - control1.y
        val z = Math.sqrt((x * x + y * y).toDouble())
        val jiaodu = Math.round((Math.asin(y / z) / Math.PI * 180).toFloat())//最终角度
        return jiaodu.toFloat()

    }


    /**
     * 绘制锚点和控制点
     */
    private fun drawAnchorAndContPoint(canvas: Canvas) {


        // 绘制数据点和控制点
        paint.setColor(Color.BLACK)
        paint.style = Paint.Style.FILL
        var radius = 5f
        canvas.drawCircle(start.x, start.y, radius, paint)
        canvas.drawCircle(end.x, end.y, radius, paint)
        canvas.drawCircle(start2.x, start2.y, radius, paint)
        canvas.drawCircle(end2.x, end2.y, radius, paint)


        paint.color = Color.GRAY
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 12f

        canvas.drawPoint(control1.x, control1.y, paint)
        canvas.drawPoint(control2.x, control2.y, paint)
        canvas.drawPoint(control21.x, control21.y, paint)
        canvas.drawPoint(control22.x, control22.y, paint)


    }



    var listener:OnMappingDataListener?=null
    interface OnMappingDataListener{

        //把宽度等分成100份，占100份的比例
        fun onBezierOneDataUpdate(startToCenterDistance: Double, startToCenterAngle: Float, endToCenterDistance: Double, endToCenterAngle: Float, cont1ToStartDistance: Double, cont1ToStartAngle: Float, cont2ToEndDistance: Double, cont2ToEndAngle: Float)

    }


}