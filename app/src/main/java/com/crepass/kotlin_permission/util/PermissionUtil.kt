package com.crepass.kotlin_permission.util

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

import androidx.core.content.ContextCompat





class PermissionUtil {

    companion object{
        val PERMISSION_REQUEST_CODE=1

        fun checkPermissions(activity : Activity){
            val permissions = arrayOf<String>(
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.SEND_SMS,
                Manifest.permission.READ_CALENDAR,
                Manifest.permission.WRITE_CALENDAR,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_MEDIA_VIDEO,
                Manifest.permission.READ_MEDIA_IMAGES,
                Manifest.permission.READ_MEDIA_AUDIO,

            )

            val permissionsNeeded: MutableList<String> = ArrayList()

            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(
                        activity,
                        permission!!
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    permissionsNeeded.add(permission!!)
                }
            }

            if(!permissionsNeeded.isNullOrEmpty()){
                ActivityCompat.requestPermissions(activity, permissionsNeeded.toTypedArray(), PERMISSION_REQUEST_CODE)
            }


        }

    }



}