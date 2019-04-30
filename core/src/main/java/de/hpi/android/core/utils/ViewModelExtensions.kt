package de.hpi.android.core.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

/**
 * Extension method for convenience reasons
 *
 * @param modelClass The class of the ViewModel to create an instance of it if it is not present.
 * @param <VM>       The type parameter for the ViewModel.
 * @return A ViewModel that is an instance of the given type [VM].
 */
fun <VM : ViewModel> ViewModelProvider.get(modelClass: KClass<VM>) = get(modelClass.java)
