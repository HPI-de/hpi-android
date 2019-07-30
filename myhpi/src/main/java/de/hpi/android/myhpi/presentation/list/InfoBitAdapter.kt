package de.hpi.android.myhpi.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import de.hpi.android.core.presentation.base.BaseAdapter
import de.hpi.android.core.presentation.base.BaseViewHolder
import de.hpi.android.core.presentation.utils.ChipData
import de.hpi.android.myhpi.databinding.MyhpiItemInfoBitBinding
import de.hpi.android.myhpi.domain.Action
import de.hpi.android.myhpi.domain.InfoBit

class InfoBitAdapter(val onInfoBitSelected: (InfoBit) -> Unit) :
    BaseAdapter<InfoBit, InfoBitAdapter.ViewHolder, MyhpiItemInfoBitBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MyhpiItemInfoBitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun areItemsTheSame(old: InfoBit, new: InfoBit) = old.id == new.id

    override fun areContentsTheSame(old: InfoBit, new: InfoBit) = old.title == new.title

    companion object {
        @JvmStatic
        fun formatActions(actions: List<Action>): List<ChipData> {
            return actions.map { ChipData(id=it.id, text=it.title) }
        }
    }

    inner class ViewHolder(binding: MyhpiItemInfoBitBinding) : BaseViewHolder<InfoBit, MyhpiItemInfoBitBinding>(binding) {
        override fun onItemSet() {
            binding.infoBit = item
            binding.root.setOnClickListener {
                onInfoBitSelected(item)
            }
        }
    }
}
