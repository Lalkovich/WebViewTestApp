package com.example.webviewtestapp

import android.app.Application
import com.appsflyer.AppsFlyerLib

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        val appsFlyer = AppsFlyerLib.getInstance()
        appsFlyer.init("PKrkzAEtv7bLwH9Dw36buk",null,this)
        appsFlyer.start(this)
    }
}