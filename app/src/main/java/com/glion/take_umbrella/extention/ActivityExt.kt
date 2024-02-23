package com.glion.take_umbrella.extention

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

fun Activity.hasPermission(permissions: List<String>) = permissions.all{
    ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
}

fun Activity.requestPermission(permissions: List<String>, requestPermissionCode: Int){
    ActivityCompat.requestPermissions(
        this,
        permissions.toTypedArray(),
        requestPermissionCode
    )
}