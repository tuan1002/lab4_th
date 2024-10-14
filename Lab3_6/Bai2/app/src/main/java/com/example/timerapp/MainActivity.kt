package com.example.timerapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.timerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: TimerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Quan sát LiveData từ ViewModel để cập nhật UI
        viewModel.time.observe(this, Observer { time ->
            binding.tvTimer.text = time.toString()
        })

        // Xử lý sự kiện Start/Pause
        binding.btnStartPause.setOnClickListener {
            if (viewModel.time.value == 0 || !viewModel.isTimerRunning()) {
                viewModel.startTimer()
                binding.btnStartPause.text = "Pause"
            } else {
                viewModel.pauseTimer()
                binding.btnStartPause.text = "Start"
            }
        }


        // Xử lý sự kiện Reset
        binding.btnReset.setOnClickListener {
            viewModel.resetTimer()
            binding.btnStartPause.text = "Start"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("time", viewModel.time.value ?: 0)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedTime = savedInstanceState.getInt("time", 0)
        viewModel.setTime(savedTime) // Cập nhật thời gian đã lưu
    }
}