package de.hpi.android.core.domain

import de.hpi.android.core.utils.Quadruple
import de.hpi.android.core.utils.Quintuple
import de.hpi.android.core.utils.toList
import io.reactivex.Observable

/**
 * This ugly method makes it easy to combine multiple [de.hpi.android.core.data.Dto]s required for mapping to an
 * [Entity]. You provide an [Observable] of a (usually) DTO and a factory to provide other required DTOs. This method
 * takes care of merging all [Result]s correctly and returns (1) the initial DTO and (2) the list of your provided
 * DTOs (in a Pair).
 *
 * Usually, you'll want to use [withRequired1], [withRequired2], [withRequired3] or [withRequired4] which provide a type
 * safe variant for a constant number of provided DTOs.
 */
@Suppress("UNCHECKED_CAST")
fun <T1 : Any, T2 : Any> Observable<Result<T1>>.withRequired(factory: (T1) -> List<Observable<Result<T2>>>): Observable<Result<Pair<T1, List<T2>>>> {
    fun dataToList(res: Result<T1>, t1: T1): Observable<Pair<Result<T1>, List<Result<T2>>?>> =
        Observable.combineLatest(factory(t1)) { res to it.map { it as Result<T2> }}

    return flatMap { t1 ->
        when (t1) {
            is Result.Success -> dataToList(t1, t1.data)
            is Result.Loading -> t1.data?.let { data -> dataToList(t1, data) } ?: Observable.just(t1 to null)
            is Result.Error -> Observable.just(t1 to null)
        }
    }.map { (t1, t2s) ->
        val t2error = t2s?.firstOrNull { it is Result.Error } as? Result.Error
        val t2data = t2s?.map { it.dataIfExists }
        when {
            t1 is Result.Error -> t1
            t2error != null -> t2error
            t1 is Result.Loading && t1.data != null && t2data?.all { it != null } == true ->
                (t1.data to (t2data as List<T2>)).loading()
            t1.dataIfExists == null || t2data?.any { it == null } != false -> loading<Pair<T1, List<T2>>>()
            t1 is Result.Success && t2s.any { it is Result.Loading } ->
                (t1.data to (t2s as List<Result.Loading<T2>>).map { it.data!! }).loading()
            t1 is Result.Success && t2s.all { it is Result.Success } ->
                (t1.data to (t2s as List<Result.Success<T2>>).map { it.data }).success()
            else -> throw AssertionError("This branch shouldn't occur")
        }
    }
}

/**
 * See [withRequired] for more information.
 */
fun <T1 : Any, T2 : Any> Observable<Result<T1>>.withRequired1(
    factory: (T1) -> Observable<Result<T2>>
): Observable<Result<Pair<T1, T2>>> {
    return withRequired { listOf(factory(it)) }
        .mapResult { (t1, t2s) -> (t1 to t2s.first()).success() }
}

/**
 * See [withRequired] for more information.
 */
@Suppress("UNCHECKED_CAST")
fun <T1 : Any, T2 : Any, T3 : Any> Observable<Result<T1>>.withRequired2(
    factory: (T1) -> Pair<Observable<Result<T2>>, Observable<Result<T3>>>
): Observable<Result<Triple<T1, T2, T3>>> {
    return withRequired { (factory(it) as Pair<Observable<Result<Any>>, Observable<Result<Any>>>).toList() }
        .mapResult { (t1, t2s) -> Triple(t1, t2s[0] as T2, t2s[1] as T3).success() }
}

/**
 * See [withRequired] for more information.
 */
@Suppress("UNCHECKED_CAST")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any> Observable<Result<T1>>.withRequired3(
    factory: (T1) -> Triple<Observable<Result<T2>>, Observable<Result<T3>>, Observable<Result<T4>>>
): Observable<Result<Quadruple<T1, T2, T3, T4>>> {
    return withRequired { (factory(it) as Triple<Observable<Result<Any>>, Observable<Result<Any>>, Observable<Result<Any>>>).toList() }
        .mapResult { (t1, t2s) -> Quadruple(t1, t2s[0] as T2, t2s[1] as T3, t2s[2] as T4).success() }
}

/**
 * See [withRequired] for more information.
 */
@Suppress("UNCHECKED_CAST")
fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any> Observable<Result<T1>>.withRequired4(
    factory: (T1) -> Quadruple<Observable<Result<T2>>, Observable<Result<T3>>, Observable<Result<T4>>, Observable<Result<T5>>>
): Observable<Result<Quintuple<T1, T2, T3, T4, T5>>> {
    return withRequired { (factory(it) as Quadruple<Observable<Result<Any>>, Observable<Result<Any>>, Observable<Result<Any>>, Observable<Result<Any>>>).toList() }
        .mapResult { (t1, t2s) -> Quintuple(t1, t2s[0] as T2, t2s[1] as T3, t2s[2] as T4, t2s[3] as T5).success() }
}
