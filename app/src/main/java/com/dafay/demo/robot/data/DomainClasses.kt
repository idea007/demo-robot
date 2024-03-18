package com.dafay.demo.robot.data

import androidx.fragment.app.Fragment

/**
 * @Des
 * @Author lipengfei
 * @Date 2024/3/18
 */

data class HomeItem(val title: String, val clazz: Class<out Fragment>? = null)