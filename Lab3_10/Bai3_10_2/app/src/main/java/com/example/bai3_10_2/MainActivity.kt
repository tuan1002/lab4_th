package com.example.bai3_10_2

import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import android.animation.ObjectAnimator

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var imageView: ImageView
    private lateinit var animationDrawable: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo các thành phần giao diện
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        imageView = findViewById(R.id.imageView)

        // Thiết lập hiệu ứng chuyển đổi hình ảnh
        imageView.setBackgroundResource(R.drawable.animated_drawable)
        animationDrawable = imageView.background as AnimationDrawable

        // Bắt đầu hiệu ứng chuyển đổi khi nhấn vào ImageView
        imageView.setOnClickListener {
            animationDrawable.start()
        }

        // Hiệu ứng khi nhấn nút
        button.setOnClickListener {
            // Property Animation: Thay đổi kích thước, màu sắc, và vị trí của TextView
            val params = textView.layoutParams as ViewGroup.MarginLayoutParams
            TransitionManager.beginDelayedTransition(constraintLayout)

            // Tạo hiệu ứng chuyển động cho TextView
            val animatorWidth = ObjectAnimator.ofFloat(textView, "scaleX", 1f, 1.5f)
            val animatorHeight = ObjectAnimator.ofFloat(textView, "scaleY", 1f, 1.5f)
            animatorWidth.start()
            animatorHeight.start()

            // Thay đổi màu sắc của TextView
            textView.setTextColor(Color.RED)

            // Cập nhật vị trí TextView
            params.setMargins(0, params.topMargin + 50, 0, 0)
            textView.layoutParams = params
            textView.requestLayout()
        }
    }
}