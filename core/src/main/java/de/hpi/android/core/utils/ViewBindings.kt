package de.hpi.android.core.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.bumptech.glide.Glide
import java.net.URL


// region Conversions
@BindingConversion
fun convertUrlToString(url: URL): String = url.toString()
// endregion


// region ImageView
@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String) {
//    scaleType = ImageView.ScaleType.CENTER_CROP
    Glide.with(this)
        .load(url)
        .into(this)
}
// endregion
