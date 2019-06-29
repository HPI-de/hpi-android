package de.hpi.android.course.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import io.reactivex.Observable
import java.lang.IllegalArgumentException
import java.net.URI

object CourseDetailRepository : Repository<CourseDetailDto>() {
    private val courseDetails = listOf(
        CourseDetailDto(
            id = "2019ss-pt2",
            teleTask = URI("https://www.tele-task.de/series/1260/"),
            programs = mapOf("IT-Systems Engineering BA" to setOf("Programmiertechnik II")),
            description = "Fortsetzung von PT 1"
        ),
        CourseDetailDto(
            id = "2019ss-ma2",
            teleTask = null,
            programs = mapOf("IT-Systems Engineering BA" to setOf("Mathematik II")),
            description = "Fortsetzung von Mathe 1"
        ),
        CourseDetailDto(
            id = "2019ss-www",
            teleTask = URI("https://www.tele-task.de/series/1253/"),
            programs = mapOf(
                "IT-Systems Engineering BA" to
                        setOf(
                            "Web- und Internet-Technologien", "HCGT-Grundlagen", "HCGT-Vertiefung",
                            "ISAE-Grundlagen", "ISAE-Vertiefung"
                        )
            ),
            description = "Grundlagen des Internetworking",
            requirements = "keine",
            learning = "Folien vorlesen",
            examination = "Zwischen- und Endklausur",
            dates = "Dienstag und Donnerstag",
            literature = "Meinel's buch"
        )
    )

    override fun get(id: Id<CourseDetailDto>): Observable<Result<CourseDetailDto>> {
        val courseDetail = courseDetails.firstOrNull { it.id == id }
        return Observable.just(
            courseDetail?.success()
                ?: IllegalArgumentException("CourseDetail with ID $id could not be found").error()
        )
    }

    override fun getAll(): Observable<Result<List<CourseDetailDto>>> {
        return Observable.just(Result.Success(courseDetails))
    }
}
