package de.hpi.android.core.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.utils.checkAllMatched
import io.reactivex.Observable

sealed class Result<out T : Any> {
    data class Loading<out T : Any>(val data: T? = null) : Result<T>()
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Loading -> "Loading[data=$data]"
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }.checkAllMatched
    }
}


// region Constructors
fun <T : Any> loading() = Result.Loading<T>()

fun <T : Any> T?.loading() = Result.Loading(this)
fun <T : Any> T.success() = Result.Success(this)
fun Throwable.error() = Result.Error(this)
// endregion

val <T : Any> Result<T>.dataIfExists: T?
    get() = when (this) {
        is Result.Success -> data
        is Result.Loading -> data
        is Result.Error -> null
    }

fun <T : Any, R : Any> Result<T>.map(mapper: (T) -> R): Result<R> = when (this) {
    is Result.Success -> mapper(data).success()
    is Result.Loading -> data?.let { mapper(it) }.loading()
    is Result.Error -> this
}


fun <T : Any> List<Result<T>>.merge(): Result<List<T>> {
    val error = firstOrNull { it is Result.Error } as? Result.Error
    val data = map { it.dataIfExists }

    @Suppress("UNCHECKED_CAST")
    return when {
        error != null -> error
        data.any { it == null } -> Result.Loading()
        any { it is Result.Loading } -> (data as List<T>).loading()
        else -> map { (it as Result.Success).data }.success()
    }
}
fun <T : Any> Set<Result<T>>.merge(): Result<Set<T>> {
    val error = firstOrNull { it is Result.Error } as? Result.Error
    val data = map { it.dataIfExists }

    @Suppress("UNCHECKED_CAST")
    return when {
        error != null -> error
        data.any { it == null } -> Result.Loading()
        any { it is Result.Loading } -> (data as Set<T>).loading()
        else -> map { (it as Result.Success).data }.toSet().success()
    }
}


// region Common Errors
class ItemNotFoundException(id: Id<Any>) : Exception("Item with ID $id not found")
// endregion

// region Observable
fun <T : Any, R : Any> Observable<Result<T>>.mapResult(mapper: (T) -> Result<R>): Observable<Result<R>> {
    return map { res ->
        when (res) {
            is Result.Success -> mapper(res.data)
            is Result.Loading -> res.data?.let { mapper(it) } ?: loading<R>()
            is Result.Error -> res
        }
    }
}

fun <T : Any, R : Any> Observable<Result<T>>.flatMapResult(mapper: (T) -> Observable<Result<R>>): Observable<Result<R>> {
    return flatMap { res ->
        when (res) {
            is Result.Success -> mapper(res.data)
            is Result.Loading -> res.data?.let { mapper(it) } ?: Observable.just(loading<R>())
            is Result.Error -> Observable.just(res)
        }
    }
}
// endregion
