package com.dafay.demo.robot.ui.page

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dafay.demo.lib.base.ui.base.BaseActivity
import com.dafay.demo.robot.R
import com.dafay.demo.robot.databinding.ActivityHostBinding

class HostActivity : BaseActivity(R.layout.activity_host) {
    companion object {
        fun startActivity(context: Context, frgClazz: Class<*>) {
            val intent = Intent(context, HostActivity::class.java)
            intent.putExtra("frg_class_name", frgClazz.name)
            context.startActivity(intent)
        }
    }

    override val binding: ActivityHostBinding by viewBinding()
    private lateinit var passFrgClassName: String

    override fun resolveIntent(intent: Intent?) {
        super.resolveIntent(intent)
        intent?.extras.apply {
            val name = this?.getString("frg_class_name")
            if (name.isNullOrEmpty()) {
                finish()
                return
            }
            passFrgClassName = name
        }
    }

    override fun initViews() {
        super.initViews()
        val fragment = Class.forName(passFrgClassName).newInstance() as Fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commitNow()
    }

}