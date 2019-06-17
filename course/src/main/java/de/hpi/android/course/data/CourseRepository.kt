package de.hpi.android.course.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import de.hpi.android.course.domain.Course
import io.reactivex.Observable
import kotlin.IllegalArgumentException

object CourseRepository : Repository<CourseDto>() {
    private val courses = listOf(
        CourseDto(
            id = "2019ss-pt2",
            series = "pt2",
            semester = "2019ss",
            description = "Fortsetzung von PT 1",
            type = setOf(Course.Type.LECTURE, Course.Type.EXERCISE),
            lecturer = "Prof. Naumann",
            assistants = setOf("Tobias Bleifuß")
        ),
        CourseDto(
            id = "2019ss-ma2",
            series = "ma2",
            semester = "2019ss",
            description = "Fortsetzung von Mathe 1",
            type = setOf(Course.Type.LECTURE, Course.Type.EXERCISE),
            lecturer = "Dr. Börner"
        ),
        CourseDto(
            id = "2019ss-www",
            series = "www",
            semester = "2019ss",
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
