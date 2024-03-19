package com.dafay.demo.robot.data

import com.dafay.demo.robot.data.Constants.C


/**
 * 针对机器人--眼睛 数据的帮助类 ，只处理 四段 三阶的贝塞尔曲线
 */
object BezierDataRepository {

    /*************************** shape style **************************/

    /**
     * 获取一个圆形
     */
    fun getShapeCircle(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {
        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink
        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 270f,
                1f, 0f,
                C, 0f,
                C, 270f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                1f, 90f,
                C, 90f,
                C, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 90f,
                1f, 180f,
                C, 180f,
                C, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                1f, 270f,
                C, 270f,
                C, 180f
            )
        )
        return curveGroup
    }


    /**
     * 获取下半圆形状 1
     */
    fun getShapeHalfCircleOne(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0f, 0f,
                1f, 0f,
                C, 0f,
                C, 180f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                1f, 90f,
                C, 90f,
                C, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 90f,
                1f, 180f,
                C, 180f,
                C, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                0f, 0f,
                C, 0f,
                C, 180f
            )
        )

        return curveGroup

    }

    /**
     * 获取下半圆形状 2
     */
    fun getShapeHalfCircleTwo(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.66f, 90f,
                1f, 0f,
                0.5f, 0f,
                0.5f, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                1f, 90f,
                C, 90f,
                C, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 90f,
                1f, 180f,
                C, 180f,
                C, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                0.66f, 90f,
                0.5f, 90f,
                0.5f, 180f
            )
        )

        return curveGroup
    }

    /**
     * 获取下半圆形状 3
     */
    fun getShapeHalfCircleThree(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.33f, 90f,
                1f, 0f,
                0.5f, 0f,
                0.2f, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                1f, 90f,
                C, 90f,
                C, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 90f,
                1f, 180f,
                C, 180f,
                C, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                0.33f, 90f,
                0.2f, 90f,
                0.5f, 180f
            )
        )

        return curveGroup
    }

    /**
     * 获取下半圆形状 4
     */
    fun getShapeHalfCircleFour(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.33f, 90f,
                1f, 0f,
                0.5f, 0f,
                0.2f, 90f
            )
        )
        curveGroup.curveList.add(

            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                0.66f, 90f,
                0.5f, 90f,
                0.5f, 0f

            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.66f, 90f,
                1f, 180f,
                0.5f, 180f,
                0.5f, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                0.33f, 90f,
                0.2f, 90f,
                0.5f, 180f
            )
        )

        return curveGroup
    }

    /**
     * 获取下半圆形状 5
     */
    fun getShapeHalfCircleFive(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0f, 0f,
                1f, 0f,
                C, 0f,
                C, 180f
            )
        )

        curveGroup.curveList.add(

            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                0.66f, 90f,
                0.5f, 90f,
                0.5f, 0f

            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.66f, 90f,
                1f, 180f,
                0.5f, 180f,
                0.5f, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                0f, 0f,
                C, 0f,
                C, 180f
            )
        )

        return curveGroup
    }

    /**
     * 获取下半圆形状 6
     */
    fun getShapeHalfCircleSix(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {
        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.05f, 270f,
                0.8f, 340f,

                0.2f, 0f,
                0.2f, 120f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.8f, 340f,
                0.2f, 90f,
                0.4f, 115f,
                0.2f, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.2f, 90f,
                0.8f, 200f,
                0.2f, 180f,
                0.4f, 65f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.8f, 200f,
                0.05f, 270f,
                0.2f, 60f,
                0.2f, 180f
            )
        )

        return curveGroup

    }

    /**
     * 下半圆曲线 1
     */
    fun getCurveHalfCircleOne(centerX: Float, centerY: Float, radius: Float, isLink: Boolean): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 90f,
                1f, 0f,
                C, 0f,
                C, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                1f, 90f,
                C, 90f,
                C, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 90f,
                1f, 180f,
                C, 180f,
                C, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                1f, 90f,
                C, 90f,
                C, 180f
            )
        )

        return curveGroup
    }

    /**
     * 下半圆曲线 2
     */
    fun getCurveHalfCircleTwo(centerX: Float, centerY: Float, radius: Float, isLink: Boolean): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1.2f, 90f,
                1f, 0f,
                C, 0f,
                C, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                1.2f, 90f,
                C, 90f,
                C, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1.2f, 90f,
                1f, 180f,
                C, 180f,
                C, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                1.2f, 90f,
                C, 90f,
                C, 180f
            )
        )

        return curveGroup
    }

    /**
     * 下半圆曲线 3
     */
    fun getCurveHalfCircleThree(centerX: Float, centerY: Float, radius: Float, isLink: Boolean): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.05f, 270f,
                0.8f, 340f,

                0.2f, 0f,
                0.2f, 120f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.8f, 340f,
                0.05f, 270f,
                0.2f, 120f,
                0.2f, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.05f, 270f,
                0.8f, 200f,
                0.2f, 180f,
                0.2f, 60f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.8f, 200f,
                0.05f, 270f,
                0.2f, 60f,
                0.2f, 180f
            )
        )

        return curveGroup
    }

    /**
     * 获取下半圆形状 6
     */
    fun getCurveHalfCircleFour(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {
        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.05f, 270f,
                0.8f, 340f,

                0.2f, 0f,
                0.2f, 120f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.8f, 340f,
                0.2f, 90f,
                0.4f, 115f,
                0.2f, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.2f, 90f,
                0.8f, 200f,
                0.2f, 180f,
                0.4f, 65f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.8f, 200f,
                0.05f, 270f,
                0.2f, 60f,
                0.2f, 180f
            )
        )

        return curveGroup

    }

    /**
     * 获取一个正方形
     */
    fun getSquare(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 315f,
                1f, 45f,
                0.5f, 90f,
                0.5f, 270f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 45f,
                1f, 135f,
                0.5f, 180f,
                0.5f, 0f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 135f,
                1f, 225f,
                0.5f, 270f,
                0.5f, 90f
            )
        )
        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 225f,
                1f, 315f,
                0.5f, 0f,
                0.5f, 180f
            )
        )

        return curveGroup

    }

    /**
     * 获取上半圆曲线
     */
    fun getUpHalfCircleCurve(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 270f,
                1f, 0f,
                C, 0f,
                C, 270f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                1f, 270f,
                C, 270f,
                C, 0f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 270f,
                1f, 180f,
                C, 180f,
                C, 270f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                1f, 270f,
                C, 270f,
                C, 180f
            )
        )


        return curveGroup

    }

    /**
     * 获取一个X号
     */
    fun getFourLineXSymble(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 315f,
                0f, 315f,
                0.5f, 135f,
                0.5f, 315f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 45f,
                0f, 45f,

                0.5f, 225f,
                0.5f, 45f
            )
        )



        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 135f,
                0f, 135f,
                0.5f, 314f,
                0.5f, 135f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 225f,
                0f, 225f,
                0.5f, 45f,
                0.5f, 225f

            )
        )


