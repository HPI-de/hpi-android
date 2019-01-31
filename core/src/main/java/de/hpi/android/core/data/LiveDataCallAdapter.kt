package de.hpi.android.core.data

import androidx.lifecycle.LiveData
import de.hpi.android.core.domain.Result
import retrofit2.*
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

class LiveDataCallAdapter<R>(private val responseType: Type) : CallAdapter<R, LiveData<Result<R>>> {
    override fun responseType(): Type = responseType
    override fun adapt(call: Call<R>): LiveData<Result<R>> {
        return object : LiveData<Result<R>>() {
            private var started = AtomicBoolean(false)

            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    call.enqueue(object : Callback<R> {
                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            // TODO: Null safety
                            postValue(Result.Success(response.body()!!))
                        }

                        override fun onFailure(call: Call<R>, throwable: Throwable) {
                            postValue(Result.Error(throwable))
                        }
                    })
                }
            }
        }
    }

    class Factory : CallAdapter.Factory() {
        override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
            if (getRawType(returnType) != LiveData::class.java) return null

            val observableType = getParameterUpperBound(0, returnType as ParameterizedType)
//            val rawObservableType = getRawType(observableType)
//            if (rawObservableType != ApiResponse::class.java)
//                throw IllegalArgumentException("type must be a resource")
            if (observableType !is ParameterizedType)
                throw IllegalArgumentException("resource must be parameterized")
            val bodyType = getParameterUpperBound(0, observableType)
            return LiveDataCallAdapter<Any>(bodyType)
        }
    }
}
