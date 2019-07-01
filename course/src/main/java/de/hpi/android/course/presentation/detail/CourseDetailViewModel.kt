package de.hpi.android.course.presentation.detail

import de.hpi.android.core.data.Id
import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.appendLine
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.core.utils.map
import de.hpi.android.course.data.CourseDetailDto
import de.hpi.android.course.data.CourseDto
import de.hpi.android.course.domain.GetCourseDetailUseCase
import de.hpi.android.course.domain.GetCourseUseCase

class CourseDetailViewModel : BaseViewModel() {
    private val courseId = Id<CourseDto>("2019ss-www") // TODO: use navigation arguments

    private val courseResult = GetCourseUseCase(courseId).asLiveData()
    val course = courseResult.data

    @Suppress("UNCHECKED_CAST")
    private val courseDetailResult = GetCourseDetailUseCase(courseId as Id<CourseDetailDto>).asLiveData()
    val courseDetail = courseDetailResult.data

    val assistants = course.map { it?.assistants?.joinToString() }
    val modules = courseDetail.map { courseDetail ->
        if (courseDetail == null) return@map null

        buildString {
            for ((program, moduleList) in courseDetail.modules) {
                appendLine(program)
                for (module in moduleList)
                    appendLine("\t\t$module")
            }
        }
    }
}
