package de.hpi.android.news.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id

data class CategoryDto(
    override val id: Id<CategoryDto>,
    val title: String,
    val description: String? = null
) : Dto<CategoryDto>
