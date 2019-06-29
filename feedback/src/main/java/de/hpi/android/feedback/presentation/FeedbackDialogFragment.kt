package de.hpi.android.feedback.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseBottomSheetDialogFragment
import de.hpi.android.feedback.databinding.DialogFeedbackBinding
import de.hpi.android.feedback.presentation.utils.createScreenshot
import java.net.URI


class FeedbackDialogFragment : BaseBottomSheetDialogFragment<DialogFeedbackBinding, FeedbackViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FeedbackViewModel::class.java)
        viewModel.referringScreen = URI.create(activity?.toString())
        viewModel.screenshot = activity?.window?.decorView?.rootView?.createScreenshot()
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): DialogFeedbackBinding {
        return DialogFeedbackBinding.inflate(inflater, container, false).also{
            it.viewModel = viewModel
        }
    }
}
