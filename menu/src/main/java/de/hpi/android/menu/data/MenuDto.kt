package de.hpi.android.menu.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id
import org.threeten.bp.LocalDate

data class MenuDto(
    override val id: Id<MenuDto>,
    val date: LocalDate,
    val restaurant: Id<RestaurantDto>,
    val title: String,
    val substitution: String?,
    val price: Float, // TODO
    val counter: String?,
    val labels: Set<Id<LabelDto>>
): Dto<MenuDto>
