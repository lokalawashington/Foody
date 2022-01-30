package com.ifixhubke.foody.ui.activities

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hover.sdk.api.Hover
import com.ifixhubke.foody.R
import com.ifixhubke.foody.utils.changeStatusBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            changeStatusBar(true)
        }

        Hover.initialize(this)
    }
}