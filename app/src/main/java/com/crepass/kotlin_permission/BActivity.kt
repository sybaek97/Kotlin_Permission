package com.crepass.kotlin_permission

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crepass.kotlin_permission.databinding.ActivityBBinding

class BActivity:AppCompatActivity() {
    private lateinit var binding :ActivityBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBBinding.inflate(layoutInflater).apply {
            setContentView(root)
            permissionAll.setOnClickListener{
                if(permissionAll.isChecked){
                    permission1.isChecked=true
                    permission2.isChecked=true
                    permission3.isChecked=true
                }else{
                    permission1.isChecked=false
                    permission2.isChecked=false
                    permission3.isChecked=false
                }

            }
        }



    }
}