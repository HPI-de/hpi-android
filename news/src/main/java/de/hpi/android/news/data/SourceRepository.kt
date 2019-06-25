package de.hpi.android.news.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import io.reactivex.Observable
import java.net.URL

object SourceRepository : Repository<SourceDto>() {
    private val sources = listOf(
        SourceDto(
            id = Id("hpi"),
            link = URL("https://hpi.de/medien/presseinformationen/news.html"),
            title = "HPI News"
        ),
        SourceDto(
            id = Id("hpi-mgzn"),
            link = URL("https://hpimgzn.de/"),
            title = "HPImgzn"
        )
    )

    override fun get(id: Id<SourceDto>): Observable<Result<SourceDto>> {
        val source = sources.firstOrNull { it.id == id }
        return Observable.just(
            source?.success()
                ?: IllegalArgumentException("Source with ID $id was not found").error()
        )
    }

    override fun getAll(): Observable<Result<List<SourceDto>>> {
        return Observable.just(Result.Success(sources))
    }
}
