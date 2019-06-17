package de.hpi.android.course.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import io.reactivex.Observable
import kotlin.IllegalArgumentException

object CourseRepository : Repository<CourseDto>() {
    private val courses = listOf(
        CourseDto(
            id = "1",
            series = "pt2",
            semester = "ss2019",
            description = "Fortsetzung von PT 1",
            type = setOf(Course.Type.LECTURE, Course.Type.EXERCISE),
            lecturer = "Prof. Naumann",
            assistants = setOf("Tobias Bleifuß")
        ),
        CourseDto(
            id = "2",
            series = "ma2",
            semester = "ss2019",
            description = "Fortsetzung von Mathe 1",
            type = setOf(Course.Type.LECTURE, Course.Type.EXERCISE),
            lecturer = "Dr. Börner"
        ),
        CourseDto(
            id = "3",
            series = "www",
            semester = "ss2019",
            description = "Grundlagen des Internetworking",
            type = setOf(Course.Type.LECTURE, Course.Type.EXERCISE),
            lecturer = "Prof. Meinel",
            assistants = setOf("Leonard Marschke", "Christiane Hagedorn", "Matthias Bauer")
        )
    )

    override fun get(id: Id<Course>): Observable<Result<CourseDto>> {
        val course = courses.firstOrNull{ it.id == id }
        return Observable.just(
            course?.success()
                ?: IllegalArgumentException("Course with ID $id could not be found").error()
        )
    }

    override fun getAll(): Observable<Result<List<CourseDto>>> {
        return Observable.just(Result.Success(courses))
    }
}