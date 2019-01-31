package de.hpi.android.resources.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.resources.databinding.FragmentResourcesBinding

class ResourcesFragment : BaseFragment<FragmentResourcesBinding>() {
    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentResourcesBinding {
        return FragmentResourcesBinding.inflate(inflater, container, false)
    }
}
