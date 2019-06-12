package de.hpi.android.course.domain

import de.hpi.android.core.domain.*
import de.hpi.android.course.data.Course
import de.hpi.android.course.data.CourseDto
import de.hpi.android.course.data.CourseRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object ListCoursesUseCase : ObservableUseCase<Unit, List<Course>>() {
    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Unit): Observable<Result<List<Course>>> {
        return CourseRepository.getAll().flatMapResult {courses ->
            Observable.combineLatest(courses.map { Observable.just(it.success() as Result<CourseDto>).toCourseEntity() }) { array ->
                @Suppress("UNCHECKED_CAST")
                (array as Array<Result<Course>>).asList().merge()
            }
        }
    }
}