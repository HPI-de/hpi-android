package de.hpi.android.core.data

import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.map
import de.hpi.android.core.domain.merge
import de.hpi.android.core.domain.success
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

abstract class MutableRepository<E : Dto<E>> : Repository<E>() {
    abstract fun create(entity: E): Observable<Id<E>>
    abstract fun update(entity: E): Completable
    abstract fun delete(id: Id<E>): Completable
}
