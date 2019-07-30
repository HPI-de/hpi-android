package de.hpi.android.myhpi.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import java.net.URL

data class InfoBit(
    override val id: Id<InfoBit>,
    val title: String,
    val text: String,
    val actions: List<Action>
) : Entity<InfoBit>

sealed class Action : Entity<Action> {
    abstract val icon: URL
    abstract val title: String

    data class Link(
        override val id: Id<Action>,
        override val icon: URL,
        override val title: String,
        val url: URL
    ) : Action()

    data class Text(
        override val id: Id<Action>,
        override val icon: URL,
        override val title: String,
        val content: String
    ) : Action()
}