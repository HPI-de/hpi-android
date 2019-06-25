package de.hpi.android.course.domain

import de.hpi.android.core.domain.*
import de.hpi.android.course.data.CourseSeriesDto
import de.hpi.android.course.data.CourseSeriesRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object ListCourseSeriesUseCase : ObservableUseCase<Unit, List<CourseSeries>>() {
    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Unit): Observable<Result<List<CourseSeries>>> {
        return CourseSeriesRepository.getAll().flatMapResult { courses ->
            Observable.combineLatest(courses.map {
                Observable.just(it.success() as Result<CourseSeriesDto>).mapResult { it.toCourseSeriesEntity() }
            }) { array ->
                @Suppress("UNCHECKED_CAST")
                array.map { it as Result<CourseSeries> }.merge()
            }
        }
    }
}

