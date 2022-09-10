package com.example.webviewtestapp.ui.start_fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.webviewtestapp.R
import com.example.webviewtestapp.databinding.FragmentStartBinding
import com.example.webviewtestapp.utils.MyClickableSpan
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess

class StartFragment : Fragment(R.layout.fragment_start) {

    private val binding: FragmentStartBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref = activity?.getSharedPreferences("Agreement",Context.MODE_PRIVATE)
        if(sharedPref!!.contains(AGREE_CONFIRMED)){
            findNavController().navigate(R.id.action_startFragment_to_webViewFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = activity?.getSharedPreferences("Agreement",Context.MODE_PRIVATE)
        val fulltext = getString(R.string.agreement_full)
        val confidential = getString(R.string.agreement)
        val policy = getString(R.string.privacy_policy)
        val spannableString = SpannableString(fulltext)

        val confidentialClickable = MyClickableSpan {
            Snackbar.make(it, R.string.agreement, Snackbar.LENGTH_SHORT).show()
        }

        val policyClickable = MyClickableSpan {
            Snackbar.make(it, R.string.privacy_policy, Snackbar.LENGTH_SHORT).show()
        }
        spannableString.setSpan(
            confidentialClickable,
            fulltext.indexOf(confidential),
            fulltext.indexOf(confidential) + confidential.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            policyClickable,
            fulltext.indexOf(policy),
            fulltext.indexOf(policy) + policy.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.privacyPolicy.run {
            text = spannableString
            movementMethod = LinkMovementMethod.getInstance()
            highlightColor = Color.TRANSPARENT
        }
        binding.agree.setOnClickListener {
            sharedPref?.edit()?.putBoolean(AGREE_CONFIRMED,false)?.apply()
            findNavController().navigate(R.id.action_startFragment_to_webViewFragment)
        }
        binding.disagree.setOnClickListener {
            exitProcess(0)
        }
    }

    companion object {
        const val AGREE_CONFIRMED = "Agree confirmed"
    }

}