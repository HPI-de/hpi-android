package de.hpi.android.core.data

import androidx.lifecycle.LiveData
import de.hpi.android.core.domain.Result

abstract class Repository<E : Entity> {
    abstract fun get(id: Id): LiveData<Result<E>>
    abstract fun getAll(): LiveData<Result<List<E>>>
}

abstract class MutableRepository<E : Entity> : Repository<E>() {
    abstract fun create(entity: E)
    abstract fun update(entity: E)
    abstract fun delete(id: Id)
}
