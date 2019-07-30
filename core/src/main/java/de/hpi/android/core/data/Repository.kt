package de.hpi.android.core.data

import de.hpi.android.core.BuildConfig
import de.hpi.android.core.domain.*
import io.grpc.okhttp.OkHttpChannelBuilder
import io.reactivex.Completable
import io.reactivex.Observable

abstract class Repository<E : Dto<E>> {
    abstract fun get(id: Id<E>): Observable<Result<E>>
    abstract fun getAll(): Observable<Result<List<E>>>

    fun get(ids: Set<Id<E>>): Observable<Result<Set<E>>> {
        return if (ids.isEmpty()) Observable.just(emptySet<E>().success())
        else Observable.combineLatest(ids.map { get(it) }) { array ->
            @Suppress("UNCHECKED_CAST")
            array.map { it as Result<E> }.merge().map { it.toSet() }
        }
    }
}

abstract class GrpcRepository<E : Dto<E>>(port: Int) : Repository<E>() {
    protected val channel = OkHttpChannelBuilder
        .forAddress(BuildConfig.hpiCloudUrl, port)
        .usePlaintext()
        .build()

    protected fun <T : Any> grpcCall(call: () -> Result<T>): Observable<Result<T>> {
        return Observable.fromCallable {
            return@fromCallable try {
                call()
            } catch (e: Exception) {
                e.error()
            }
        }
    }
}

abstract class MutableRepository<E : Dto<E>> : Repository<E>() {
    abstract fun create(entity: E): Observable<Id<E>>
    abstract fun update(entity: E): Completable
    abstract fun delete(id: Id<E>): Completable
}
