package de.hpi.android.course.domain

import de.hpi.android.core.domain.ObservableUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.course.data.Course
import de.hpi.android.course.data.CourseRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object ListCoursesUseCase : ObservableUseCase<Unit, List<Course>>() {
    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Unit): Observable<Result<List<Course>>> {
        return CourseRepository.getAll()
    }
}