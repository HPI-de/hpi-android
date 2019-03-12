package de.hpi.android.core.domain

import de.hpi.android.core.utils.checkAllMatched

sealed class Result<out R> {
    data class Loading<out R>(val data: R? = null) : Result<R>()
    data class Success<out R>(val data: R) : Result<R>()
    data class Error(val exception: Throwable) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Loading -> "Loading[data=$data]"
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }.checkAllMatched
    }
}
