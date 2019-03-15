package de.hpi.android.news.domain

import de.hpi.android.core.domain.ObservableUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.news.data.ArticleEntity
import de.hpi.android.news.data.ArticleRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object ListArticlesUseCase : ObservableUseCase<Unit, List<ArticleEntity>>() {
    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Unit): Observable<Result<List<ArticleEntity>>> {
        return ArticleRepository.getAll()
    }
}
