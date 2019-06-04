package de.hpi.android.menu.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.ObservableUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.menu.data.MenuRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object GetMenuUseCase : ObservableUseCase<Id<Menu>, Menu>() {

    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Id<Menu>): Observable<Result<Menu>> {
        return MenuRepository.get(params).toMenuEntity()
    }
}
