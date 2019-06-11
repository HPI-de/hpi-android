package de.hpi.android.menu.presentation.list

import de.hpi.android.core.domain.invoke
import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.core.utils.asLiveData
import de.hpi.android.core.utils.data
import de.hpi.android.menu.domain.ListMenusUseCase

class MenuListViewModel : BaseViewModel() {
    private val menusResult = ListMenusUseCase().asLiveData()
    val menus = menusResult.data
}
