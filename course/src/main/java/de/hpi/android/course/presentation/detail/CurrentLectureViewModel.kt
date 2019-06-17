package de.hpi.android.course.presentation.detail

import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.course.domain.GetCourseUseCase

class CurrentLectureViewModel : BaseViewModel() {
    private val courseResult = GetCourseUseCase("2019ss-pt2").asLiveData()
    val course = courseResult.data
}