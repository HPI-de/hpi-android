package de.hpi.android.core.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseBottomSheetDialogFragment<B : ViewDataBinding, VM : BaseViewModel> : BottomSheetDialogFragment(),
    CoroutineScope {
    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    protected lateinit var binding: B

    protected lateinit var viewModel: VM

    protected val baseActivity: BaseActivity
        get() = requireActivity() as BaseActivity

    // region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return onCreateBinding(inflater, container, savedInstanceState).also {
            binding = it
            it.lifecycleOwner = this
        }.root
    }

    abstract fun onCreateBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): B

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
    // endregion

    fun show(manager: FragmentManager) = super.show(manager, tag)
}