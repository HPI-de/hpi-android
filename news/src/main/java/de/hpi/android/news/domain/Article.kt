package de.hpi.android.news.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import de.hpi.android.news.data.ArticleDto
import org.threeten.bp.LocalDateTime
import java.net.URL

data class Article(
    override val id: Id<ArticleDto>,
    val source: Source,
    val link: URL,
    val title: String,
    val authors: Set<String>,
    val date: LocalDateTime,
    val teaser: String,
    val content: String,
    val categories: Set<Category>,
    val tags: Set<Tag>,
    val cover: URL,
    val coverCaption: String? = null,
    val viewCount: Int? = null
) : Entity<Article, ArticleDto>

data class Comment(
    val id: String,
    val articleId: Id<ArticleDto>,
    val content: String,
    val authorName: String,
    val email: String,
    val website: String?
)
