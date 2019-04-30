package de.hpi.android.news.domain

import de.hpi.android.core.domain.ObservableUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.news.data.Article
import de.hpi.android.news.data.ArticleRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object ListArticlesUseCase : ObservableUseCase<Unit, List<Article>>() {
    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Unit): Observable<Result<List<Article>>> {
        return ArticleRepository.getAll()
    }
}
