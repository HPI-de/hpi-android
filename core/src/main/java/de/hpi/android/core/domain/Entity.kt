@file:Suppress("unused")

package de.hpi.android.core.domain

import de.hpi.android.core.data.Id

interface Entity<E : Entity<E>> {
    val id: Id<E>
}
