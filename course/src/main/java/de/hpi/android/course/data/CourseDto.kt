package de.hpi.android.course.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id
import de.hpi.android.course.domain.CourseSeries
import java.net.URI

data class CourseDto(
    override val id: Id<CourseDto>,
    val series: Id<CourseSeriesDto>,
    val semester: Id<SemesterDto>,
    val lecturer: String,
    val assistants: Set<String> = emptySet(),
    val website: URI? = null
) : Dto<CourseDto>

data class CourseDetailDto(
    override val id: Id<CourseDetailDto>,
    val teleTask: URI?,
    val programs: Map<String, Set<String>>,
    val description: String,
    val requirements: String? = null,
    val learning: String? = null,
    val examination: String? = null,
    val dates: String? = null,
    val literature: String? = null
) : Dto<CourseDetailDto>

data class CourseSeriesDto(
    override val id: Id<CourseSeriesDto>,
    val title: String,
    val shortTitle: String,
    val abbreviation: String,
    val ects: Int,
    val hoursPerWeek: Int,
    val mandatory: Boolean,
    val language: String,
    val type: Set<CourseSeries.Type>
) : Dto<CourseSeriesDto>

data class SemesterDto(
    override val id: Id<SemesterDto>,
    val term: String,
    val year: Int
) : Dto<SemesterDto>
