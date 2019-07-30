package de.hpi.android.myhpi.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.myhpi.R
import de.hpi.android.myhpi.databinding.MyhpiFragmentBinding
import kotlinx.android.synthetic.main.myhpi_fragment.*
import de.hpi.android.core.presentation.utils.viewModel

class InfoBitsFragment : BaseFragment<MyhpiFragmentBinding, InfoBitListViewModel>() {
    private val adapter by lazy {
        InfoBitAdapter {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModel()
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): MyhpiFragmentBinding {
        return MyhpiFragmentBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseActivity.setSupportActionBar(view.findViewById(R.id.toolbar))

        recyclerView.also {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(context)
        }
        viewModel.infoBits.observe(this, Observer { articles ->
            adapter.items = articles ?: emptyList()
        })
    }
}
