package com.dafay.demo.robot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dafay.demo.lib.base.ui.base.BaseFragment
import com.dafay.demo.robot.data.CurveShapeFactory
import com.dafay.demo.robot.databinding.FragmentCurveShapesPreviewBinding

class CurveShapesPreviewFragment : BaseFragment(R.layout.fragment_curve_shapes_preview) {
    override val binding: FragmentCurveShapesPreviewBinding by viewBinding()

    private val shapes = ArrayList<String>().apply {
        add(CurveShapeFactory.形状_椭圆_1)
        add(CurveShapeFactory.线_下半圆_4)
        add(CurveShapeFactory.线_下半圆_3)
        add(CurveShapeFactory.线_下半圆_2)
        add(CurveShapeFactory.线_下半圆_1)
        add(CurveShapeFactory.形状_下半圆_6)
        add(CurveShapeFactory.形状_下半圆_5)
        add(CurveShapeFactory.形状_下半圆_4)
        add(CurveShapeFactory.形状_下半圆_3)
        add(CurveShapeFactory.形状_下半圆_2)
        add(CurveShapeFactory.形状_下半圆_1)
        add(CurveShapeFactory.形状_圆形)
        add(CurveShapeFactory.形状_正方形)
        add(CurveShapeFactory.线_横线)
        add(CurveShapeFactory.形状_心形)
        add(CurveShapeFactory.形状_三角形_1)
        add(CurveShapeFactory.线_向右箭头_1)
        add(CurveShapeFactory.线_向左箭头_1)
        add(CurveShapeFactory.线_向上箭头_1)
        add(CurveShapeFactory.线_向下箭头_1)
        add(CurveShapeFactory.线_叉号_1)
        add(CurveShapeFactory.形状_下半圆_7)
        add(CurveShapeFactory.形状_上半圆_1)
        add(CurveShapeFactory.线_人字形_1)
        add(CurveShapeFactory.形状_椭圆_窝窝头形状)
        add(CurveShapeFactory.线_上半圆_1)
    }

    private lateinit var curveShapeAdapter: CurveShapeAdapter


    override fun initViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        curveShapeAdapter = CurveShapeAdapter()
        binding.rvRecyclerview.apply {
            this.layoutManager = LinearLayoutManager(requireContext())
            this.adapter = curveShapeAdapter
        }
    }

    override fun initializeData() {
        curveShapeAdapter.setDatas(shapes)
    }

}