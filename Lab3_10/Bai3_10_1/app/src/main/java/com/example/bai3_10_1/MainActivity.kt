package com.example.bai3_10_1

import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.transition.TransitionManager
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private lateinit var btnAnimate: Button // Để lưu trữ tham chiếu đến nút Animate
    private lateinit var btnAnimateTransition: Button // Để lưu trữ tham chiếu đến nút Transition

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        btnAnimate = findViewById(R.id.btnAnimate) // Khởi tạo tham chiếu đến nút Animate
        btnAnimateTransition = findViewById(R.id.btnAnimateTransition) // Khởi tạo tham chiếu đến nút Transition

        // Bắt đầu hiệu ứng chuyển cảnh khi nhấn nút Transition
        btnAnimateTransition.setOnClickListener {
            TransitionManager.beginDelayedTransition(constraintLayout)
            btnAnimateTransition.layoutParams.width = 500
            btnAnimateTransition.requestLayout()
        }

        // Khởi tạo ImageView
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setBackgroundResource(R.drawable.animated_button)
        val animationDrawable = imageView.background as AnimationDrawable

        // Bắt đầu hiệu ứng chuyển đổi hình ảnh khi nhấn ImageView
        imageView.setOnClickListener {
            animationDrawable.start()
        }

        // Bắt đầu hiệu ứng khi nhấn nút Animate
        btnAnimate.setOnClickListener {
            // Bắt đầu hiệu ứng chuyển cảnh
            TransitionManager.beginDelayedTransition(constraintLayout)

            // Thay đổi kích thước nút
            btnAnimate.layoutParams.width = 300 // Kích thước mới
            btnAnimate.layoutParams.height = 150 // Kích thước mới

            // Thay đổi màu nền thành đỏ
            btnAnimate.setBackgroundColor(Color.RED)

            // Cập nhật layout để áp dụng thay đổi
            btnAnimate.requestLayout()
        }
    }
}
