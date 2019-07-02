package de.hpi.android.menu.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import de.hpi.android.menu.data.MenuDto
import org.threeten.bp.LocalDate

data class Menu(
    override val id: Id<MenuDto>,
    val date: LocalDate,
    val restaurant: Restaurant,
    val title: String,
    val substitution: String?,
    val price: Float, // TODO: Implement better data type for prices.
    val counter: String?,
    val labels: Set<Label>
) : Entity<Menu, MenuDto>
