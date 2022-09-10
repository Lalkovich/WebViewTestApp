package com.example.webviewtestapp.ui.no_internet_fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.webviewtestapp.R
import com.example.webviewtestapp.databinding.FragmentNoInternetBinding

class NoInternetFragment: Fragment(R.layout.fragment_no_internet) {
    private val binding:FragmentNoInternetBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}