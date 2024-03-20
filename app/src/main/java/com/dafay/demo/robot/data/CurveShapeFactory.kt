package com.dafay.demo.robot.data

/**
 *
 * @ClassName:      CurveShapeFactory
 * @Des: 用来生成 CurveShape
 */
object CurveShapeFactory {
    /*********************** 形状 ***********************/
    // 支持 Paint.Style.FILL
    val 形状_圆形 = "形状_圆形"
    val 形状_上半圆_1 = "形状_上半圆_1"
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
                return BezierDataRepository
                    .getCurveHalfCircleFour(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            线_下半圆_3 -> {
                return BezierDataRepository
                    .getCurveHalfCircleThree(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            线_下半圆_2 -> {
                return BezierDataRepository
                    .getCurveHalfCircleTwo(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            线_下半圆_1 -> {
                return BezierDataRepository
                    .getCurveHalfCircleOne(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_下半圆_6 -> {
                return BezierDataRepository
                    .getShapeHalfCircleSix(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_下半圆_5 -> {
                return BezierDataRepository
                    .getShapeHalfCircleFive(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_下半圆_4 -> {
                return BezierDataRepository
                    .getShapeHalfCircleFour(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )

            }

            形状_下半圆_3 -> {
                return BezierDataRepository
                    .getShapeHalfCircleThree(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_下半圆_2 -> {
                return BezierDataRepository
                    .getShapeHalfCircleTwo(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_下半圆_1 -> {
                return BezierDataRepository
                    .getShapeHalfCircleOne(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_圆形 -> {
                return BezierDataRepository.getShapeCircle(
                    mCenterX * centerXRatio,
                    mCenterY * centerYRatio,
                    mCenterX * radiusRatio,
                    isLink
                )
            }

            形状_正方形 -> {
                return BezierDataRepository.getSquare(
                    mCenterX * centerXRatio,
                    mCenterY * centerYRatio,
                    mCenterX * radiusRatio, isLink
                )
            }

            线_横线 -> {
                return BezierDataRepository
                    .getCloseEye(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)
            }

            形状_心形 -> {
                return BezierDataRepository
                    .getHeart(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)
            }

            形状_三角形_1 -> {
                return BezierDataRepository
                    .getEquilateralTriangle(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )

            }

            线_向右箭头_1 -> {
                return BezierDataRepository
                    .getGreaterSymble(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)

            }

            线_向左箭头_1 -> {
                return BezierDataRepository
                    .getLessSymble(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)
            }

            线_叉号_1 -> {
                return BezierDataRepository
                    .getFourLineXSymble(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_下半圆_7 -> {
                return BezierDataRepository
                    .getLaugh(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)
            }

            形状_上半圆_1 -> {
                return BezierDataRepository
                    .getSad(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)
            }

            线_人字形_1 -> {

                return BezierDataRepository
                    .getHerringboneCurve(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )
            }

            形状_椭圆_窝窝头形状 -> {
                return BezierDataRepository
                    .getWoWoTouShape(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)

            }

            形状_椭圆_1 -> {
                return BezierDataRepository
                    .getBlushShapeTwo(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)

            }

            线_上半圆_1 -> {
                return BezierDataRepository
                    .getUpHalfCircleCurve(
                        mCenterX * centerXRatio,
                        mCenterY * centerYRatio,
                        mCenterX * radiusRatio,
                        isLink
                    )

            }

            线_向上箭头_1 -> {
                return BezierDataRepository
                    .getUpwordArrow(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)

            }

            线_向下箭头_1 -> {
                return BezierDataRepository
                    .getDownwordArrow(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)

            }

            else -> {
                return BezierDataRepository
                    .getShapeCircle(mCenterX * centerXRatio, mCenterY * centerYRatio, mCenterX * radiusRatio, isLink)
            }
        }
    }
}