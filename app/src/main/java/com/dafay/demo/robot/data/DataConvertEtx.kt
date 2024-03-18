package com.dafay.demo.robot.data

import android.graphics.Path


fun CurveShape.getCurrentCurveShape(targetCurveGroup: CurveShape, progress: Float): CurveShape {
    val tempCurveShape = CurveShape()
    tempCurveShape.isLink = targetCurveGroup.isLink
    for (i in 0 until targetCurveGroup.curveList.size) {
        val tempCurve = Curve()
        tempCurve.anchorPoint1.x =
            this.curveList.get(i).anchorPoint1.x + (targetCurveGroup.curveList.get(i).anchorPoint1.x - this.curveList.get(
                i
            ).anchorPoint1.x) * progress
        tempCurve.anchorPoint1.y =
            this.curveList.get(i).anchorPoint1.y + (targetCurveGroup.curveList.get(i).anchorPoint1.y - this.curveList.get(
                i
            ).anchorPoint1.y) * progress

        tempCurve.anchorPoint2.x =
            this.curveList.get(i).anchorPoint2.x + (targetCurveGroup.curveList.get(i).anchorPoint2.x - this.curveList.get(
                i
            ).anchorPoint2.x) * progress
        tempCurve.anchorPoint2.y =
            this.curveList.get(i).anchorPoint2.y + (targetCurveGroup.curveList.get(i).anchorPoint2.y - this.curveList.get(
                i
            ).anchorPoint2.y) * progress

        tempCurve.contPoint1.x =
            this.curveList.get(i).contPoint1.x + (targetCurveGroup.curveList.get(i).contPoint1.x - this.curveList.get(
                i
            ).contPoint1.x) * progress
        tempCurve.contPoint1.y =
            this.curveList.get(i).contPoint1.y + (targetCurveGroup.curveList.get(i).contPoint1.y - this.curveList.get(
                i
            ).contPoint1.y) * progress

        tempCurve.contPoint2.x =
            this.curveList.get(i).contPoint2.x + (targetCurveGroup.curveList.get(i).contPoint2.x - this.curveList.get(
                i
            ).contPoint2.x) * progress
        tempCurve.contPoint2.y =
            this.curveList.get(i).contPoint2.y + (targetCurveGroup.curveList.get(i).contPoint2.y - this.curveList.get(
                i
            ).contPoint2.y) * progress

        tempCurveShape.curveList.add(tempCurve)
    }
    return tempCurveShape
}

fun CurveShape.getCurveShapePaths(): ArrayList<Path> {
    val paths = ArrayList<Path>()
    if (this.isLink) {
        var path = Path()
        path.moveTo(
            this.curveList.get(0).anchorPoint1.x,
            this.curveList.get(0).anchorPoint1.y
        )
        for (i in 0 until this.curveList.size) {
            path.cubicTo(
                this.curveList.get(i).contPoint1.x,
                this.curveList.get(i).contPoint1.y,
                this.curveList.get(i).contPoint2.x,
                this.curveList.get(i).contPoint2.y,
                this.curveList.get(i).anchorPoint2.x,
                this.curveList.get(i).anchorPoint2.y
            )
        }
        paths.add(path)
    } else {
        for (i in 0 until this.curveList.size) {
            var path = Path()
            path.moveTo(
                this.curveList.get(i).anchorPoint1.x,
                this.curveList.get(i).anchorPoint1.y
            )
            path.cubicTo(
                this.curveList.get(i).contPoint1.x,
                this.curveList.get(i).contPoint1.y,
                this.curveList.get(i).contPoint2.x,
                this.curveList.get(i).contPoint2.y,
                this.curveList.get(i).anchorPoint2.x,
                this.curveList.get(i).anchorPoint2.y
            )
            paths.add(path)
        }
    }
    return paths
}


/**
 * @param ruler 参考距离
 */
fun DrawInfo.getCurveShape(ruler: Float): CurveShape {
    return CurveShapeFactory.getCurveGroupByType(
        this.shapeType,
        this.isLink,
        this.radiusRatio,
        ruler,
        this.centerXRatio,
        ruler,
        this.centerXRatio
    )
}