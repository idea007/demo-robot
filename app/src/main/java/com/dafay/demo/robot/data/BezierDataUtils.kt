package com.dafay.demo.robot.data

import android.graphics.Path

/**
 *
 * @ClassName:      BezierDataUtils$
 * @Description:    java类作用描述
 * @Author:         idea
 * @CreateDate:     2019-08-11$ 12:44$
 */

object BezierDataUtils {


    fun getCurrentCurveGroup(thumCurveGroup:CurveShape, startCurveGroup: CurveShape, targetCurveGroup: CurveShape, progress: Float): CurveShape {
        if (thumCurveGroup.curveList == null || thumCurveGroup.curveList.size == 0) {
            thumCurveGroup.curveList.add(Curve())
            thumCurveGroup.curveList.add(Curve())
            thumCurveGroup.curveList.add(Curve())
            thumCurveGroup.curveList.add(Curve())
        }

        for (i in 0 until thumCurveGroup.curveList.size) {
            thumCurveGroup.curveList.get(i).anchorPoint1.x =
                startCurveGroup.curveList.get(i).anchorPoint1.x + (targetCurveGroup.curveList.get(i).anchorPoint1.x - startCurveGroup.curveList.get(
                    i
                ).anchorPoint1.x) * progress
            thumCurveGroup.curveList.get(i).anchorPoint1.y =
                startCurveGroup.curveList.get(i).anchorPoint1.y + (targetCurveGroup.curveList.get(i).anchorPoint1.y - startCurveGroup.curveList.get(
                    i
                ).anchorPoint1.y) * progress

            thumCurveGroup.curveList.get(i).anchorPoint2.x =
                startCurveGroup.curveList.get(i).anchorPoint2.x + (targetCurveGroup.curveList.get(i).anchorPoint2.x - startCurveGroup.curveList.get(
                    i
                ).anchorPoint2.x) * progress
            thumCurveGroup.curveList.get(i).anchorPoint2.y =
                startCurveGroup.curveList.get(i).anchorPoint2.y + (targetCurveGroup.curveList.get(i).anchorPoint2.y - startCurveGroup.curveList.get(
                    i
                ).anchorPoint2.y) * progress

            thumCurveGroup.curveList.get(i).contPoint1.x =
                startCurveGroup.curveList.get(i).contPoint1.x + (targetCurveGroup.curveList.get(i).contPoint1.x - startCurveGroup.curveList.get(
                    i
                ).contPoint1.x) * progress
            thumCurveGroup.curveList.get(i).contPoint1.y =
                startCurveGroup.curveList.get(i).contPoint1.y + (targetCurveGroup.curveList.get(i).contPoint1.y - startCurveGroup.curveList.get(
                    i
                ).contPoint1.y) * progress
            thumCurveGroup.curveList.get(i).contPoint2.x =
                startCurveGroup.curveList.get(i).contPoint2.x + (targetCurveGroup.curveList.get(i).contPoint2.x - startCurveGroup.curveList.get(
                    i
                ).contPoint2.x) * progress
            thumCurveGroup.curveList.get(i).contPoint2.y =
                startCurveGroup.curveList.get(i).contPoint2.y + (targetCurveGroup.curveList.get(i).contPoint2.y - startCurveGroup.curveList.get(
                    i
                ).contPoint2.y) * progress
        }

        thumCurveGroup.isLink = targetCurveGroup.isLink

        return thumCurveGroup
    }




    fun getFourParaBezierPathsWithProgress(
        paths:ArrayList<Path>,
        thumCurveGroup: CurveShape,
        startCurveGroup: CurveShape,
        targetCurveGroup: CurveShape,
        progress: Float
    ): ArrayList<Path> {
        return getCurveGroupPaths(paths,getCurrentCurveGroup(thumCurveGroup,startCurveGroup, targetCurveGroup, progress))
    }

    fun getCurveGroupPaths(paths:ArrayList<Path>, curveShape: CurveShape): ArrayList<Path> {

        paths.clear()

        if (curveShape.isLink) {

            var path = Path()

            path.moveTo(
                curveShape.curveList.get(0).anchorPoint1.x,
                curveShape.curveList.get(0).anchorPoint1.y
            )

            for (i in 0 until curveShape.curveList.size) {

                path.cubicTo(
                    curveShape.curveList.get(i).contPoint1.x,
                    curveShape.curveList.get(i).contPoint1.y,
                    curveShape.curveList.get(i).contPoint2.x,
                    curveShape.curveList.get(i).contPoint2.y,
                    curveShape.curveList.get(i).anchorPoint2.x,
                    curveShape.curveList.get(i).anchorPoint2.y
                )

            }

            paths.add(path)

        } else {

            for (i in 0 until curveShape.curveList.size) {

                var path = Path()
                path.moveTo(
                    curveShape.curveList.get(i).anchorPoint1.x,
                    curveShape.curveList.get(i).anchorPoint1.y
                )

                path.cubicTo(
                    curveShape.curveList.get(i).contPoint1.x,
                    curveShape.curveList.get(i).contPoint1.y,
                    curveShape.curveList.get(i).contPoint2.x,
                    curveShape.curveList.get(i).contPoint2.y,
                    curveShape.curveList.get(i).anchorPoint2.x,
                    curveShape.curveList.get(i).anchorPoint2.y
                )
                paths.add(path)
            }
        }
        return paths
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

        var curve = Curve()

        curve.anchorPoint1.x =
            centerX + Math.cos(Math.toRadians(anchorAngle1.toDouble())).toFloat() * radius * anchorRatioTR1
        curve.anchorPoint1.y =
            centerY + Math.sin(Math.toRadians(anchorAngle1.toDouble())).toFloat() * radius * anchorRatioTR1

        curve.contPoint1.x =
            curve.anchorPoint1.x + Math.cos(Math.toRadians(contAngle1.toDouble())).toFloat() * radius * contRatioTR1
        curve.contPoint1.y =
            curve.anchorPoint1.y + Math.sin(Math.toRadians(contAngle1.toDouble())).toFloat() * radius * contRatioTR1

        curve.anchorPoint2.x =
            centerX + Math.cos(Math.toRadians(anchorAngle2.toDouble())).toFloat() * radius * anchorRatioTR2
        curve.anchorPoint2.y =
            centerY + Math.sin(Math.toRadians(anchorAngle2.toDouble())).toFloat() * radius * anchorRatioTR2

        curve.contPoint2.x =
            curve.anchorPoint2.x + Math.cos(Math.toRadians(contAngle2.toDouble())).toFloat() * radius * contRatioTR2
        curve.contPoint2.y =
            curve.anchorPoint2.y + Math.sin(Math.toRadians(contAngle2.toDouble())).toFloat() * radius * contRatioTR2

        return curve
    }


}