package de.hpi.android.resources.data

import androidx.lifecycle.LiveData
import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result

object PostRepository : Repository<Post>() {
    override fun get(id: Id): LiveData<Result<Post>> {
        return NetworkPostDataSource.api.getPost(id)
    }

    override fun getAll(): LiveData<Result<List<Post>>> {
        TODO("not implemented")
    }
}
