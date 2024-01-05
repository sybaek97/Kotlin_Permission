package com.crepass.kotlin_permission

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import com.crepass.kotlin_permission.databinding.ActivityMainBinding
import com.crepass.kotlin_permission.util.PermissionUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.agreeButton.setOnClickListener {
            PermissionUtil.checkPermissions(this)

        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d("권한을 가져왔나",permissions.toString())
        if (requestCode == PermissionUtil.PERMISSION_REQUEST_CODE) {
            // 권한 요청 결과 처리
//            Log.d("권한을 가져왔나",requestCode.toString())
            val intent = Intent(this,BActivity::class.java)
            startActivity(intent)

        }
    }


}