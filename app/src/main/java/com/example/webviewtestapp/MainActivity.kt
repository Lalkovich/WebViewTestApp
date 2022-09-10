package com.example.webviewtestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.onesignal.OneSignal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONE_SIGNAL_APP_ID)

    }

    companion object{
        const val ONE_SIGNAL_APP_ID = "c7397139-f3f3-47ba-a8ae-981238b40199"
    }
}