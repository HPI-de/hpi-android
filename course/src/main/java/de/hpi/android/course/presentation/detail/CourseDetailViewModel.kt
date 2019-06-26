package de.hpi.android.course.presentation.detail

import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.course.domain.GetCourseDetailUseCase
import de.hpi.android.course.domain.GetCourseUseCase

class CourseDetailViewModel : BaseViewModel() {
    private val courseId = "2019ss-www"
    private val courseDetailResult = GetCourseDetailUseCase(courseId).asLiveData()
    private val courseResult = GetCourseUseCase(courseId).asLiveData()      // get this from the parent activity
    val courseDetail = courseDetailResult.data
    val course = courseResult.data
}
