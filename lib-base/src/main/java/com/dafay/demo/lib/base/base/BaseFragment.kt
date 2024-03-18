package com.dafay.demo.lib.base.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

/**
 * @Des
 * @Author lipengfei
 * @Date 2024/2/20
 */
abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    protected abstract val binding: ViewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObserver()
        bindListener()
        initializeData()
    }

    protected open fun initViews() {}

    protected open fun initObserver() {}

    protected open fun bindListener() {}

    protected open fun initializeData() {}
}