package com.example.timerapp

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {

    private val _time = MutableLiveData(0)  // Lưu số giây
    val time: LiveData<Int> get() = _time

    private var timer: CountDownTimer? = null
    private var isRunning = false
    private var startTime = 0L

    // Bắt đầu đếm thời gian
    fun startTimer() {
        if (!isRunning) {
            timer = object : CountDownTimer(Long.MAX_VALUE, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    _time.value = _time.value?.plus(1)
                }

                override fun onFinish() {}
            }
            timer?.start()
            isRunning = true
        }
    }

    // Tạm dừng bộ đếm
    fun pauseTimer() {
        timer?.cancel()
        isRunning = false
    }

    // Thiết lập lại bộ đếm về 0
    fun resetTimer() {
        pauseTimer()
        _time.value = 0
    }

    // Lưu trạng thái bộ đếm khi thay đổi cấu hình
    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
    fun isTimerRunning(): Boolean {
        return isRunning
    }
    fun setTime(time: Int) {
        _time.value = time
    }
}