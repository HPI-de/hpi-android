package de.hpi.android.menu.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import de.hpi.android.core.presentation.base.BaseAdapter
import de.hpi.android.core.presentation.base.BaseViewHolder
import de.hpi.android.menu.databinding.ItemMenuBinding
import de.hpi.android.menu.domain.Menu

class MenuAdapter : BaseAdapter<Menu, MenuAdapter.ViewHolder, ItemMenuBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun areItemsTheSame(old: Menu, new: Menu) = old.id == new.id

    override fun areContentsTheSame(old: Menu, new: Menu) = old.title == new.title


    class ViewHolder(binding: ItemMenuBinding) : BaseViewHolder<Menu, ItemMenuBinding>(binding) {
        override fun onItemSet() {
            binding.menu = item
        }
    }
}
