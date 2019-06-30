package de.hpi.android.news.presentation.detail

import de.hpi.android.core.data.Id
import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.presentation.utils.ChipData
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.core.utils.map
import de.hpi.android.news.data.ArticleDto
import de.hpi.android.news.domain.GetArticleUseCase

class ArticleDetailViewModel(val id: Id<ArticleDto>) : BaseViewModel() {
    private val articleResult = GetArticleUseCase(id).asLiveData()
    val article = articleResult.data

    val authorChips = article.map { article ->
        article?.authors.orEmpty().map {
            ChipData(it, it)
        }
    }
    val categoryChips = article.map { article ->
        article?.categories.orEmpty().map {
            ChipData(it.id.value, it.title)
        }
    }
    val tagChips = article.map { article ->
        article?.tags.orEmpty().map {
            ChipData(it.id.value, it.title)
        }
    }
}
