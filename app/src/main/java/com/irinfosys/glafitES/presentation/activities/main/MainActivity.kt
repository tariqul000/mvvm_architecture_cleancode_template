package com.irinfosys.glafitES.presentation.activities.main

import android.os.Bundle
import com.irinfosys.glafitES.databinding.ActivityMainBinding
import com.irinfosys.glafitES.presentation.activities.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {



    override fun initializeViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    setSupportActionBar(binding.toolbar)

    }

//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(navController, null)
//    }




}