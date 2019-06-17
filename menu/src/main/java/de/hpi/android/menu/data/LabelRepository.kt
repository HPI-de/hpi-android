package de.hpi.android.menu.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import io.reactivex.Observable

object LabelRepository : Repository<LabelDto>() {
    private val labels = listOf(
        LabelDto("chicken", "Huhn"),
        LabelDto("beef", "Rind"),
        LabelDto("pork", "Schwein"),
        LabelDto("vegetarian", "Vegetarisch")
    )

    override fun get(id: Id<LabelDto>): Observable<Result<LabelDto>> {
        val restaurant = labels.firstOrNull { it.id == id }
        return Observable.just(
            restaurant?.success()
                ?: IllegalArgumentException("LabelDto with ID $id was not found").error()
        )
    }

    override fun getAll(): Observable<Result<List<LabelDto>>> {
        return Observable.just(Result.Success(labels))
    }
}
