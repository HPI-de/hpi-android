package de.hpi.android.myhpi.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id
import java.net.URL

data class InfoBitDto(
    override val id: Id<InfoBitDto>,
    val title: String,
    val text: String,
    val actions: List<ActionDto>
) : Dto<InfoBitDto>

sealed class ActionDto : Dto<ActionDto> {
    abstract val icon: URL
    abstract val title: String

    data class Link(
        override val id: Id<ActionDto>,
        override val icon: URL,
        override val title: String,
        val url: URL
    ) : ActionDto()

    data class Text(
        override val id: Id<ActionDto>,
        override val icon: URL,
        override val title: String,
        val content: String
    ) : ActionDto()
}
