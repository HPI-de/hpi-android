package de.hpi.android.menu.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id
import java.util.*

data class MenuDto(
    override val id: Id<MenuDto>,
    val date: Date,
    val restaurant: Id<RestaurantDto>,

    val title: String,
    val substitution: String?,
    val price: Float, // TODO
    val counter: String?,
    val labels: Set<LabelDto>
): Dto<MenuDto>

data class LabelDto(
    override val id: String,
    val title: String
): Dto<LabelDto>
