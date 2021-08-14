package com.github.xsi640.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var viewModel: MyViewModel

//    var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                MyViewModel::class.java
            )

        textView = findViewById(R.id.textView)
        textView.text = viewModel.number.toString()
    }

    fun plusNumber(view: View) {
        textView.text = (++viewModel.number).toString()
//        textView.text = (++number).toString()
    }
}