package de.hpi.android.news.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.NetworkDataSource
import de.hpi.android.core.domain.Result
import de.hpi.cloud.news.v1test.Article
import de.hpi.cloud.news.v1test.GetArticleRequest
import de.hpi.cloud.news.v1test.ListArticlesRequest
import de.hpi.cloud.news.v1test.NewsServiceGrpc
import io.grpc.ManagedChannelBuilder
import io.reactivex.Observable

object NetworkNewsDataSource : NetworkDataSource<NewsServiceGrpc.NewsServiceBlockingStub>() {
    override val stub: NewsServiceGrpc.NewsServiceBlockingStub by lazy {
        val channel = ManagedChannelBuilder
            .forAddress("35.198.174.212", 80)
            .usePlaintext()
            .build()
        NewsServiceGrpc.newBlockingStub(channel)
    }

    fun getArticle(id: Id): Observable<Result<ArticleEntity>> = clientCall({
        stub.getArticle(GetArticleRequest.newBuilder().setId(id).build())
    }, ::parseArticle)

    fun getArticles(): Observable<Result<List<ArticleEntity>>> = clientCallList({
        stub.listArticles(ListArticlesRequest.getDefaultInstance())
            .articlesList
    }) { it.map(::parseArticle) }

    private fun parseArticle(article: Article): ArticleEntity = ArticleEntity(
        id = article.id,
        title = article.title,
        body = article.content
    )
}
