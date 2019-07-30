package de.hpi.android.core.presentation.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

abstract class BaseAdapter<T : Any, VH : BaseViewHolder<T, B>, out B : ViewDataBinding> : RecyclerView.Adapter<VH>() {
    var items: List<T> by Delegates.observable(emptyList()) { _, old, new ->
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize() = old.size

            override fun getNewListSize() = new.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                this@BaseAdapter.areItemsTheSame(items[oldItemPosition], items[newItemPosition])

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                this@BaseAdapter.areContentsTheSame(items[oldItemPosition], items[newItemPosition])
        }).dispatchUpdatesTo(this)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.item = items[position]
    }

    abstract fun areItemsTheSame(old: T, new: T): Boolean
    abstract fun areContentsTheSame(old: T, new: T): Boolean
}

abstract class BaseViewHolder<T : Any, out B : ViewDataBinding>(val binding: B) :
    RecyclerView.ViewHolder(binding.root) {
    val context = itemView.context

    private lateinit var _item: T
    var item: T
        get() = _item
        set(value) {
            if (::_item.isInitialized && _item == value) return

            _item = value
            onItemSet()
            binding.executePendingBindings()
        }

    abstract fun onItemSet()
}
