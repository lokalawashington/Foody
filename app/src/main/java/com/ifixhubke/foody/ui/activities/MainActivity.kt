package com.ifixhubke.foody.ui.activities

import android.os.Bundle
import com.hover.sdk.api.Hover
import com.ifixhubke.foody.R
import com.mosesaltruism.mosesaltruism.NetworkState

class MainActivity : NetworkState() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Hover.initialize(this)
    }
}