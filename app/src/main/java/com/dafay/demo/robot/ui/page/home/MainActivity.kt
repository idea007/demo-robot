package com.dafay.demo.robot.ui.page.home

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dafay.demo.lib.base.ui.base.BaseActivity
import com.dafay.demo.lib.base.utils.dp2px
import com.dafay.demo.robot.ui.page.bezier.BezierFragment
import com.dafay.demo.robot.ui.page.preview.CurveShapesPreviewFragment
import com.dafay.demo.robot.R
import com.dafay.demo.robot.databinding.ActivityMainBinding
import com.dafay.demo.robot.ui.page.HostActivity
import com.dafay.demo.robot.ui.page.bezier.AuxiliaryBezierFragment
import com.dafay.demo.robot.ui.page.test.CurveShapeChangeFragment
import com.dafay.demo.robot.ui.page.emote.EmotesPreviewFragment
import com.dafay.demo.robot.ui.page.test.EmoteChangeFragment
import com.dafay.demo.robot.ui.page.test.RobotTestFragment
import com.example.demo.biz.base.widgets.GridMarginDecoration

class MainActivity : BaseActivity(R.layout.activity_main) {
    override val binding: ActivityMainBinding by viewBinding()

    private val homeItemList = ArrayList<HomeItem>().apply {
        this.add(HomeItem("贝塞尔曲线拟合圆", BezierFragment::class.java))
        this.add(HomeItem("三次贝塞尔辅助坐标系", AuxiliaryBezierFragment::class.java))
        this.add(HomeItem("四段贝塞尔曲线组成形状合集", CurveShapesPreviewFragment::class.java))
        this.add(HomeItem("形状切换测试", CurveShapeChangeFragment::class.java))
        this.add(HomeItem("形状组成的表情合集", EmotesPreviewFragment::class.java))
        this.add(HomeItem("表情切换测试", EmoteChangeFragment::class.java))
        this.add(HomeItem("机器人测试", RobotTestFragment::class.java))
    }

    private lateinit var homeAdapter: HomeAdapter

    override fun initViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        homeAdapter = HomeAdapter()
        binding.rvRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.rvRecyclerview.adapter = homeAdapter
        binding.rvRecyclerview.addItemDecoration(GridMarginDecoration(8.dp2px, 4.dp2px, 8.dp2px, 4.dp2px))
        homeAdapter.onItemClickListener = object : HomeAdapter.HomeViewHolder.OnItemClickListener {
            override fun onClickItem(view: View, position: Int, homeItem: HomeItem) {
                if (homeItem.clazz != null) {
                    HostActivity.startActivity(this@MainActivity, homeItem.clazz)
                }
            }
        }
    }

    override fun initializeData() {
        homeAdapter.setDatas(homeItemList)
    }
}