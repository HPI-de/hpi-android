package de.hpi.android.news.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id
import java.net.URL

data class SourceDto(
    override val id: Id<SourceDto>,
    val link: URL,
    val title: String
) : Dto<SourceDto>
