package de.hpi.android.news.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import io.reactivex.Observable

object TagRepository : Repository<TagDto>() {
    private val tags = listOf(
        TagDto(
            id = "essen",
            title = "Essen",
            articleCount = 1
        ),
        TagDto(
            id = "nachhaltigkeit",
            title = "Nachhaltigkeit",
            articleCount = 3
        ),
        TagDto(
            id = "nachhaltigkeitsklub",
            title = "Nachhaltigkeitsklub",
            articleCount = 5
        ),
        TagDto(
            id = "selbstgemacht",
            title = "selbstgemacht",
            articleCount = 2
        ),
        TagDto(
            id = "workshop",
            title = "Workshop",
            articleCount = 8
        )
    )

    override fun get(id: Id<TagDto>): Observable<Result<TagDto>> {
        val tag = tags.firstOrNull { it.id == id }
        return Observable.just(
            tag?.success()
                ?: IllegalArgumentException("Tag with ID $id was not found").error()
        )
    }

    override fun getAll(): Observable<Result<List<TagDto>>> {
        return Observable.just(Result.Success(tags))
    }
}
