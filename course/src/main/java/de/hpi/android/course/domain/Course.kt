package de.hpi.android.course.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import de.hpi.android.course.data.CourseDto
import de.hpi.android.course.data.CourseSeriesDto
import de.hpi.android.course.data.SemesterDto
import java.net.URI

data class Course(
    override val id: Id<CourseDto>,
    val series: CourseSeries,
    val semester: Semester,
    val lecturer: String,
    val assistants: Set<String> = emptySet(),
    val description: String,
    val website: URI? = null
) : Entity<Course>

data class CourseSeries(
    override val id: Id<CourseSeriesDto>,
    val title: String,
    val shortTitle: String,
    val abbreviation: String,
    val ects: Int,
    val mandatory: Boolean,
    val language: String,
    val type: Set<Type>
) : Entity<CourseSeries, CourseSeriesDto> {
    enum class Type {
        LECTURE,
        SEMINAR,
        BLOCK_SEMINAR,
        EXERCISE
    }
}

data class Semester(
    override val id: Id<SemesterDto>,
    val term: String,
    val year: Int
) : Entity<Semester, SemesterDto>
