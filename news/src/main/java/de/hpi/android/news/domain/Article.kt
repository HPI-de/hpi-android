package de.hpi.android.news.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import org.threeten.bp.LocalDateTime
import java.net.URL

data class Article(
    override val id: Id<Article>,
    val source: Source,
    val link: URL,
    val title: String,
    val date: LocalDateTime,
    val authors: Set<String>,
    val cover: URL,
    val coverAlt: String? = null,
    val teaser: String,
    val content: String,
    val categories: Set<Category>,
    val tags: Set<Tag>,
    val viewCount: Int? = null
) : Entity<Article>

data class Comment(
    val id: String,
    val articleId: Id<Article>,
    val content: String,
    val authorName: String,
    val email: String,
    val website: String?
)
