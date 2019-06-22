package de.hpi.android.core.presentation.utils

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.bumptech.glide.Glide
import com.google.android.material.chip.ChipGroup
import de.hpi.android.core.R
import java.net.URL


// region Conversions
@BindingConversion
fun convertUrlToString(url: URL?): String? = url?.toString()
// endregion


// region View
@BindingAdapter("visible")
fun View.setVisible(visible: Any?) {
    visibility = when (visible) {
        null -> false
        is String -> visible.isNotBlank()
        is Collection<*> -> visible.isNotEmpty()
        else -> true
    }.let { if (it) View.VISIBLE else View.GONE }
}
// endregion

// region ImageView
@BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = false)
fun ImageView.loadImage(
    url: String?,
    placeholder: Drawable?
) {
    //    scaleType = ImageView.ScaleType.CENTER_CROP
    Glide.with(this)
        .load(url)
        .placeholder(placeholder ?: ColorDrawable(ContextCompat.getColor(context, R.color.core_placeholder)))
        .into(this)
}
// endregion

// region ChipGroup
