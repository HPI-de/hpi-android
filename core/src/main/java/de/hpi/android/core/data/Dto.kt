@file:Suppress("unused")

package de.hpi.android.core.data

interface Dto<D : Dto<D>> {
    val id: Id<D>
}

typealias Id<@Suppress("UNUSED_TYPEALIAS_PARAMETER") T> = String
