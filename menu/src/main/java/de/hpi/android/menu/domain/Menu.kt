package de.hpi.android.menu.domain

import de.hpi.android.core.data.Id
import java.util.*

data class Menu(
    val id: Id<Menu>,
    val date: Date,
    val restaurant: Restaurant,

    val title: String,
    val substitution: String?,
    val price: Float, // TODO
    val counter: String?,
    val labels: Set<Label>
)
