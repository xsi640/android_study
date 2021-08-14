package com.github.xsi640.databinding3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.databinding.DataBindingUtil
import com.github.xsi640.databinding3.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.networkImage =
            "http://vcdnb.huoying666.com/hy-upload/20190920/4647547/57c589d08b_7.jpg_home-image-640"
        activityMainBinding.localImage = R.drawable.mv
    }
}

class MyAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl", "defaultImageResource")
        fun loadImageUrl(imageView: ImageView, url: String, defaultImageResource: Int) {
            if (!TextUtils.isEmpty(url)) {
                Picasso.get().load(url)
                    .placeholder(defaultImageResource)
                    .into(imageView)
            } else {
                imageView.setBackgroundColor(Color.GRAY)
            }
        }
    }
}