package com.dafay.demo.robot.ui.page.preview

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.recyclerview.widget.RecyclerView
import com.dafay.demo.lib.base.ui.adapter.BaseAdapter
import com.dafay.demo.robot.data.Constants
import com.dafay.demo.robot.data.DrawInfo
import com.dafay.demo.robot.data.ViewPropertyInfo
import com.dafay.demo.robot.data.VisualInfo
import com.dafay.demo.robot.databinding.ItemCurveshapeBinding

/**
 * @ClassName HomeAdapter
 * @Desb
 * @Author lipengfei
 * @Date 2023/11/24 17:37
 */
class CurveShapeAdapter : BaseAdapter<String>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CurveShapeHolder(ItemCurveshapeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CurveShapeHolder) {
            holder.onBindViewHolder(position, datas[position])
        }
    }

    class CurveShapeHolder : RecyclerView.ViewHolder {

        val binding: ItemCurveshapeBinding

        constructor(itemView: ItemCurveshapeBinding) : super(itemView.root) {
            binding = itemView
        }

        fun onBindViewHolder(position: Int, s: String) {
            var drawInfo1 = DrawInfo(
                0.8f,
                Color.parseColor("#800000FF"),
                s,
                true,
                Constants.DEFAULT_DURATION,
                8,
                false,
                1f,
                1f,
                0f,
                Paint.Style.FILL
            )
            var drawInfo2 = DrawInfo(
                0.8f,
                Color.parseColor("#800000FF"),
                s,
                true,
                Constants.DEFAULT_DURATION,
                8,
                false,
                1f,
                1f,
                0f,
                Paint.Style.STROKE
            )
            var drawInfo3 = DrawInfo(
                0.8f,
                Color.parseColor("#800000FF"),
                s,
                false,
                Constants.DEFAULT_DURATION,
                8,
                false,
                1f,
                1f,
                0f,
                Paint.Style.FILL
            )
            var drawInfo4 = DrawInfo(
                0.8f,
                Color.parseColor("#800000FF"),
                s,
                false,
                Constants.DEFAULT_DURATION,
                8,
                false,
                1f,
                1f,
                0f,
                Paint.Style.STROKE
            )
            binding.tvText.text = position.toString() + ":" + s
            binding.sbSeekbar1.max = 100
            binding.sbSeekbar2.max = 100
            binding.sbSeekbar3.max = 100
            binding.sbSeekbar1.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    binding.csvShapeview1.setProgress(progress.toFloat() / 100)
                    binding.csvShapeview2.setProgress(progress.toFloat() / 100)
                    binding.csvShapeview3.setProgress(progress.toFloat() / 100)
                    binding.csvShapeview4.setProgress(progress.toFloat() / 100)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })
            binding.sbSeekbar2.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    binding.csvShapeview1.updateStrokeWidthRatio(progress.toFloat() / 200)
                    binding.csvShapeview2.updateStrokeWidthRatio(progress.toFloat() / 200)
                    binding.csvShapeview3.updateStrokeWidthRatio(progress.toFloat() / 200)
                    binding.csvShapeview4.updateStrokeWidthRatio(progress.toFloat() / 200)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })
            binding.sbSeekbar3.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    drawInfo1.apply {
                        radiusRatio=progress.toFloat() / 100
                    }
                    drawInfo2.apply {
                        radiusRatio=progress.toFloat() / 100
                    }
                    drawInfo3.apply {
                        radiusRatio=progress.toFloat() / 100
                    }
                    drawInfo4.apply {
                        radiusRatio=progress.toFloat() / 100
                    }
                    binding.csvShapeview1.changeVisualInfo(VisualInfo( drawInfo1, ViewPropertyInfo()),true)
                    binding.csvShapeview2.changeVisualInfo(VisualInfo( drawInfo2, ViewPropertyInfo()),true)
                    binding.csvShapeview3.changeVisualInfo(VisualInfo( drawInfo3, ViewPropertyInfo()),true)
                    binding.csvShapeview4.changeVisualInfo(VisualInfo( drawInfo4, ViewPropertyInfo()),true)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })
            binding.root.post {
                binding.csvShapeview1.changeVisualInfo(
                    VisualInfo( drawInfo1, ViewPropertyInfo()), true
                )

                binding.csvShapeview2.changeVisualInfo(
                    VisualInfo( drawInfo2, ViewPropertyInfo()), true
                )
                binding.csvShapeview3.changeVisualInfo(
                    VisualInfo( drawInfo3, ViewPropertyInfo()), true
                )
                binding.csvShapeview4.changeVisualInfo(
                    VisualInfo( drawInfo4, ViewPropertyInfo()), true
                )
                binding.sbSeekbar1.progress = 100
                binding.sbSeekbar2.progress = 20
            }
        }
    }
}
