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

    fun poseDefault(isDelay: Boolean = false, duration: Long = Constants.DEFAULT_DURATION, interpolatorType: Int = 8): PoseInfo {
        return PoseInfo(isDelay, duration, interpolatorType, OliveFace.getEmote2())
    }

    fun poseTrunLeft(isDelay: Boolean = false, duration: Long = Constants.DEFAULT_DURATION, interpolatorType: Int = 8): PoseInfo {
        return PoseInfo(
            isDelay, duration, interpolatorType,
            OliveFace.getEmoteTurnLeft(),
            headViewPropertyInfo = ViewPropertyInfo(0f, 0f, 1f, 1f, 1f, -5f, 0f, -20f)
        )
    }

    fun poseTurnLeftCloseEyes(isDelay: Boolean = false, duration: Long = Constants.DEFAULT_DURATION, interpolatorType: Int = 8): PoseInfo {
        return PoseInfo(
            isDelay, duration, interpolatorType,
            OliveFace.getEmoteCloseEyes(),
            headViewPropertyInfo = ViewPropertyInfo(0f, 0f, 1f, 1f, 1f, -5f, 0f, -20f)
        )
    }


    /**
     * 做看看
     * @return
     */
    fun actionLeftLook(): ArrayList<PoseInfo> {
        return ArrayList<PoseInfo>().apply {
            // 左转
            add(poseTrunLeft(false,200,8))
            // 停顿
            add(PoseInfo(true,300))
            // 闭眼
            add(poseTurnLeftCloseEyes(false,50))
            // 睁开
            add(poseTrunLeft(false,50))
            // 停顿
            add(PoseInfo(true,400))
            // 闭眼
            add(poseTurnLeftCloseEyes(false,50))
            // 睁开
            add(poseTrunLeft(false,50))
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