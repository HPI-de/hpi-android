package de.hpi.android.news.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id

data class TagDto(
    override val id: Id<TagDto>,
    val title: String,
    val articleCount: Int
) : Dto<TagDto>
