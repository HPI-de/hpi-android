package de.hpi.android.resources.data

import de.hpi.android.core.data.Entity
import de.hpi.android.core.data.Id

data class Post(
    override val id: Id,
    val body: String,
    val title: String
) : Entity
