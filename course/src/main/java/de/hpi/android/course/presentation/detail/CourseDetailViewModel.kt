package de.hpi.android.course.presentation.detail

import androidx.lifecycle.MutableLiveData
import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.core.utils.map
import de.hpi.android.course.domain.GetCourseDetailUseCase
import de.hpi.android.course.domain.GetCourseUseCase

class CourseDetailViewModel : BaseViewModel() {
    private val courseId = "2019ss-www"     // still hardcoded
    private val courseDetailResult = GetCourseDetailUseCase(courseId).asLiveData()
    private val courseResult = GetCourseUseCase(courseId).asLiveData()      // get this from the parent activity?
    val courseDetail = courseDetailResult.data
    val course = courseResult.data
    val assistants = course.map { it?.assistants?.joinToString() }
    val programsModules = courseDetail.map { courseDetail ->
        val lines = mutableSetOf<String>()
        courseDetail?.let {
            for ((program, moduleList) in courseDetail.programs) {
                lines.add(program)
                for (module in moduleList) {
                    lines.add("\t\t" + module)
                }
            }
        }
        lines.joinToString(separator = "\n")
    }
    val generalInformation: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}
