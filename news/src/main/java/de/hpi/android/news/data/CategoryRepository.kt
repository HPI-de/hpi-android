package de.hpi.android.news.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import io.reactivex.Observable

object CategoryRepository : Repository<CategoryDto>() {
    private val categories = listOf(
        CategoryDto(
            id = "allgemein",
            title = "Allgemein"
        ),
        CategoryDto(
            id = "klubs",
            title = "HPIklubs",
            description = "Das Hasso-Plattner-Institut (HPI) hat zum Wintersemester 2006/07 eine Initiative ins Leben gerufen, die den Studenten die Gelegenheit gibt, aktiv bei der Ausgestaltung des Instituts mitzuhelfen: Die HPI-Studentenklubs - hier berichten die Klubs über ihre Aktivitäten und Veranstaltungen."
        ),
        CategoryDto(
            id = "klubs/nachhaltigkeitsklub",
            title = "Nachhaltigkeitsklub",
            description = "Der Nachhaltigkeitsklub steht für ein nachhaltigeres Leben im Bereich des Umweltschutzes und der sozialen Gerechtigkeit. Wichtig ist uns zudem, es den Studierenden so leicht wie möglich zu machen, Nachhaltigkeit in ihren Alltag zu integrieren. Ein Kernpunkt unserer Arbeit wird sich auf die Flüchtlingshilfe beziehen."
        )
    )

    override fun get(id: Id<CategoryDto>): Observable<Result<CategoryDto>> {
        val category = categories.firstOrNull { it.id == id }
        return Observable.just(
            category?.success()
                ?: IllegalArgumentException("Category with ID $id was not found").error()
        )
    }

    override fun getAll(): Observable<Result<List<CategoryDto>>> {
        return Observable.just(Result.Success(categories))
    }
}
