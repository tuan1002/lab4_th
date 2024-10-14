package com.example.bai1

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int> get() = _counter

    init {
        _counter.value = 0
    }
    fun incrementCounter() {
        _counter.value = _counter.value?.plus(1)
    }
    fun setCounter(value: Int) {
        _counter.value = value
    }

}