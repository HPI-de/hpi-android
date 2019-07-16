package de.hpi.android.course.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.ObservableUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.course.data.CourseDto
import de.hpi.android.course.data.CourseRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object GetCourseUseCase : ObservableUseCase<Id<CourseDto>, Course>() {
    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Id<CourseDto>): Observable<Result<Course>> {
        return CourseRepository.get(params).toCourseEntity()
    }
}
