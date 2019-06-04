package de.hpi.android.core.utils

/**
 * Helper to force a when statement to assert all options are matched in a when statement.
 *
 * By default, Kotlin doesn't care if all branches are handled in a when statement. However, if you
 * use the when statement as an expression (with a value) it will force all cases to be handled.
 *
 * This helper is to make a lightweight way to say you meant to match all of them.
 *
 * Usage:
 *
 * ```
 * when(sealedObject) {
 *     is OneType -> //
 *     is AnotherType -> //
 * }.checkAllMatched
 * ```
 *
 * Source: https://github.com/google/iosched/blob/master/shared/src/main/java/com/google/samples/apps/iosched/shared/util/Extensions.kt
 */
val <T> T.checkAllMatched: T
    get() = this


fun <T1, T2> Pair<T1?, T2?>.takeIfNotNull(): Pair<T1, T2>? {
    val (t1, t2) = this
    t1 ?: return null
    t2 ?: return null
    return t1 to t2
}
