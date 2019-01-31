package de.hpi.android.resources.presentation

import de.hpi.android.core.domain.Result
import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.map
import de.hpi.android.resources.domain.GetPostUseCase

class ResourcesViewModel : BaseViewModel() {
    val post = GetPostUseCase(GetPostUseCase.Params("1"))
            .map {
                when (it) {
                    is Result.Success -> it.data
                    else -> null
                }
            }
}
