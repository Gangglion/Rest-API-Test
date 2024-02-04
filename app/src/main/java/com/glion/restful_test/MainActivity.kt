package com.glion.restful_test

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.glion.restful_test.base.BaseActivity
import com.glion.restful_test.databinding.ActivityMainBinding
import com.glion.restful_test.extention.hasPermission
import com.glion.restful_test.extention.requestPermission
import com.glion.restful_test.extention.showToast
import com.glion.restful_test.util.TAG
import com.glion.restful_test.util.permissions
import com.glion.restful_test.util.requestCode

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    @SuppressLint("MissingPermission")
    private fun initView() = with(binding){
        btnGetPosition.setOnClickListener {
            if(!hasPermission(permissions)){
                requestPermission(permissions, requestCode)
            } else{
                val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                val locCurrent: Location? = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if(locCurrent != null){
                    Log.d(TAG, "위도 : ${locCurrent.latitude}")
                    Log.d(TAG, "경도 : ${locCurrent.longitude}")
                    tvLatitude.text = locCurrent.latitude.toString()
                    tvLongtitude.text = locCurrent.longitude.toString()
                }
            }
        }
    }
}