package de.hpi.android.menu.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import de.hpi.android.menu.data.LabelDto

data class Label(
    override val id: Id<LabelDto>,
    val title: String
) : Entity<Label, LabelDto>
