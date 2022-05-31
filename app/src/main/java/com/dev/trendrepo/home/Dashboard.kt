package com.dev.trendrepo.home

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.trendrepo.R
import com.dev.trendrepo.base.BaseActivity
import com.dev.trendrepo.databinding.ActivityDashboardBinding

import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class Dashboard : BaseActivity() {
    lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.BLACK
        } catch (e: Exception) {
            e.printStackTrace()
        }

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }



    override fun onSetupViewGroup() {

    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_dashboard)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }




}