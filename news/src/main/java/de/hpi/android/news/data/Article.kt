package de.hpi.android.news.data

import de.hpi.android.core.data.Entity
import de.hpi.android.core.data.Id
import org.threeten.bp.LocalDateTime
import java.net.URL

data class Article(
    override val id: Id<Article>,
    val sourceId: Id<Source>,
    val link: URL,
    val title: String,
    val authors: Set<String>,
    val date: LocalDateTime,
    val teaser: String,
    val content: String,
    val categories: Set<Id<Category>>,
    val tags: Set<Id<Tag>>,
    val cover: URL,
    val coverCaption: String? = null,
    val viewCount: Int? = null
) : Entity<Article>

data class Source(
    override val id: Id<Source>,
    val title: String,
    val link: URL
) : Entity<Source>

data class Category(
    override val id: Id<Category>,
    val title: String,
    val description: String
) : Entity<Category>

data class Tag(
    override val id: Id<Tag>,
    val title: String,
    val articleCount: Int
) : Entity<Tag>

data class Comment(
    val id: String,
    val articleId: Id<Article>,
    val content: String,
    val authorName: String,
    val email: String,
    val website: String?
)
