@file:Suppress("unused")

package de.hpi.android.core.data

interface Entity<E : Entity<E>> {
    val id: Id<E>
}

typealias Id<@Suppress("UNUSED_TYPEALIAS_PARAMETER") E> = String
