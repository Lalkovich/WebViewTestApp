package com.example.webviewtestapp.ui.webview_fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.webviewtestapp.R
import com.example.webviewtestapp.databinding.FragmentWebviewBinding

class WebViewFragment:Fragment(R.layout.fragment_webview){
    private val binding:FragmentWebviewBinding by viewBinding()

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webViewScreen.loadUrl("https://www.google.com/")
        
        val webViewSetting = binding.webViewScreen.settings
        webViewSetting.javaScriptEnabled = true
        webViewSetting.javaScriptCanOpenWindowsAutomatically = true
        with(binding){
            webViewScreen.webViewClient = WebViewClient()
            webViewScreen.canGoBack()
            webViewScreen.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
                if(keyCode == KeyEvent.KEYCODE_BACK && event.action == MotionEvent.ACTION_UP && webViewScreen.canGoBack()){
                    webViewScreen.goBack()
                    return@OnKeyListener true
                }
                false
            })
        }

    }

}