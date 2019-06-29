package de.hpi.android.news.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import de.hpi.cloud.news.v1test.GetArticleRequest
import de.hpi.cloud.news.v1test.ListArticlesRequest
import de.hpi.cloud.news.v1test.NewsServiceGrpc
import io.grpc.okhttp.OkHttpChannelBuilder
import io.reactivex.Observable
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset
import java.net.URL
import de.hpi.cloud.news.v1test.Article as GrpcArticle

object ArticleRepository : Repository<ArticleDto>() {
    private val channel = OkHttpChannelBuilder
        .forAddress("192.168.43.165", 50052)
        .usePlaintext()
        .build()
    private val service = NewsServiceGrpc.newBlockingStub(channel)

    override fun get(id: Id<ArticleDto>): Observable<Result<ArticleDto>> {
        return Observable.fromCallable {
            return@fromCallable try {
                service.getArticle(GetArticleRequest.newBuilder().setId(id).build()).let {
                    map(it).success()
                }
            } catch (e: Exception) {
                e.error()
            }
        }
    }

    override fun getAll(): Observable<Result<List<ArticleDto>>> {
        return Observable.fromCallable {
            return@fromCallable try {
                service.listArticles(ListArticlesRequest.getDefaultInstance()).articlesList
                    .map { article -> map(article) }
                    .success()
            } catch (e: Exception) {
                e.error()
            }
        }
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
