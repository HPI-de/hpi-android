package de.hpi.android.course.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id
import de.hpi.android.course.domain.Course
import java.net.URI

data class CourseDto(
    override val id: Id<CourseDto>,
    val series: Id<CourseSeriesDto>,
    val semester: Id<SemesterDto>,
    val lecturer: String,
    val assistants: Set<String> = emptySet(),
    val description: String,
    val type: Set<Course.Type>,
    val website: URI? = null
) : Dto<CourseDto>

data class CourseSeriesDto(
    override val id: Id<CourseSeriesDto>,
    val title: String,
    val shortTitle: String,
    val abbreviation: String,
    val ects: Int,
    val mandatory: Boolean,
    val language: String
) : Dto<CourseSeriesDto>

data class SemesterDto(
    override val id: Id<SemesterDto>,
    val term: String,
    val year: Int
) : Dto<SemesterDto>
