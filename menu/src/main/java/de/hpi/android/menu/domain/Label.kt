package de.hpi.android.menu.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity

data class Label(
    override val id: Id<Label>,
    val title: String
) : Entity<Label>
