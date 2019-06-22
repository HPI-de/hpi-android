package de.hpi.android.course.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import de.hpi.android.course.domain.CourseSeries
import io.reactivex.Observable
import kotlin.IllegalArgumentException

object CourseSeriesRepository : Repository<CourseSeriesDto>() {
    private val series = listOf(
        CourseSeriesDto(
            id = "pt2",
            title = "Einführung in die Programmiertechnik II",
            shortTitle = "Programmiertechnik II",
            abbreviation = "PT 2",
            ects = 6,
            hoursPerWeek = 4,
            mandatory = true,
            language = "Deutsch"
        ),
        CourseSeriesDto(
            id = "ma2",
            title = "Mathematik II",
            shortTitle = "Mathe II",
            abbreviation = "MA 2",
            ects = 6,
            hoursPerWeek = 4,
            mandatory = true,
            language = "Deutsch"
        ),
        CourseSeriesDto(
            id = "www",
            title = "Internet- und WWW-Technologien",
            shortTitle = "Internet und WWW",
            abbreviation = "WWW",
            ects = 6,
            hoursPerWeek = 4,
            mandatory = false,
            language = "Deutsch"
        )
    )

    override fun get(id: Id<CourseSeries>): Observable<Result<CourseSeriesDto>> {
        val series = series.firstOrNull { it.id == id }
        return Observable.just(
            series?.success()
                ?: IllegalArgumentException("Course Series with ID $id could not be found").error()
        )
    }

    override fun getAll(): Observable<Result<List<CourseSeriesDto>>> {
        return Observable.just(Result.Success(series))
    }
}
