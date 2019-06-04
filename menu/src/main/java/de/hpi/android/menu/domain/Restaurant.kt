package de.hpi.android.menu.domain

import de.hpi.android.core.data.Id

data class Restaurant(
    val id: Id<Restaurant>,
    val title: String
)
