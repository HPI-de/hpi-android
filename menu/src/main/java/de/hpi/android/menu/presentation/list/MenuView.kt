package de.hpi.android.menu.presentation.list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import de.hpi.android.menu.databinding.ItemMenuBinding
import kotlin.properties.Delegates
import kotlin.properties.Delegates.observable


internal class MenuView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding = ItemMenuBinding.inflate(LayoutInflater.from(context), this, true)

    val menu by observable(null) { _, _, newMenu ->
        binding.menu = newMenu
    }
}