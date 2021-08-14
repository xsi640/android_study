package com.github.xsi640.lifecycle

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.OnLifecycleEvent

/**
 * ./adb -s emulator-5554 emu geo fix 121 21
 */
class MyLocationService : LifecycleService() {
    init {
        Log.d("Location", "MyLocationService")
        val observer = MyLocationObserver(this)
        lifecycle.addObserver(observer)
    }
}

class MyLocationObserver(
    val context: Context
) : LifecycleObserver {

    val locationListener = MyLocationListener()
    lateinit var locationManager: LocationManager

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun startGetLocation() {
        Log.d("Location", "startGetLocation")
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            3000L,
            1.0f,
            locationListener
        )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stopGetLocation() {
        Log.d("Location", "stopGetLocation")
        locationManager.removeUpdates(locationListener)
    }

    class MyLocationListener : LocationListener {
        override fun onLocationChanged(location: Location) {
            Log.d("Location", "locationChanged:$location")
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

        }
    }
}