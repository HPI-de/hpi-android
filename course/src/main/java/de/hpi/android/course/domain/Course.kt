package de.hpi.android.course.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import de.hpi.android.course.data.CourseDetailDto
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
    val website: URI? = null
) : Entity<Course, CourseDto>

data class CourseDetail(
    override val id: Id<CourseDetailDto>,
    val teleTask: URI?,
    val modules: Map<String, Set<String>>,
    val description: String,
    val requirements: String? = null,
    val learning: String? = null,
    val examination: String? = null,
    val dates: String? = null,
    val literature: String? = null
) : Entity<CourseDetail, CourseDetailDto>

data class CourseSeries(
    override val id: Id<CourseSeriesDto>,
    val title: String,
    val shortTitle: String,
    val abbreviation: String,
    val ects: Int,
    val hoursPerWeek: Int,
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
