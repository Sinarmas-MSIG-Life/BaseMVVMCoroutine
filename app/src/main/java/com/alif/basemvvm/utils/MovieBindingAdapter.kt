package com.alif.basemvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.alif.basemvvm.R
import com.alif.basemvvm.common.LINK_IMAGE
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    if (imgUrl.isNullOrEmpty()) {
        Glide.with(imgView.context)
            .load(R.drawable.ic_no_data)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_placeholder)
                    .error(R.drawable.ic_error))
            .into(imgView)
    } else {
        Glide.with(imgView.context)
            .load(LINK_IMAGE+imgUrl)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_placeholder)
                    .error(R.drawable.ic_error))
            .into(imgView)
    }
}