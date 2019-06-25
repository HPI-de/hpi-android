package de.hpi.android.menu.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.*
import de.hpi.android.menu.data.*
import io.reactivex.Observable

fun LabelDto.toLabelEntity(): Result<Label> {
    return Label(id, title).success()
}

fun RestaurantDto.toRestaurantEntity(): Result<Restaurant> {
    return Restaurant(id, title).success()
}

fun Observable<Result<MenuDto>>.toMenuEntity(): Observable<Result<Menu>> {
    return withRequired2 { menu ->
        Pair(
            LabelRepository.get(menu.labels).mapResult { labels ->
                labels.map { it.toLabelEntity() }.toSet().merge()
            },
            RestaurantRepository.get(menu.restaurant).mapResult { it.toRestaurantEntity() }
        )
    }.mapResult { (menu, labels, restaurant) ->
        Menu(
            id = menu.id,
            date = menu.date,
            restaurant = restaurant,
            title = menu.title,
            substitution = menu.substitution,
            price = menu.price,
            counter = menu.counter,
            labels = labels
        ).success()
    }
}
