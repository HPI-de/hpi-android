package de.hpi.android.core.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

fun <T> T?.asLiveData(): LiveData<T> = MutableLiveData<T>().also { it.value = this }

fun <T, R> LiveData<T>.map(func: (T) -> R): LiveData<R> = Transformations.map(this, func)

fun <T, R> LiveData<T>.switchMap(func: (T) -> LiveData<R>): LiveData<R> = Transformations.switchMap(this, func)
