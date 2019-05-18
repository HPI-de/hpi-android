package de.hpi.android.course.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import io.reactivex.Observable
import java.lang.IllegalArgumentException

object CourseSeriesRepository : Repository<CourseSeries>() {
    private val series = listOf(
        CourseSeries(
            id = "pt2",
            title = "Einführung in die Programmiertechnik II",
            shortTitle = "Programmiertechnik II",
            abbreviation = "PT 2",
            ects = 6,
            mandatory = true,
            language = "Deutsch"
        ),
        CourseSeries(
            id = "ma2",
            title = "Mathematik II",
            shortTitle = "Mathe II",
            abbreviation = "MA 2",
            ects = 6,
            mandatory = true,
            language = "Deutsch"
        ),
        CourseSeries(
            id = "www",
            title = "Internet- und WWW-Technologien",
            shortTitle = "WWW-Technologien",
            abbreviation = "WWW",
            ects = 6,
            mandatory = false,
            language = "Deutsch"
        )
    )

    override fun get(id: Id<CourseSeries>): Observable<Result<CourseSeries>> {
        val series = series.firstOrNull {it.id == id}
        return Observable.just(
            if (series == null) Result.Error(IllegalArgumentException("CourseSeries with ID $id was not found"))
        else Result.Success(series)
        )
    }

    //This is only a temporary workaround. With changes to the architecture, this method will be replaced.
    fun getDirectly(id: Id<CourseSeries>): CourseSeries? {
        return series.firstOrNull { it.id == id }
    }

    override fun getAll(): Observable<Result<List<CourseSeries>>> {
        return Observable.just(Result.Success(series))
    }
}