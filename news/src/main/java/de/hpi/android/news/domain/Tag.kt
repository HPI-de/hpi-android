package de.hpi.android.news.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import de.hpi.android.news.data.TagDto

data class Tag(
    override val id: Id<TagDto>,
    val title: String,
    val articleCount: Int
) : Entity<Tag, TagDto>
