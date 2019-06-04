package de.hpi.android.menu.domain

import de.hpi.android.core.domain.ObservableUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.core.domain.flatMapResult
import de.hpi.android.core.domain.merge
import de.hpi.android.core.domain.success
import de.hpi.android.menu.data.MenuDto
import de.hpi.android.menu.data.MenuRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object ListMenusUseCase : ObservableUseCase<Unit, List<Menu>>() {
    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Unit): Observable<Result<List<Menu>>> {
        return MenuRepository.getAll().flatMapResult { menus ->
            Observable.combineLatest(menus.map { Observable.just(it.success() as Result<MenuDto>).toMenuEntity() }) { array ->
                @Suppress("UNCHECKED_CAST")
                (array as Array<Result<Menu>>).asList().merge()
            }
        }
    }
}
