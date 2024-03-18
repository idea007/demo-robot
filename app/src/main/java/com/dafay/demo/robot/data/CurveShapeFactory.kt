package com.dafay.demo.robot.data

/**
 *
 * @ClassName:      CurveShapeFactory
 * @Author:         idea
 * @CreateDate:     2019-08-09$ 19:35$
 * @Des: 用来生成 CurveShape
 */
object CurveShapeFactory {


    /*********************** 形状 ***********************/

    // 支持 Paint.Style.FILL
    val 形状_圆形 = "形状_圆形"

    val 形状_上半圆_1 = "形状_上半圆_1"

    // 下半圆
    val 形状_下半圆_1 = "形状_下半圆_1"
    val 形状_下半圆_2 = "形状_下半圆_2"
    val 形状_下半圆_3 = "形状_下半圆_3"
    val 形状_下半圆_4 = "形状_下半圆_4"
    val 形状_下半圆_5 = "形状_下半圆_5"
    val 形状_下半圆_6 = "形状_下半圆_6"
    val 形状_下半圆_7 = "形状_下半圆_7"


    val 形状_正方形 = "形状_正方形"
    val 形状_心形 = "形状_心形"
    val 形状_三角形_1 = "形状_三角形_1"


    val 形状_椭圆_窝窝头形状 = "形状_椭圆_窝窝头形状"
    val 形状_椭圆_1 = "形状_椭圆_1"


    val 线_上半圆_1 = "线_上半圆_1"

    // 下半圆曲线
    val 线_下半圆_1 = "线_下半圆_1"
    val 线_下半圆_2 = "线_下半圆_2"
    val 线_下半圆_3 = "线_下半圆_3"
    val 线_下半圆_4 = "线_下半圆_4"


    val 线_横线 = "线_横线"

    val 线_向右箭头_1 = "线_向右箭头_1"
    val 线_向左箭头_1 = "线_向左箭头_1"
    val 线_向上箭头_1 = "线_向上箭头_1"
    val 线_向下箭头_1 = "线_向下箭头_1"

    val 线_叉号_1 = "线_叉号_1"
    val 线_人字形_1 = "线_人字形_1"




    fun getCurveGroupByType(
        animType: String,
        isLink: Boolean,
        radiusRatio: Float,
        mCenterX: Float,
        centerXRatio: Float,
        mCenterY: Float,
        centerYRatio: Float
    ): CurveShape {

        when (animType) {

            线_下半圆_4 -> {
                return BezierDataHelper
                    .getCurveHalfCircleFour(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            线_下半圆_3 -> {
                return BezierDataHelper
                    .getCurveHalfCircleThree(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            线_下半圆_2 -> {
                return BezierDataHelper
                    .getCurveHalfCircleTwo(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }


            线_下半圆_1 -> {
                return BezierDataHelper
                    .getCurveHalfCircleOne(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }


            形状_下半圆_6 -> {
                return BezierDataHelper
                    .getShapeHalfCircleSix(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }


            形状_下半圆_5 -> {
                return BezierDataHelper
                    .getShapeHalfCircleFive(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_下半圆_4 -> {
                return BezierDataHelper
                    .getShapeHalfCircleFour(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )

            }

            形状_下半圆_3 -> {
                return BezierDataHelper
                    .getShapeHalfCircleThree(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_下半圆_2 -> {
                return BezierDataHelper
                    .getShapeHalfCircleTwo(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }


            形状_下半圆_1 -> {
                return BezierDataHelper
                    .getShapeHalfCircleOne(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_圆形 -> {
                return BezierDataHelper.getShapeCircle(
                    mCenterX * centerXRatio,
                    mCenterY * centerYRatio,
                    mCenterX * radiusRatio,
                    isLink
                )
            }


            形状_正方形 -> {
                return BezierDataHelper.getSquare(
                    mCenterX * centerXRatio,
                    mCenterY * centerYRatio,
                    mCenterX * radiusRatio, isLink
                )
            }


            线_横线 -> {
                return BezierDataHelper
                    .getCloseEye(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)
            }
            形状_心形 -> {
                return BezierDataHelper
                    .getHeart(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)
            }
            形状_三角形_1 -> {
                return BezierDataHelper
                    .getEquilateralTriangle(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )

            }
            线_向右箭头_1 -> {
                return BezierDataHelper
                    .getGreaterSymble(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)

            }
            线_向左箭头_1 -> {
                return BezierDataHelper
                    .getLessSymble(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)
            }


            线_叉号_1 -> {
                return BezierDataHelper
                    .getFourLineXSymble(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_下半圆_7 -> {
                return BezierDataHelper
                    .getLaugh(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)
            }

            形状_上半圆_1 -> {
                return BezierDataHelper
                    .getSad(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)
            }


            线_人字形_1 -> {

                return BezierDataHelper
                    .getHerringboneCurve(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_椭圆_窝窝头形状 -> {
                return BezierDataHelper
                    .getWoWoTouShape(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)

            }

            形状_椭圆_1 -> {
                return BezierDataHelper
                    .getBlushShapeTwo(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)

            }

            线_上半圆_1 -> {
                return BezierDataHelper
                    .getUpHalfCircleCurve(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )

            }

            线_向上箭头_1 -> {
                return BezierDataHelper
                    .getUpwordArrow(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)

            }


            线_向下箭头_1 -> {
                return BezierDataHelper
                    .getDownwordArrow(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)

            }

            else -> {
                return BezierDataHelper
                    .getShapeCircle(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)
            }
        }

    }


}