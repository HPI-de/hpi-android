package de.hpi.android.news.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.ObservableUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.news.data.ArticleGrpcRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object GetArticleUseCase : ObservableUseCase<Id<Article>, Article>() {

    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Id<Article>): Observable<Result<Article>> {
        return ArticleGrpcRepository.get(params).toArticleEntity()
    }
}
