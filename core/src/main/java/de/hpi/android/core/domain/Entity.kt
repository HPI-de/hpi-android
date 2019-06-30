@file:Suppress("unused")

package de.hpi.android.core.domain

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id

interface Entity<E : Entity<E, D>, D : Dto<D>> {
    val id: Id<D>
}
