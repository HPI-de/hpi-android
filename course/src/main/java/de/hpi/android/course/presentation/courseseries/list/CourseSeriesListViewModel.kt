package de.hpi.android.course.presentation.courseseries.list

import de.hpi.android.core.domain.invoke
import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.course.domain.ListCourseSeriesUseCase

class CourseSeriesListViewModel : BaseViewModel() {
    private val courseSeriesResult = ListCourseSeriesUseCase().asLiveData()
    val courseSeries = courseSeriesResult.data
}