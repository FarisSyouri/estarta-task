package com.estarta.task.presentation.utils

import android.content.Context
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import androidx.core.view.isVisible
import com.estarta.task.R
import com.estarta.task.databinding.LayoutProgressDialogBinding

class LoadingProgressDialog (
    context: Context
): AppCompatDialog(context, R.style.DialogLoadingStyle){
    init {
        setCancelable(false)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val binding = LayoutProgressDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnShowListener {
            context?.let {
                binding.rlLoad.isVisible = true
            }
        }
    }
}