package de.hpi.android.core.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

/**
 * Extension method for convenience reasons
 *
 * @param <VM> The type parameter for the ViewModel.
 * @return A ViewModel that is an instance of the given type [VM].
 */
inline fun <reified VM : ViewModel> ViewModelProvider.get() = get(VM::class.java)
