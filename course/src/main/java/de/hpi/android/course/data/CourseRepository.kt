package de.hpi.android.course.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import io.reactivex.Observable
import java.lang.IllegalArgumentException

object CourseRepository : Repository<Course>() {
    private val courses = listOf(
        Course(
            id = "1",
            series = "pt2",
            semester = "ss2019",
            description = "Fortsetzung von PT 1",
            type = setOf(Course.Type.LECTURE, Course.Type.EXERCISE),
            lecturer = "Prof. Naumann",
            assistants = setOf("Tobias Bleifuß")
        ),
        Course(
            id = "2",
            series = "ma2",
            semester = "ss2019",
            description = "Fortsetzung von Mathe 1",
            type = setOf(Course.Type.LECTURE, Course.Type.EXERCISE),
            lecturer = "Dr. Börner"
        )
    )

    override fun get(id: Id<Course>): Observable<Result<Course>> {
        val course = courses.firstOrNull{ it.id == id }
        return Observable.just(
            if (course == null) Result.Error(IllegalArgumentException("Course with ID $id was not found"))
            else Result.Success(course)
        )
    }

    override fun getAll(): Observable<Result<List<Course>>> {
        return Observable.just(Result.Success(courses))
    }
}