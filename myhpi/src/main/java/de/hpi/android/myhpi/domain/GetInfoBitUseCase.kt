package de.hpi.android.myhpi.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.*
import de.hpi.android.myhpi.data.InfoBitRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object GetInfoBitUseCase : ObservableUseCase<Id<InfoBit>, InfoBit>() {

    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Id<InfoBit>): Observable<Result<InfoBit>> {
        return InfoBitRepository.get(params).mapResult { it.toEntity() }
    }
}
