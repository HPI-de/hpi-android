package de.hpi.android.core.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.Transformations
import de.hpi.android.core.domain.Result
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import timber.log.Timber

fun <T : Any> Observable<Result<T>>.asLiveData(): LiveData<Result<T>> {
    val flowable = onErrorReturn {
        Timber.w(it)
        Result.Error(it)
    }
        .toFlowable(BackpressureStrategy.BUFFER)
    return LiveDataReactiveStreams.fromPublisher(flowable)
}

val <T : Any> LiveData<Result<T>>.data: LiveData<T?>
    get() = map {
        when (it) {
            is Result.Success -> it.data
            is Result.Loading -> it.data
            is Result.Error -> null
        }.checkAllMatched
    }


fun <T, R> LiveData<T>.map(func: (T) -> R): LiveData<R> = Transformations.map(this, func)

fun <T, R> LiveData<T>.switchMap(func: (T) -> LiveData<R>): LiveData<R> = Transformations.switchMap(this, func)
