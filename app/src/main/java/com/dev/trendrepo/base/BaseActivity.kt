package com.dev.trendrepo.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.dev.trendrepo.utils.HideUtil


@Suppress("unused")

abstract class BaseActivity : AppCompatActivity() {

    var mViewGroup: ViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (mViewGroup == null) {

        } else {
            HideUtil.init(this, mViewGroup)
        }
        onSetupViewGroup()


    }

    abstract fun onSetupViewGroup()
}