package de.hpi.android.core.domain

import de.hpi.android.core.utils.checkAllMatched

sealed class Result<out T> {
    data class Loading<out T>(val data: T? = null) : Result<T>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Loading -> "Loading[data=$data]"
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }.checkAllMatched
    }
}
