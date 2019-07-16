package de.hpi.android.menu.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import de.hpi.android.menu.data.RestaurantDto

data class Restaurant(
    override val id: Id<RestaurantDto>,
    val title: String
) : Entity<Restaurant, RestaurantDto>
