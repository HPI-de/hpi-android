package de.hpi.android.menu.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.menu.R
import de.hpi.android.menu.databinding.FragmentMenuListBinding
import kotlinx.android.synthetic.main.menu_fragment_menu_list.*

class MenuListFragment : BaseFragment<FragmentMenuListBinding, MenuListViewModel>() {
    private val adapter by lazy { MenuAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MenuListViewModel::class.java)
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentMenuListBinding {
        return FragmentMenuListBinding.inflate(inflater, container, false).also {
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
        viewModel.menus.observe(this, Observer { menus ->
            adapter.items = menus ?: emptyList()
        })
    }
}
