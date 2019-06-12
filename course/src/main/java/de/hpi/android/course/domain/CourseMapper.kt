package de.hpi.android.course.domain

import de.hpi.android.core.domain.*
import de.hpi.android.course.data.*
import io.reactivex.Observable

fun CourseSeriesDto.toCourseSeriesEntity(): Result<CourseSeries> {
    return CourseSeries(id, title, shortTitle, abbreviation, ects, mandatory, language).success()
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
            description = description,
            type = type,
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