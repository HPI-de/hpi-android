package de.hpi.android.core.data

import de.hpi.android.core.domain.Result
import io.reactivex.Completable
import io.reactivex.Observable

abstract class Repository<E : Entity<E>> {
    abstract fun get(id: Id<E>): Observable<Result<E>>
    abstract fun getAll(): Observable<Result<List<E>>>
}

abstract class MutableRepository<E : Entity<E>> : Repository<E>() {
    abstract fun create(entity: E): Observable<Id<E>>
    abstract fun update(entity: E): Completable
    abstract fun delete(id: Id<E>): Completable
}
