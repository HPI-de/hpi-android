package de.hpi.android.course.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import io.reactivex.Observable

object SemesterRepository : Repository<SemesterDto>() {
    private val semesters = listOf(
        SemesterDto(
            id = Id("2018ws"),
            term = "winter",
            year = 2018
        ),
        SemesterDto(
            id = Id("2019ss"),
            term = "summer",
            year = 2019
        )
    )

    override fun get(id: Id<SemesterDto>): Observable<Result<SemesterDto>> {
        val semester = semesters.firstOrNull { it.id == id }
        return Observable.just(
            semester?.success()
                ?: IllegalArgumentException("Semeseter with ID $id could not be found").error()
        )
    }

    override fun getAll(): Observable<Result<List<SemesterDto>>> {
        return Observable.just(Result.Success(semesters))
    }
}
