package de.hpi.android.course.data

import de.hpi.android.core.data.Entity
import de.hpi.android.core.data.Id
import java.net.URI

data class Course(
    override val id: Id<Course>,
    val series: Id<CourseSeries>,
    val semester: Id<Semester>,
    val lecturer: String,
    val assistants: Set<String> = emptySet(),
    val description: String,
    val type: Set<Type>,
    val website: URI? = null
) : Entity<Course> {
    enum class Type {
        LECTURE,
        SEMINAR,
        BLOCK_SEMINAR,
        EXERCISE
    }
}

data class CourseSeries(
    override val id: Id<CourseSeries>,
    val title: String,
    val shortTitle: String,
    val abbreviation: String,
    val ects: Int,
    val mandatory: Boolean,
    val language: String
) : Entity<CourseSeries>

data class Semester(
    override val id: Id<Semester>,
    val term: String,
    val year: Int
) : Entity<Semester>