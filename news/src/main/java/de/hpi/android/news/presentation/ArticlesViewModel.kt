package de.hpi.android.news.presentation

import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.news.domain.GetArticleUseCase

class ArticlesViewModel : BaseViewModel() {
    private val articleResult = GetArticleUseCase("1").asLiveData()
    val article = articleResult.data
}
