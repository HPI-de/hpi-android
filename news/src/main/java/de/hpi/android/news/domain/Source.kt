package de.hpi.android.news.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import de.hpi.android.news.data.SourceDto
import java.net.URL

data class Source(
    override val id: Id<SourceDto>,
    val link: URL,
    val title: String
) : Entity<Source, SourceDto>
