package de.hpi.android.menu.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.Repository
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.error
import de.hpi.android.core.domain.success
import io.reactivex.Observable

object RestaurantRepository : Repository<RestaurantDto>() {
    private val restaurants = listOf(
        RestaurantDto(
            id = "mensa",
            title = "Mensa Griebnitzsee"
        ),
        RestaurantDto(
            id = "ulf",
            title = "Ulf's Café"
        )
    )

    override fun get(id: Id<RestaurantDto>): Observable<Result<RestaurantDto>> {
        val restaurant = restaurants.firstOrNull { it.id == id }
        return Observable.just(
            restaurant?.success()
                ?: IllegalArgumentException("RestaurantDto with ID $id was not found").error()
        )
    }

    override fun getAll(): Observable<Result<List<RestaurantDto>>> {
        return Observable.just(Result.Success(restaurants))
    }
}
