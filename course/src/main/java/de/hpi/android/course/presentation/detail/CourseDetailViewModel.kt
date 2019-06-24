package de.hpi.android.course.presentation.detail

import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.course.domain.GetCourseDetailUseCase

class CourseDetailViewModel : BaseViewModel() {
    private val courseDetailId = "2019ss-www"
    private val courseDetailResult = GetCourseDetailUseCase(courseDetailId).asLiveData()
    val courseDetail = courseDetailResult.data
}
