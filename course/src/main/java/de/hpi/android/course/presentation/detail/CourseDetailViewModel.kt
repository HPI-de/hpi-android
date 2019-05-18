package de.hpi.android.course.presentation.detail

import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.course.domain.GetCourseSeriesUseCase
import de.hpi.android.course.domain.GetCourseUseCase

class CourseDetailViewModel : BaseViewModel() {
    private val courseResult = GetCourseUseCase("1").asLiveData()
    val course = courseResult.data
    private val seriesResult = GetCourseSeriesUseCase("1").asLiveData()
    val series = seriesResult.data

    fun onTest() {

    }
}