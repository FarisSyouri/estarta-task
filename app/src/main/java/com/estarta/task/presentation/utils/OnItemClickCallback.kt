package com.estarta.task.presentation.utils

import android.view.View

interface OnItemClickCallback {
    fun onItemClicked(view: View, listableItem: Any, position: Int)
}