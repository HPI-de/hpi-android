package de.hpi.android.menu.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import io.reactivex.Observable
import org.threeten.bp.LocalDate

object MenuRepository : Repository<MenuDto>() {
    private val restaurants = listOf(
        MenuDto(
            id = "mensa1",
            date = LocalDate.now(),
            restaurant = "mensa",
            title = "Vegane Nudeln all' arrabbiata, dazu Reibekäse",
            substitution = "andere Nudeln",
            price = 1.40f,
            counter = "1",
            labels = setOf("chicken", "beef", "vegetarian")
        ),
        MenuDto(
            id = "mensa2",
            date = LocalDate.now(),
            restaurant = "mensa",
            title = "Tandem Marburg: Kassler-Rippenspeer mit Honigkruste, Apfelweinsauerkraut und Kartoffelbrei",
            substitution = "nur Honigkruste",
            price = 2.00f,
            counter = "2",
            labels = setOf("chicken", "beef", "pork")
        ),
        MenuDto(
            id = "mensa3",
            date = LocalDate.now(),
            restaurant = "mensa",
            title = "Rinderhacksteak mit Knoblauchdip und Peperoni-Schoten, dazu bunter CousCous-Salat oder griechiche Kartoffeln",
            substitution = null,
            price = 2.50f,
            counter = "3",
            labels = setOf("chicken", "beef")
        ),
        MenuDto(
            id = "mensa4",
            date = LocalDate.now(),
            restaurant = "mensa",
            title = "Brokkoli-Nuss-Ecke mit rustikalem Möhrengemüse und Schupfnudeln oder Kartoffeln",
            substitution = "Blumenkohl-Marzipan-Kante mit feinem Karottenobst oder Schlöpfreis und Anti-Kartoffeln",
            price = 2.50f,
            counter = "4",
            labels = setOf("chicken", "beef", "vegetarian")
        ),
        MenuDto(
            id = "mensaSoup",
            date = LocalDate.now(),
            restaurant = "mensa",
            title = "Tandem Marbug: Quer durch en Gadde (Gemüsecremesuppe)",
            substitution = "nur Brühe",
            price = 1.00f,
            counter = "Tagessuppe",
            labels = setOf("chicken", "beef", "vegetarian")
        ),
        MenuDto(
            id = "mensaNoodles",
            date = LocalDate.now(),
            restaurant = "mensa",
            title = "Nudeln mit veganer Tomatensauce oder Hackfleischsauce",
            substitution = "mehr Hack",
            price = 2.00f,
            counter = "Nudeltheke",
            labels = setOf("chicken", "beef", "pork")
        ),
        MenuDto(
            id = "ulf1",
            date = LocalDate.now(),
            restaurant = "ulf",
            title = "Hühnerfrikassee mit Reis",
            substitution = null,
            price = 5.00f,
            counter = "Theke",
            labels = emptySet()
        ),
        MenuDto(
            id = "ulf2",
            date = LocalDate.now(),
            restaurant = "ulf",
            title = "Nudelsalat mit einer Ruccolapesto und Mozzarella",
            substitution = null,
            price = 5.00f,
            counter = "Theke",
            labels = emptySet()
        ),
        MenuDto(
            id = "ulf3",
            date = LocalDate.now(),
            restaurant = "ulf",
            title = "Nudelsalat mit einerTomatenpesto und Mozzarella",
            substitution = null,
            price = 5.00f,
            counter = "Theke",
            labels = emptySet()
        ),
        MenuDto(
            id = "ulf4",
            date = LocalDate.now(),
            restaurant = "ulf",
            title = "Minestrone",
            substitution = null,
            price = 3.00f,
            counter = "Theke",
            labels = emptySet()
        )

    )

    override fun get(id: Id<MenuDto>): Observable<Result<MenuDto>> {
        val restaurant = restaurants.firstOrNull { it.id == id }
        return Observable.just(
            restaurant?.success()
                ?: IllegalArgumentException("MenuDto with ID $id was not found").error()
        )
    }

    override fun getAll(): Observable<Result<List<MenuDto>>> {
        return Observable.just(Result.Success(restaurants))
    }
}
