package de.hpi.android.course.data

import de.hpi.android.core.data.Dto
import de.hpi.android.core.data.Id
import java.net.URI

data class CourseDto(
    override val id: Id<Course>,
    val series: Id<CourseSeries>,
    val semester: Id<Semester>,
    val lecturer: String,
    val assistants: Set<String> = emptySet(),
    val description: String,
    val type: Set<Course.Type>,
    val website: URI? = null
) : Dto<CourseDto>

data class CourseSeriesDto(
    override val id: Id<CourseSeries>,
    val title: String,
    val shortTitle: String,
    val abbreviation: String,
    val ects: Int,
    val mandatory: Boolean,
    val language: String
) : Dto<CourseSeriesDto>

data class SemesterDto(
    override val id: Id<Semester>,
    val term: String,
    val year: Int
) : Dto<SemesterDto>