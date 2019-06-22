package de.hpi.android.course.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id
import de.hpi.android.course.domain.Course
import de.hpi.android.course.domain.CourseDetail
import de.hpi.android.course.domain.CourseSeries
import de.hpi.android.course.domain.Semester
import java.net.URI

data class CourseDto(
    override val id: Id<Course>,
    val series: Id<CourseSeries>,
    val semester: Id<Semester>,
    val lecturer: String,
    val assistants: Set<String> = emptySet(),
    val type: Set<Course.Type>,
    val website: URI? = null
) : Dto<CourseDto>

data class CourseSeriesDto(
    override val id: Id<CourseSeries>,
    val title: String,
    val shortTitle: String,
    val abbreviation: String,
    val ects: Int,
    val hoursPerWeek: Int,
    val mandatory: Boolean,
    val language: String
) : Dto<CourseSeriesDto>

data class SemesterDto(
    override val id: Id<Semester>,
    val term: String,
    val year: Int
) : Dto<SemesterDto>

data class CourseDetailDto(
    override val id: Id<CourseDetail>,
    val teleTask: URI?,
    val programs: Map<String, Set<String>>,
    val description: String,
    val requirements: String? = null,
    val learning: String? = null,
    val examination: String? = null,
    val dates: String? = null,
    val literature: String? = null
) : Dto<CourseDetailDto>
