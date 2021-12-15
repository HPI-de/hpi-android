package de.hpi.android.core.data

import de.hpi.android.core.BuildConfig
import de.hpi.android.core.domain.*
import io.grpc.okhttp.OkHttpChannelBuilder
import io.reactivex.Completable
import io.reactivex.Observable

interface Repository<E : Dto<E>> {
    fun get(id: Id<E>): Observable<Result<E>>
    fun getAll(): Observable<Result<List<E>>>

    fun get(ids: Set<Id<E>>): Observable<Result<Set<E>>> {
        return if (ids.isEmpty()) Observable.just(emptySet<E>().success())
        else Observable.combineLatest(ids.map { get(it) }) { array ->
            @Suppress("UNCHECKED_CAST")
            array.map { it as Result<E> }.merge().map { it.toSet() }
        }
    }
}

abstract class GrpcRepository<E : Dto<E>>(port: Int) : Repository<E> {
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

interface RoomRepository<E : Dto<E>> : Repository<E> {
    companion object {
        private const val EMPTY_TIMEOUT = 300L
    }

    override fun get(id: Id<E>): Observable<Result<E>> {
        return getRaw(id).map {
            if (it.isEmpty())
                ItemNotFoundException(id).error()
            else
                it.first().success()
        }
        //        return Observable.timer(EMPTY_TIMEOUT, TimeUnit.MILLISECONDS)
        //            .ambWith(getRaw(id).firstOrError().map { 1L }.toObservable())
        //            .flatMap {
        //                var observable = getRaw(id).map<Result<E>> { it.success() }
        //                if (it == 1L)
        //                    observable = observable.startWith(ItemNotFoundException(id).error())
        //                observable.startWith(loading<E>())
        //            }
    }

    fun getRaw(id: Id<E>): Observable<List<E>>

    override fun getAll(): Observable<Result<List<E>>> {
        return getAllRaw()
            .map<Result<List<E>>> { it.success() }
            .startWith(loading<List<E>>())
    }

    fun getAllRaw(): Observable<List<E>>
}

interface MutableRepository<E : Dto<E>> : Repository<E> {
    abstract fun create(entity: E): Observable<Id<E>>
    abstract fun update(entity: E): Completable
    abstract fun delete(id: Id<E>): Completable
}
