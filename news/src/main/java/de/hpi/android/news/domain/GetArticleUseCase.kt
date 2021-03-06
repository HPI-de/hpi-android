package de.hpi.android.news.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.ObservableUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.news.data.ArticleDto
import de.hpi.android.news.data.ArticleRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object GetArticleUseCase : ObservableUseCase<Id<ArticleDto>, Article>() {

    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Id<ArticleDto>): Observable<Result<Article>> {
        return ArticleRepository.get(params).toArticleEntity()
    }
}
