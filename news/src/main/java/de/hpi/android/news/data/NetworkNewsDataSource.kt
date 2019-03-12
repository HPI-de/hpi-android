package de.hpi.android.news.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.NetworkDataSource
import de.hpi.android.core.domain.Result
import de.hpi.cloud.news.v1test.GetArticleRequest
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
    }) {
        ArticleEntity(
            id = it.id,
            title = it.title,
            body = it.content
        )
    }
}
