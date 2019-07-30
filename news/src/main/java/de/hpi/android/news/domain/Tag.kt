package de.hpi.android.news.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity

data class Tag(
    override val id: Id<Tag>,
    val title: String,
    val articleCount: Int
) : Entity<Tag>
