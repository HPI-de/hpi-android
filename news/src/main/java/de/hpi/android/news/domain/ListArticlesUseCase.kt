package de.hpi.android.news.domain

import de.hpi.android.core.domain.*
import de.hpi.android.news.data.ArticleDto
import de.hpi.android.news.data.ArticleRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object ListArticlesUseCase : ObservableUseCase<Unit, List<Article>>() {
    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Unit): Observable<Result<List<Article>>> {
        return ArticleRepository.getAll().flatMapResult { articles ->
            Observable.combineLatest(articles.map { Observable.just(it.success() as Result<ArticleDto>).toArticleEntity() }) { array ->
                @Suppress("UNCHECKED_CAST")
                (array as Array<Result<Article>>).asList().merge()
            }
        }
    }
}
