package de.hpi.android.news.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id
import org.threeten.bp.LocalDateTime
import java.net.URL

@Entity
data class ArticleDto(
    @PrimaryKey override val id: Id<ArticleDto>,
    val sourceId: Id<SourceDto>,
    val link: URL,
    val title: String,
    val date: LocalDateTime,
    @Ignore val authors: Set<String>,
    val cover: URL,
    val coverAlt: String? = null,
    val teaser: String,
    val content: String,
    @Ignore val categories: Set<Id<CategoryDto>>,
    @Ignore val tags: Set<Id<TagDto>>,
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
