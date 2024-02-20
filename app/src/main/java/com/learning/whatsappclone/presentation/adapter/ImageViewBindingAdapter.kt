package com.learning.whatsappclone.presentation.adapter

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.learning.whatsappclone.R
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("imageUrl")
fun setImageUrl(imgView: CircleImageView, imgUrl: String?) {
    imgUrl?.let {
        Glide.with(imgView.context)
            .load(R.drawable.whatsapp_world).skipMemoryCache(true)
            .into(imgView)
    }
}
