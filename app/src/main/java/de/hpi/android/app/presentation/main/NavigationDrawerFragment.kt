package de.hpi.android.app.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.NavigationUI
import de.hpi.android.core.presentation.base.BaseBottomSheepDialogFragment
import de.hpi.android.core.presentation.utils.viewModel
import de.hpi.android.databinding.AppBottomsheetNavigationBinding
import kotlinx.android.synthetic.main.app_bottomsheet_navigation.*

class NavigationDrawerFragment :
    BaseBottomSheepDialogFragment<AppBottomsheetNavigationBinding, NavigationDrawerViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModel()
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): AppBottomsheetNavigationBinding {
        return AppBottomsheetNavigationBinding.inflate(layoutInflater, container, false).also {
            it.viewModel = viewModel
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        NavigationUI.setupWithNavController(navigationView, findNavController(this))
    }
}
