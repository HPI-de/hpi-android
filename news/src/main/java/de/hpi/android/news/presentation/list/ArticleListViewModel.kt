package de.hpi.android.news.presentation.list

import de.hpi.android.core.domain.invoke
import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.news.domain.ListArticlesUseCase

class ArticleListViewModel : BaseViewModel() {
    private val articlesResult = ListArticlesUseCase().asLiveData()
    val articles = articlesResult.data
}
