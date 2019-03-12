package de.hpi.android.news.data

import de.hpi.android.core.data.Entity
import de.hpi.android.core.data.Id

data class ArticleEntity(
    override val id: Id,
    val body: String,
    val title: String
) : Entity
