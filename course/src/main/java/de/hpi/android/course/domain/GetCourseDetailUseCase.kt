package de.hpi.android.course.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.ObservableUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.mapResult
import de.hpi.android.course.data.CourseDetailRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*

object GetCourseDetailUseCase : ObservableUseCase<Id<CourseDetail>, CourseDetail>() {
    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Id<CourseDetail>): Observable<Result<CourseDetail>> {
        return CourseDetailRepository.get(params).mapResult { it.toCourseDetailEntity() }
    }
}
