package de.hpi.android.news.data

import androidx.room.*
import de.hpi.android.core.data.GrpcRepository
import de.hpi.android.core.data.Id
import de.hpi.android.core.data.RoomConverters
import de.hpi.android.core.data.RoomRepository
import de.hpi.android.core.domain.success
import de.hpi.android.core.presentation.base.appContext
import de.hpi.cloud.news.v1test.GetArticleRequest
import de.hpi.cloud.news.v1test.ListArticlesRequest
import de.hpi.cloud.news.v1test.NewsServiceGrpc
import io.reactivex.Observable
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset
import java.net.URL
import de.hpi.cloud.news.v1test.Article as GrpcArticle

object ArticleGrpcRepository : GrpcRepository<ArticleDto>(50061) {
    private val service = NewsServiceGrpc.newBlockingStub(channel)

    override fun get(id: Id<ArticleDto>) = grpcCall {
        service.getArticle(GetArticleRequest.newBuilder().setId(id).build()).let {
            map(it).success()
        }
    }

    override fun getAll() = grpcCall {
        service.listArticles(ListArticlesRequest.getDefaultInstance()).articlesList
            .map { article -> map(article) }
            .success()
    }

    private fun map(article: GrpcArticle) = ArticleDto(
        id = article.id,
        sourceId = article.sourceId,
        link = URL(article.link),
        title = article.title,
        date = LocalDateTime.ofEpochSecond(
            article.publishDate.seconds,
            article.publishDate.nanos,
            ZoneOffset.UTC
        ),
        authors = article.authorIdsList.toSet(),
        cover = URL(article.cover.source),
        coverAlt = article.cover.alt,
        teaser = article.teaser,
        content = article.content,
        categories = article.categoriesList.map { category -> category.id }.toSet(),
        tags = article.tagsList.map { tag -> tag.id }.toSet(),
        viewCount = article.viewCount
    )
}

@Database(entities = [ArticleDto::class], version = 1)
@TypeConverters(RoomConverters::class)
abstract class NewsDatabase : RoomDatabase() {
    companion object {
        val instance by lazy {
            Room.databaseBuilder(appContext, NewsDatabase::class.java, "news").build()
        }
    }

    abstract fun articles(): ArticleRoomRepository
}

@Dao
interface ArticleRoomRepository : RoomRepository<ArticleDto> {
    @Query("SELECT * FROM ArticleDto WHERE id = :id")
    override fun getRaw(id: Id<ArticleDto>): Observable<List<ArticleDto>>

    @Query("SELECT * FROM ArticleDto WHERE id = '1'")
    override fun getAllRaw(): Observable<List<ArticleDto>>
}
