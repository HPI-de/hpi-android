package de.hpi.android.myhpi.domain

import de.hpi.android.core.domain.*
import de.hpi.android.myhpi.data.InfoBitDto
import de.hpi.android.myhpi.data.InfoBitRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object ListInfoBitsUseCase : ObservableUseCase<Unit, List<InfoBit>>() {
    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: Unit): Observable<Result<List<InfoBit>>> {
        return InfoBitRepository.getAll().mapResult { infoBits ->
            infoBits.map { it.toEntity() }.merge()
        }
    }
}
