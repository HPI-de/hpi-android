package de.hpi.android.course.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.ObservableUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.mapResult
import de.hpi.android.course.data.CourseDetailDto
import de.hpi.android.course.data.CourseDetailRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object GetCourseDetailUseCase : ObservableUseCase<Id<CourseDetailDto>, CourseDetail>() {
    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Id<CourseDetailDto>): Observable<Result<CourseDetail>> {
        return CourseDetailRepository.get(params).mapResult { it.toCourseDetailEntity() }
    }
}
