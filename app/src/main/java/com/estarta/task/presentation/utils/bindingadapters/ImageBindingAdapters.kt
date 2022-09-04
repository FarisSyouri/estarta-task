package com.estarta.task.presentation.utils.bindingadapters

import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object ImageBindingAdapters {

    @JvmStatic
    @BindingAdapter("urlImage")
    fun ImageView.setUrlImage(imageUrl: String?) {
        imageUrl?.let {
            Glide.with(context).load(imageUrl).into(this)
        }
    }

//    @JvmStatic
//    @BindingAdapter("urlImage")
//    fun TextView.setFormatDate(date: String?) {
//      date?.let {
//          val localDate = LocalDate.parse(date)
//            Glide.with(context).load(date).into(this)
//        }
//    }


}