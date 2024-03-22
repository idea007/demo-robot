package com.dafay.demo.robot.data.role

import com.dafay.demo.robot.data.Constants
import com.dafay.demo.robot.data.DrawInfo
import com.dafay.demo.robot.data.PoseInfo
import com.dafay.demo.robot.data.ViewPropertyInfo
import com.dafay.demo.robot.data.VisualInfo
import com.dafay.demo.robot.data.face.OliveFace

/**
 * @Des
 * @Author lipengfei
 * @Date 2024/3/19
 */
object OliveRole : BaseRole() {
    override val role: String = OliveFace.face

    fun poseDefault(
        isDelay: Boolean = false,
        duration: Long = Constants.DEFAULT_DURATION,
        interpolatorType: Int = 8,
        robotViewPropertyInfo: ViewPropertyInfo = ViewPropertyInfo()
    ): PoseInfo {
        return PoseInfo(isDelay, duration, interpolatorType, OliveFace.getEmote2(), getTrayVisualInfo1(), robotViewPropertyInfo)
    }

    fun poseTrunLeft(
        isDelay: Boolean = false,
        duration: Long = Constants.DEFAULT_DURATION,
        interpolatorType: Int = 8,
        robotViewPropertyInfo: ViewPropertyInfo = ViewPropertyInfo()
    ): PoseInfo {
        return PoseInfo(
            isDelay, duration, interpolatorType,
            OliveFace.getEmoteTurnLeft(),
            getTrayVisualInfo1(),
            headViewPropertyInfo = ViewPropertyInfo(0f, 0f, 1f, 1f, 1f, -5f, 0f, -20f),
            robotViewPropertyInfo = robotViewPropertyInfo
        )
    }

    fun poseTrunRight(
        isDelay: Boolean = false,
        duration: Long = Constants.DEFAULT_DURATION,
        interpolatorType: Int = 8,
        robotViewPropertyInfo: ViewPropertyInfo = ViewPropertyInfo()
    ): PoseInfo {
        return PoseInfo(
            isDelay, duration, interpolatorType,
            OliveFace.getEmoteTurnRight(),
            getTrayVisualInfo1(),
            robotViewPropertyInfo = robotViewPropertyInfo,
            headViewPropertyInfo = ViewPropertyInfo(0f, 0f, 1f, 1f, 1f, 5f, 0f, 20f)
        )
    }

    fun poseTurnLeftCloseEyes(
        isDelay: Boolean = false,
        duration: Long = Constants.DEFAULT_DURATION,
        interpolatorType: Int = 8,
        robotViewPropertyInfo: ViewPropertyInfo = ViewPropertyInfo()
    ): PoseInfo {
        return PoseInfo(
            isDelay, duration, interpolatorType,
            OliveFace.getEmoteTurnLeftCloseEyes(),
            getTrayVisualInfo1(),
            robotViewPropertyInfo = robotViewPropertyInfo,
            headViewPropertyInfo = ViewPropertyInfo(0f, 0f, 1f, 1f, 1f, -5f, 0f, -20f)
        )
    }

    fun poseTurnRightCloseEyes(isDelay: Boolean = false, duration: Long = Constants.DEFAULT_DURATION, interpolatorType: Int = 8): PoseInfo {
        return PoseInfo(
            isDelay, duration, interpolatorType,
            OliveFace.getEmoteTurnRightCloseEyes(),
            getTrayVisualInfo1(),
            headViewPropertyInfo = ViewPropertyInfo(0f, 0f, 1f, 1f, 1f, 5f, 0f, 20f)
        )
    }


    /**
     * 左看看
     * @return
     */
    fun actionLookLeft(): ArrayList<PoseInfo> {
        return ArrayList<PoseInfo>().apply {
            add(poseDefault())
            // 左转
            add(poseTrunLeft(false, 200, 8))
            // 停顿
            add(PoseInfo(true, 300))
            // 闭眼
            add(poseTurnLeftCloseEyes(false, 50))
            // 睁开
            add(poseTrunLeft(false, 50))
            // 停顿
            add(PoseInfo(true, 400))
            // 闭眼
            add(poseTurnLeftCloseEyes(false, 50))
            // 睁开
            add(poseTrunLeft(false, 50))
            // 停顿
            add(PoseInfo(true, 200))
            add(poseDefault())
        }
    }

    /**
     * 右看看
     * @return
     */
    fun actionLookRight(): ArrayList<PoseInfo> {
        return ArrayList<PoseInfo>().apply {
            add(poseDefault())
            // 右转
            add(poseTrunRight(false, 200, 8))
            // 停顿
            add(PoseInfo(true, 300))
            // 闭眼
            add(poseTurnRightCloseEyes(false, 50))
            // 睁开
            add(poseTrunRight(false, 50))
            // 停顿
            add(PoseInfo(true, 400))
            // 闭眼
            add(poseTurnRightCloseEyes(false, 50))
            // 睁开
            add(poseTrunRight(false, 50))
            // 停顿
            add(PoseInfo(true, 200))
            add(poseDefault())
        }
    }

    fun actionLeftMove(): ArrayList<PoseInfo> {
        return ArrayList<PoseInfo>().apply {
            add(poseDefault(duration = 100))
            // 左转
            add(poseTrunLeft(false, 250, 8, robotViewPropertyInfo = ViewPropertyInfo(translationXRatio = -2f)))
            // 左移
//            add(poseTrunLeft(false, 100, 8, robotViewPropertyInfo = ViewPropertyInfo(translationXRatio = -2f)))
            // 停顿
            add(PoseInfo(true, 300))
            // 闭眼
            add(poseTurnLeftCloseEyes(false, 50, robotViewPropertyInfo = ViewPropertyInfo(translationXRatio = -2f)))
            // 睁开
            add(poseTrunLeft(false, 50, robotViewPropertyInfo = ViewPropertyInfo(translationXRatio = -2f)))
            // 停顿
            add(PoseInfo(true, 400))
            // 闭眼
            add(poseTurnLeftCloseEyes(false, 50, robotViewPropertyInfo = ViewPropertyInfo(translationXRatio = -2f)))
            // 睁开
            add(poseTrunLeft(false, 50, robotViewPropertyInfo = ViewPropertyInfo(translationXRatio = -2f)))
            // 停顿
            add(PoseInfo(true, 200))
            // 右转
            add(poseTrunRight(false, 300, 8, robotViewPropertyInfo = ViewPropertyInfo(translationXRatio = 0f)))
            add(PoseInfo(true, 200))
            // 右移
            add(poseDefault())
        }
    }


    fun getTrayVisualInfo1(): VisualInfo {
        return VisualInfo(DrawInfo(0.3f, OliveFace.DEFAULT_FACE_COLOR), Constants.DEFAULT_RENDERINFO_TRAY)
    }
//
//    private fun getTrayTurnLeft(): VisualInfo {
//        return VisualInfo(DrawInfo(0.3f, OliveFace.DEFAULT_FACE_COLOR), ViewPropertyInfo(0f, 0f, 1f, 0.2f, 1f, 3f, 0f, 20f))
//    }


}