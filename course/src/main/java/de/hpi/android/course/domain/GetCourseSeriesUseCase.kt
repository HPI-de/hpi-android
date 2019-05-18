package de.hpi.android.course.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.ObservableUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.course.data.CourseSeries
import de.hpi.android.course.data.CourseSeriesRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object GetCourseSeriesUseCase : ObservableUseCase<Id<CourseSeries>, CourseSeries>() {

    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Id<CourseSeries>): Observable<Result<CourseSeries>> {
        return CourseSeriesRepository.get(params)
    }
}