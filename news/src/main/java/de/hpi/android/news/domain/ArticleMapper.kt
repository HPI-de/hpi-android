package de.hpi.android.news.domain

import de.hpi.android.core.domain.*
import de.hpi.android.news.data.*
import io.reactivex.Observable

fun SourceDto.toSourceEntity(): Result<Source> {
    return Source(id, link, title).success()
}

fun CategoryDto.toCategoryEntity(): Result<Category> {
    return Category(id, title, description).success()
}

fun TagDto.toTagEntity(): Result<Tag> {
    return Tag(id, title, articleCount).success()
}

fun Observable<Result<ArticleDto>>.toArticleEntity(): Observable<Result<Article>> {
    fun ArticleDto.entity(source: Source, categories: Set<Category>, tags: Set<Tag>): Article {
        return Article(
            id = id,
            source = source,
            link = link,
            title = title,
            authors = authors,
            date = date,
            teaser = teaser,
            content = content,
            categories = categories,
            tags = tags,
            cover = cover,
            coverCaption = coverCaption,
            viewCount = viewCount
        )
    }

    return withRequired3 { article ->
        Triple(
            SourceRepository.get(article.sourceId).mapResult { it.toSourceEntity() },
            CategoryRepository.get(article.categories).mapResult { categories ->
                categories.map { it.toCategoryEntity() }.toSet().merge()
            },
            TagRepository.get(article.tags).mapResult { tags ->
                tags.map { it.toTagEntity() }.toSet().merge()
            }
        )
    }
        .mapResult { (article, source, categories, tags) ->
            article.entity(source, categories, tags).success()
        }
}
