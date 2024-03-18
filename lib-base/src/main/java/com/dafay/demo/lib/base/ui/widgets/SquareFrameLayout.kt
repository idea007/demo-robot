package com.dafay.demo.lib.base.ui.widgets

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 *
 * @ClassName:      SquareFrameLayout$
 * @Description:    java类作用描述
 * @Author:         idea
 * @CreateDate:     2019-10-09$ 15:39$
 */

class SquareFrameLayout : FrameLayout {

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

}