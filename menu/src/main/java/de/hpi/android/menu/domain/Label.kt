package de.hpi.android.menu.domain

import de.hpi.android.core.data.Id

data class Label(
    val id: Id<Label>,
    val title: String
)
