package de.hpi.android.news.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id
import org.threeten.bp.LocalDateTime
import java.net.URL

data class ArticleDto(
    override val id: Id<ArticleDto>,
    val sourceId: Id<SourceDto>,
    val link: URL,
    val title: String,
    val authors: Set<String>,
    val date: LocalDateTime,
    val teaser: String,
    val content: String,
    val categories: Set<Id<CategoryDto>>,
    val tags: Set<Id<TagDto>>,
    val cover: URL,
    val coverCaption: String? = null,
    val viewCount: Int? = null
) : Dto<ArticleDto>

data class CommentDto(
    val id: String,
    val articleId: Id<ArticleDto>,
    val content: String,
    val authorName: String,
    val email: String,
    val website: String?
)
