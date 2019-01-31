package de.hpi.android.core.domain

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase<in P, R> : CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO


    operator fun invoke(parameters: P, result: MutableLiveData<Result<R>>) {
        try {
            launch {
                result.postValue(
                    try {
                        Result.Success(execute(parameters))
                    } catch (e: Exception) {
                        Timber.e(e)
                        Result.Error(e)
                    }
                )
            }
        } catch (e: Exception) {
            Timber.d(e)
            result.postValue(Result.Error(e))
        }
    }

    operator fun invoke(parameters: P): MutableLiveData<Result<R>> {
        return MutableLiveData<Result<R>>().also {
            this(parameters, it)
        }
    }


    fun executeNow(parameters: P): Result<R> = try {
        Result.Success(execute(parameters))
    } catch (e: Exception) {
        Result.Error(e)
    }

    @Throws(RuntimeException::class)
    protected abstract fun execute(parameters: P): R
}

operator fun <R> BaseUseCase<Unit, R>.invoke() = this(Unit)
operator fun <R> BaseUseCase<Unit, R>.invoke(result: MutableLiveData<Result<R>>) = this(Unit, result)
