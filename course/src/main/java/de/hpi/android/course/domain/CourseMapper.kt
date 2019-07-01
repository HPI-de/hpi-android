package de.hpi.android.course.domain

import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.mapResult
import de.hpi.android.core.domain.success
import de.hpi.android.core.domain.withRequired2
import de.hpi.android.course.data.*
import io.reactivex.Observable

fun CourseSeriesDto.toCourseSeriesEntity(): Result<CourseSeries> {
    return CourseSeries(id, title, shortTitle, abbreviation, ects, hoursPerWeek, mandatory, language, type).success()
}

fun SemesterDto.toSemesterEntity(): Result<Semester> {
    return Semester(id, term, year).success()
}

fun Observable<Result<CourseDto>>.toCourseEntity(): Observable<Result<Course>> {
    fun CourseDto.entity(courseSeries: CourseSeries, semester: Semester): Course {
        return Course(
            id = id,
            series = courseSeries,
            semester = semester,
            lecturer = lecturer,
            assistants = assistants,
            website = website
        )
    }

    return withRequired2 { course ->
        Pair(
            CourseSeriesRepository.get(course.series).mapResult { it.toCourseSeriesEntity() },
            SemesterRepository.get(course.semester).mapResult { it.toSemesterEntity() }
        )
    }
        .mapResult { (course, courseSeries, semester) ->
            course.entity(courseSeries, semester).success()
        }
}

fun CourseDetailDto.toCourseDetailEntity(): Result<CourseDetail> {
    return CourseDetail(
        id = id,
        teleTask = teleTask,
        modules = programs,
        description = description,
        requirements = requirements,
        learning = learning,
        examination = examination,
        dates = dates,
        literature = literature
    ).success()
}
