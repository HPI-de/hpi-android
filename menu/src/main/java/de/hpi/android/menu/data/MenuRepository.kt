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
            id = Id("mensa1"),
            date = LocalDate.now(),
            restaurant = Id("mensa"),
            title = "Vegane Nudeln all' arrabbiata, dazu Reibekäse",
            substitution = "andere Nudeln",
            price = 1.40f,
            counter = "1",
            labels = setOf(Id("chicken"), Id("beef"), Id("vegetarian"))
        ),
        MenuDto(
            id = Id("mensa2"),
            date = LocalDate.now(),
            restaurant = Id("mensa"),
            title = "Tandem Marburg: Kassler-Rippenspeer mit Honigkruste, Apfelweinsauerkraut und Kartoffelbrei",
            substitution = "nur Honigkruste",
            price = 2.00f,
            counter = "2",
            labels = setOf(Id("chicken"), Id("beef"), Id("pork"))
        ),
        MenuDto(
            id = Id("mensa3"),
            date = LocalDate.now(),
            restaurant = Id("mensa"),
            title = "Rinderhacksteak mit Knoblauchdip und Peperoni-Schoten, dazu bunter CousCous-Salat oder griechiche Kartoffeln",
            substitution = null,
            price = 2.50f,
            counter = "3",
            labels = setOf(Id("chicken"), Id("beef"))
        ),
        MenuDto(
            id = Id("mensa4"),
            date = LocalDate.now(),
            restaurant = Id("mensa"),
            title = "Brokkoli-Nuss-Ecke mit rustikalem Möhrengemüse und Schupfnudeln oder Kartoffeln",
            substitution = "Blumenkohl-Marzipan-Kante mit feinem Karottenobst oder Schlöpfreis und Anti-Kartoffeln",
            price = 2.50f,
            counter = "4",
            labels = setOf(Id("chicken"), Id("beef"), Id("vegetarian"))
        ),
        MenuDto(
            id = Id("mensaSoup"),
            date = LocalDate.now(),
            restaurant = Id("mensa"),
            title = "Tandem Marbug: Quer durch en Gadde (Gemüsecremesuppe)",
            substitution = "nur Brühe",
            price = 1.00f,
            counter = "Tagessuppe",
            labels = setOf(Id("chicken"), Id("beef"), Id("vegetarian"))
        ),
        MenuDto(
            id = Id("mensaNoodles"),
            date = LocalDate.now(),
            restaurant = Id("mensa"),
            title = "Nudeln mit veganer Tomatensauce oder Hackfleischsauce",
            substitution = "mehr Hack",
            price = 2.00f,
            counter = "Nudeltheke",
            labels = setOf(Id("chicken"), Id("beef"), Id("pork"))
        ),
        MenuDto(
            id = Id("ulf1"),
            date = LocalDate.now(),
            restaurant = Id("ulf"),
            title = "Hühnerfrikassee mit Reis",
            substitution = null,
            price = 5.00f,
            counter = "Theke",
            labels = emptySet()
        ),
        MenuDto(
            id = Id("ulf2"),
            date = LocalDate.now(),
            restaurant = Id("ulf"),
            title = "Nudelsalat mit einer Ruccolapesto und Mozzarella",
            substitution = null,
            price = 5.00f,
            counter = "Theke",
            labels = emptySet()
        ),
        MenuDto(
            id = Id("ulf3"),
            date = LocalDate.now(),
            restaurant = Id("ulf"),
            title = "Nudelsalat mit einerTomatenpesto und Mozzarella",
            substitution = null,
            price = 5.00f,
            counter = "Theke",
            labels = emptySet()
        ),
        MenuDto(
            id = Id("ulf4"),
            date = LocalDate.now(),
            restaurant = Id("ulf"),
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
