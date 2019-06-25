package de.hpi.android.news.presentation.detail

import de.hpi.android.core.data.Id
import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.news.domain.GetArticleUseCase

class ArticleDetailViewModel : BaseViewModel() {
    private val articleResult = GetArticleUseCase(Id("1")).asLiveData()
    val article = articleResult.data

    fun onTest() {

    }
}
