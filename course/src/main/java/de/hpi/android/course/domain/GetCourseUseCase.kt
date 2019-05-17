package de.hpi.android.course.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.ObservableUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.course.data.Course
import de.hpi.android.course.data.CourseRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object GetCourseUseCase : ObservableUseCase<Id<Course>, Course>() {

    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Id<Course>): Observable<Result<Course>> {
        return CourseRepository.get(params)
    }
}