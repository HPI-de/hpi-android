package de.hpi.android.myhpi.presentation.list

import de.hpi.android.core.domain.invoke
import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.myhpi.domain.ListInfoBitsUseCase

class InfoBitListViewModel : BaseViewModel() {
    private val infoBitsResult = ListInfoBitsUseCase().asLiveData()
    val infoBits = infoBitsResult.data
}
