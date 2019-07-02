package de.hpi.android.core.presentation.utils

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
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
    Glide.with(this)
        .load(url)
        .placeholder(placeholder ?: ColorDrawable(ContextCompat.getColor(context, R.color.core_placeholder)))
        .into(this)
}
// endregion

// region ChipGroup
data class ChipData(
    val id: String,
    val text: String,
    @DrawableRes
    val icon: Int = 0
)

@BindingAdapter(value = ["chips", "onChipClicked"], requireAll = false)
fun ChipGroup.setChips(chips: List<ChipData>?, onChipClicked: ((String) -> Unit)?) {
    removeAllViews()
    for (chip in chips.orEmpty()) {
        addView(Chip(context).apply {
            text = chip.text
            chipIcon = chip.icon.takeUnless { it == 0 }?.let { context.getDrawable(it) }
            onChipClicked?.let { setOnClickListener { it(chip.id) } }
        })
    }
}
// endregion
