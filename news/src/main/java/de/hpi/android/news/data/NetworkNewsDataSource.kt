package de.hpi.android.news.data

import android.text.format.DateFormat
import de.hpi.android.core.data.Id
import de.hpi.android.core.data.NetworkDataSource
import de.hpi.android.core.domain.Result
import de.hpi.cloud.news.News
import de.hpi.cloud.news.v1test.Article
import de.hpi.cloud.news.v1test.GetArticleRequest
import de.hpi.cloud.news.v1test.ListArticlesRequest
import de.hpi.cloud.news.v1test.NewsServiceGrpc
import io.grpc.ManagedChannelBuilder
import io.reactivex.Observable

object NetworkNewsDataSource : NetworkDataSource<NewsServiceGrpc.NewsServiceBlockingStub>() {
    override val stub: NewsServiceGrpc.NewsServiceBlockingStub by lazy {
        val channel = ManagedChannelBuilder
            .forAddress("192.168.56.1", 8000)
            .usePlaintext()
            .build()
        NewsServiceGrpc.newBlockingStub(channel)
    }

//    News.Builder(null, null,null).build().newsService().listArticles().execute()
    fun getArticle(id: Id): Observable<Result<ArticleEntity>>  = clientCall({
        stub.getArticle(GetArticleRequest.newBuilder().setId(id).build())
    }, ::parseArticle)

    fun getArticles(): Observable<Result<List<ArticleEntity>>> = clientCallList({
        stub.listArticles(ListArticlesRequest.getDefaultInstance())
            .articlesList
    }) { it.map(::parseArticle) }
    //    fun getArticles(): Observable<Result<List<ArticleEntity>>> = Observable.fromCallable {
    //        stub.listArticles(ListArticlesRequest.getDefaultInstance())
    //    }
    //        .map<Result<List<ArticleEntity>>> {
    //            val list = it.articlesList
    //            Timber.d(list.joinToString())
    //            Result.Success(list.map(::parseArticle))
    //        }
    //        .startWith(Result.Loading())

    private fun parseArticle(article: Article): ArticleEntity = ArticleEntity(
        id = article.id,
        title = article.title,
        body = article.content
    )
}
