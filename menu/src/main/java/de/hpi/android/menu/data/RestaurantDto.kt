package de.hpi.android.menu.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id

data class RestaurantDto(
    override val id: Id<RestaurantDto>,
    val title: String
): Dto<RestaurantDto>
