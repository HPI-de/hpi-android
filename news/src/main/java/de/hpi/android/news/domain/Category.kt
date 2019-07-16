package de.hpi.android.news.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import de.hpi.android.news.data.CategoryDto

data class Category(
    override val id: Id<CategoryDto>,
    val title: String,
    val description: String? = null
) : Entity<Category, CategoryDto>
