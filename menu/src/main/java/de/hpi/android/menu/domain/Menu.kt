package de.hpi.android.menu.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import org.threeten.bp.LocalDate
import java.util.*

data class Menu(
    override val id: Id<Menu>,
    val date: LocalDate,
    val restaurant: Restaurant,
    val title: String,
    val substitution: String?,
    val price: Float, // TODO: Implement better data type for prices.
    val counter: String?,
    val labels: Set<Label>
) : Entity<Menu>