//        curveGroup.curveList.add(getCurve(centerPoint, radius,
//                1f, 225f,
//                0f, 0f,
//                0.5f, 45f,
//                0.5f, 225f
//                ))


        return curveGroup


    }

    /**
     * 获取一个X号
     */
    fun getXSymble(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 315f,
                1f, 135f,
                0.5f, 135f,
                0.5f, 315f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 135f,
                0f, 0f,

                0.5f, 315f,
                0.5f, 135f
            )
        )



        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0f, 0f,
                1f, 45f,
                0.5f, 45f,
                0.5f, 225f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 225f,
                1f, 45f,
                0.5f, 45f,
                0.5f, 225f

            )
        )


//        curveGroup.curveList.add(getCurve(centerPoint, radius,
//                1f, 225f,
//                0f, 0f,
//                0.5f, 45f,
//                0.5f, 225f
//                ))


        return curveGroup


    }

    /**
     * 获取一个小于号
     */
    fun getLessSymble(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {


        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink
        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 300f,
                1f, 180f,
                0.5f, 150f,
                0.5f, 330f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                1f, 60f,
                0.5f, 30f,
                0.5f, 210f

            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 60f,
                1f, 180f,
                0.5f, 210f,
                0.5f, 30f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                1f, 300f,
                0.5f, 330f,
                0.5f, 150f

            )
        )

        return curveGroup


    }

    /**
     * 获取一个大于号
     */
    fun getGreaterSymble(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink
        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 240f,
                1f, 0f,
                0.5f, 30f,
                0.5f, 210f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                1f, 120f,
                0.5f, 150f,
                0.5f, 330f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 120f,
                1f, 0f,
                0.25f, 330f,
                0.25f, 150f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 240f,
                1f, 0f,
                0.5f, 30f,
                0.5f, 210f
            )
        )

        return curveGroup


    }

    /**
     * 获取一个等边三角形
     */
    fun getEquilateralTriangle(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink
        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 270f,
                1f, 30f,
                0.5f, 60f,
                0.5f, 240f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 30f,
                0.5f, 90f,
                0.25f, 180f,
                0.25f, 0f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.5f, 90f,
                1f, 150f,
                0.25f, 180f,
                0.25f, 0f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 150f,
                1f, 270f,
                0.5f, 300f,
                0.5f, 120f
            )
        )

        return curveGroup

    }

    /**
     * 获取一个向上箭头 不带中间的一横
     */
    fun getUpwordArrow(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink
        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 270f,
                1f, 30f,
                0.5f, 60f,
                0.5f, 240f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 30f,
                1f, 270f,
                0.5f, 240f,
                0.5f, 60f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 270f,
                1f, 150f,
                0.5f, 120f,
                0.5f, 300f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 150f,
                1f, 270f,
                0.5f, 300f,
                0.5f, 120f
            )
        )

        return curveGroup

    }

    fun getLineUpwordArrow(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 270f,
                1f, 30f,
                0.5f, 60f,
                0.5f, 240f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 30f,
                1f, 270f,
                0.5f, 240f,
                0.5f, 60f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 270f,
                1f, 150f,
                0.5f, 120f,
                0.5f, 300f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 150f,
                1f, 270f,
                0.5f, 300f,
                0.5f, 120f
            )
        )

        return curveGroup

    }

    /**
     * 获取一个向下箭头 不带中间的一横
     */
    fun getDownwordArrow(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink
        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 90f,
                1f, 330f,
                0.5f, 300f,
                0.5f, 120f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 330f,
                1f, 90f,
                0.5f, 120f,
                0.5f, 300f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 90f,
                1f, 210f,
                0.5f, 240f,
                0.5f, 60f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 210f,
                1f, 90f,
                0.5f, 60f,
                0.5f, 240f
            )
        )

        return curveGroup

    }

    /**
     * 获取一个心形
     */
    fun getHeart(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.5f, 270f,
                1f, 0f,
                C, 315f,
                C, 270f
            )
        )



        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                1f, 90f,
                C, 95f,
                C, 315f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 90f,
                1f, 180f,
                C, 225f,
                C, 85f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                0.5f, 270f,
                C, 270f,
                C, 225f
            )
        )

        return curveGroup
    }

    /**
     * 获取一条线 闭眼的样式
     */
    fun getCloseEye(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0f, 0f,
                1f, 0f,
                0.5f, 0f,
                0.5f, 180f
            )
        )



        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                0f, 0f,
                0.5f, 180f,
                0.5f, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0f, 0f,
                1f, 180f,
                0.5f, 180f,
                0.5f, 0f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                0f, 0f,
                0.5f, 0f,
                0.5f, 180f
            )
        )

        return curveGroup
    }


    /*************************** mouse style **************************/
    /**
     * 获取大笑的样式
     */
    fun getLaugh(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {
        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.2f, 270f,
                1f, 0f,

                0.2f, 0f,
                0.2f, 225f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                0.8f, 90f,
                0.5f, 90f,
                0.5f, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.8f, 90f,
                1f, 180f,
                0.5f, 180f,
                0.5f, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                0.2f, 270f,
                0.2f, 315f,
                0.2f, 180f
            )
        )

        return curveGroup

    }


    /**
     * 获取一个 伤心形状 缺口向下的月牙
     */
    fun getSad(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {
        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.2f, 270f,
                0.8f, 20f,

                0.2f, 0f,
                0.4f, 245f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.8f, 20f,
                0.05f, 90f,
                0.2f, 240f,
                0.2f, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.05f, 90f,
                0.8f, 160f,
                0.2f, 180f,
                0.2f, 300f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.8f, 160f,
                0.2f, 270f,
                0.4f, 300f,
                0.2f, 180f
            )
        )

        return curveGroup

    }


    /**
     * 获取一个 人字形曲线 用于海豹 的嘴形
     */
    fun getHerringboneCurve(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {
        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.0f, 0f,
                0.5f, 45f,

                0.2f, 90f,
                0.2f, 180f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.5f, 45f,
                0f, 0f,
                0.2f, 180f,
                0.2f, 90f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.0f, 0f,
                0.5f, 135f,
                0.2f, 90f,
                0.2f, 0f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.5f, 135f,
                0.0f, 0f,
                0.2f, 0f,
                0.2f, 90f
            )
        )

        return curveGroup

    }


    /**
     * 获取一个 窝窝头 形状
     */
    fun getWoWoTouShape(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {
        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 270f,
                1f, 0f,

                0.4f, 0f,
                0.5f, 270f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                0.5f, 90f,
                0.4f, 90f,
                0.5f, 0f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.5f, 90f,
                1f, 180f,
                0.5f, 180f,
                0.4f, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                1f, 270f,
                0.5f, 270f,
                0.4f, 180f
            )
        )

        return curveGroup

    }

    /**
     * 获取一个 红晕 形状 横向的椭圆
     */
    fun getBlushShape(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {
        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.5f, 270f,
                1f, 0f,
                C, 0f,
                C, 270f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                0.5f, 90f,
                C, 90f,
                C, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.5f, 90f,
                1f, 180f,
                C, 180f,
                C, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                0.5f, 270f,
                C, 270f,
                C, 180f
            )
        )

        return curveGroup

    }


    /**
     * 获取一个 红晕 形状 横向的椭圆
     */
    fun getBlushShapeTwo(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {
        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.7f, 270f,
                1f, 0f,
                0.6f, 0f,
                C, 270f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 0f,
                0.7f, 90f,
                C, 90f,
                0.6f, 0f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.7f, 90f,
                1f, 180f,
                0.6f, 180f,
                C, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 180f,
                0.7f, 270f,
                C, 270f,
                0.6f, 180f
            )
        )

        return curveGroup

    }


    /**
     * 获取数字 0
     */
    fun getCurveNumber0(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.5f, 180f,
                0.867f, 270f,
                0.25f, 300f,
                0.25f, 120f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.867f, 270f,
                0f, 0f,
                0.25f, 90f,
                0.25f, 270f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0f, 0f,
                0.289f, 90f,
                0.1f, 90f,
                0.1f, 270f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0.289f, 90f,
                0.5f, 180f,
                0.2f, 210f,
                0.2f, 30f
            )
        )

        return curveGroup
    }


    /**
     * 获取数字 1
     */
    fun getCurveNumber1(centerX: Float, centerY: Float, radius: Float, isLink: Boolean = true): CurveShape {

        var curveGroup = CurveShape()
        curveGroup.centerX = centerX
        curveGroup.centerY = centerY
        curveGroup.radius = radius
        curveGroup.isLink = isLink

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 270f,
                0f, 0f,
                0.5f, 90f,
                0.5f, 270f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0f, 0f,
                1f, 90f,
                0.5f, 90f,
                0.5f, 270f
            )
        )


        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                1f, 90f,
                0f, 180f,
                0.5f, 270f,
                0.5f, 90f
            )
        )

        curveGroup.curveList.add(
            getCurve(
                centerX, centerY, radius,
                0f, 180f,
                1f, 270f,
                0.5f, 270f,
                0.5f, 90f
            )
        )

        return curveGroup
    }


    /**
     * 获取一段三阶贝塞尔曲线
     */
    fun getCurve(
        centerX: Float, centerY: Float, radius: Float,
        anchorRatioTR1: Float, anchorAngle1: Float,
        anchorRatioTR2: Float, anchorAngle2: Float,
        contRatioTR1: Float, contAngle1: Float,
        contRatioTR2: Float, contAngle2: Float
    ): Curve {
        val curve = Curve()
        curve.anchorPoint1.x = centerX + Math.cos(Math.toRadians(anchorAngle1.toDouble())).toFloat() * radius * anchorRatioTR1
        curve.anchorPoint1.y = centerY + Math.sin(Math.toRadians(anchorAngle1.toDouble())).toFloat() * radius * anchorRatioTR1
        curve.contPoint1.x = curve.anchorPoint1.x + Math.cos(Math.toRadians(contAngle1.toDouble())).toFloat() * radius * contRatioTR1
        curve.contPoint1.y = curve.anchorPoint1.y + Math.sin(Math.toRadians(contAngle1.toDouble())).toFloat() * radius * contRatioTR1
        curve.anchorPoint2.x = centerX + Math.cos(Math.toRadians(anchorAngle2.toDouble())).toFloat() * radius * anchorRatioTR2
        curve.anchorPoint2.y = centerY + Math.sin(Math.toRadians(anchorAngle2.toDouble())).toFloat() * radius * anchorRatioTR2
        curve.contPoint2.x = curve.anchorPoint2.x + Math.cos(Math.toRadians(contAngle2.toDouble())).toFloat() * radius * contRatioTR2
        curve.contPoint2.y = curve.anchorPoint2.y + Math.sin(Math.toRadians(contAngle2.toDouble())).toFloat() * radius * contRatioTR2
        return curve
    }

}