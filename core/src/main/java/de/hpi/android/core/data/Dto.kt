@file:Suppress("unused")

package de.hpi.android.core.data

interface Dto<D : Dto<D>> {
    val id: Id<D>
}

inline class Id<D : Dto<D>>(val value: String)
