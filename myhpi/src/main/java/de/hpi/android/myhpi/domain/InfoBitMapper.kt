package de.hpi.android.myhpi.domain

import de.hpi.android.core.domain.*
import de.hpi.android.myhpi.data.ActionDto
import de.hpi.android.myhpi.data.InfoBitDto
import de.hpi.android.myhpi.data.InfoBitRepository
import io.reactivex.Observable

fun ActionDto.toEntity(): Result<Action> {
    return when (this) {
        is ActionDto.Link -> Action.Link(id, icon, title, url)
        is ActionDto.Text -> Action.Text(id, icon, title, content)
    }.success()
}

fun InfoBitDto.toEntity(): Result<InfoBit> {
    return when (val actionResults = actions.map { it.toEntity() }.merge()) {
        is Result.Loading -> Result.Loading()
        is Result.Error -> Result.Error(actionResults.exception)
        is Result.Success -> InfoBit(
            id = id,
            title = title,
            text = text,
            actions = actionResults.data
        ).success()
    }
}

fun Observable<Result<InfoBitDto>>.toInfoBitEntity(): Observable<Result<InfoBit>> {
    return switchMapResult { infoBit ->
        InfoBitRepository.get(infoBit.id)
    }.mapResult { it.toEntity() }
}
