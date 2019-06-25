package de.hpi.android.course.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.Entity
import java.net.URI

data class Course(
    override val id: Id<Course>,
    val series: CourseSeries,
    val semester: Semester,
    val lecturer: String,
    val assistants: Set<String> = emptySet(),
    val description: String,
    val website: URI? = null
) : Entity<Course>

data class CourseSeries(
    override val id: Id<CourseSeries>,
    val title: String,
    val shortTitle: String,
    val abbreviation: String,
    val ects: Int,
    val mandatory: Boolean,
    val language: String,
    val type: Set<Type>
) : Entity<CourseSeries>{
    enum class Type {
        LECTURE,
        SEMINAR,
        BLOCK_SEMINAR,
        EXERCISE
    }
}

data class Semester(
    override val id: Id<Semester>,
    val term: String,
    val year: Int
) : Entity<Semester>