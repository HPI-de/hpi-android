package de.hpi.android.core.presentation.utils

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseFragment
import de.hpi.android.core.presentation.base.BaseViewModel

inline fun <B : ViewDataBinding, reified VM : BaseViewModel> BaseFragment<B, VM>.viewModel(
    noinline factory: (() -> VM)? = null
): VM {
    return ViewModelProviders.of(this,
        factory?.let {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    @Suppress("UNCHECKED_CAST")
                    return it() as T
                }
            }
        }).get(VM::class.java)
}
