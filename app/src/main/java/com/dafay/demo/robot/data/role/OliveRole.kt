package com.dafay.demo.robot.data.role

import com.dafay.demo.robot.data.Constants
import com.dafay.demo.robot.data.DrawInfo
import com.dafay.demo.robot.data.PoseInfo
import com.dafay.demo.robot.data.ViewPropertyInfo
import com.dafay.demo.robot.data.VisualInfo
import com.dafay.demo.robot.data.face.BaseFace
import com.dafay.demo.robot.data.face.OliveFace

/**
 * @Des
 * @Author lipengfei
 * @Date 2024/3/19
 */
object OliveRole : BaseRole() {
    override val role: String = OliveFace.face

    fun getDefaultPose(): PoseInfo {
        return PoseInfo(OliveFace.getEmote2(), getTrayVisualInfo1())
    }

    fun getTrunLeftPose():PoseInfo{
        return PoseInfo(OliveFace.getEmoteTurnLeft() ,
            getTrayTurnLeft(),
            headViewPropertyInfo = ViewPropertyInfo(0f, 0f, 1f, 1f, 1f, -5f, 0f, -20f)
        )
    }






    private fun getTrayVisualInfo1(): VisualInfo {
        return VisualInfo(DrawInfo(0.3f, OliveFace.DEFAULT_FACE_COLOR), Constants.DEFAULT_RENDERINFO_TRAY)
    }

    private fun getTrayTurnLeft():VisualInfo{
        return VisualInfo(DrawInfo(0.3f, OliveFace.DEFAULT_FACE_COLOR), ViewPropertyInfo(0f, 0f, 1f, 0.2f, 1f, 3f, 0f, 20f))
    }


}