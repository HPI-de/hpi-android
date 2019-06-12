package de.hpi.android.course.presentation.detail

import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.course.domain.GetCourseUseCase

class CourseDetailViewModel : BaseViewModel() {
    private val courseResult = GetCourseUseCase("www").asLiveData()
    val course = courseResult.data
    /*private val seriesResult = courseResult.value
    val series = seriesResult.data*/

    fun onTest() {

    }
}