package com.ifixhubke.foody.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ifixhubke.foody.R
import com.mosesaltruism.mosesaltruism.NetworkState

class MainActivity : NetworkState() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}