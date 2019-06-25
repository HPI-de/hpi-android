package de.hpi.android.menu.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity

data class Restaurant(
    override val id: Id<Restaurant>,
    val title: String
) : Entity<Restaurant>
