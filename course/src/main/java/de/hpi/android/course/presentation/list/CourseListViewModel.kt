package de.hpi.android.course.presentation.list

import de.hpi.android.core.domain.invoke
import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.course.domain.ListCoursesUseCase

class CourseListViewModel : BaseViewModel() {
    private val coursesResult = ListCoursesUseCase().asLiveData()
    val courses = coursesResult.data
}
