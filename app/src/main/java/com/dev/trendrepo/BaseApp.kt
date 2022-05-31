package com.dev.trendrepo

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import cat.ereza.customactivityoncrash.config.CaocConfig
import dagger.hilt.android.HiltAndroidApp
import java.util.*

@HiltAndroidApp
class BaseApp : Application(){
    override fun onCreate() {
        super.onCreate()
        CaocConfig.Builder.create()
            .errorDrawable(R.drawable.ic_launcher_background)
            .apply();
        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.ARGB_8888

    }

}