package com.github.xsi640.databinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.xsi640.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        activityMainBinding.idol = Idol("小姐姐", 5)
        activityMainBinding.eventHandle = EventHandleListener(this)
    }
}

class EventHandleListener(
    val context: Context
) {
    fun buttonOnClick(view: View) {
        Toast.makeText(context, "喜欢", Toast.LENGTH_SHORT).show()
    }
}