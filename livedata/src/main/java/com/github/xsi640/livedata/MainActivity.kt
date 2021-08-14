package com.github.xsi640.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel: MyViewModel
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        myViewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                MyViewModel::class.java
            )
        textView.text = myViewModel.number.toString()
        myViewModel.number.observe(this) {
            textView.text = it.toString()
        }
        startTime()
    }

    private fun startTime() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                myViewModel.number.postValue(myViewModel.number.value!! + 1)
            }
        }, 1000, 1000)
    }
}

class MyViewModel : ViewModel() {
    val number = MutableLiveData(0)
}