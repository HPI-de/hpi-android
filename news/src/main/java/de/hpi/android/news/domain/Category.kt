package de.hpi.android.news.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity

data class Category(
    override val id: Id<Category>,
    val title: String,
    val description: String? = null
) : Entity<Category>
