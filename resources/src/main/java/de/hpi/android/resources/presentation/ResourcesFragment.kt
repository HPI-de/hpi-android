package de.hpi.android.resources.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.hpi.android.core.presentation.BaseFragment
import de.hpi.android.resources.databinding.FragmentResourcesBinding

class ResourcesFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentResourcesBinding.inflate(inflater, container, false).root
    }
}
