package de.hpi.android.news.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import io.reactivex.Observable

object ArticleRepository : Repository<ArticleEntity>() {
    override fun get(id: Id): Observable<Result<ArticleEntity>> {
        return NetworkNewsDataSource.getArticle(id)
    }

    override fun getAll(): Observable<Result<List<ArticleEntity>>> {
        TODO("not implemented")
    }
}
