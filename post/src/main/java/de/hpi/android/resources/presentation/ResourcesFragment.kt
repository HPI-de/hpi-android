package de.hpi.android.resources.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.resources.databinding.FragmentResourcesBinding

class ResourcesFragment : BaseFragment<FragmentResourcesBinding, ResourcesViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ResourcesViewModel::class.java)
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentResourcesBinding {
        return FragmentResourcesBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
    }
}
