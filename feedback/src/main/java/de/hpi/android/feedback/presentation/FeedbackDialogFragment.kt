package de.hpi.android.feedback.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseBottomSheepDialogFragment
import de.hpi.android.feedback.databinding.DialogFeedbackBinding
import de.hpi.android.feedback.presentation.utils.asTemporaryFile
import de.hpi.android.feedback.presentation.utils.createScreenshot
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException
import java.net.URI

class FeedbackDialogFragment : BaseBottomSheepDialogFragment<DialogFeedbackBinding, FeedbackViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FeedbackViewModel::class.java)
        viewModel.referringScreen = URI.create(activity?.toString())
        launch {
            try {
                viewModel.screenshot = activity?.window
                    ?.createScreenshot()
                    ?.asTemporaryFile()
            } catch (e: IOException) {
                Timber.w(e, "Error taking screenshot for feedback")
            }
        }
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): DialogFeedbackBinding {
        return DialogFeedbackBinding.inflate(inflater, container, false)
            .also { it.viewModel = viewModel }
        }

    override fun onDestroy() {
        super.onDestroy()
        if (viewModel.screenshot != null)
            if (!viewModel.screenshot!!.delete())
                Timber.w("Deleting screenshot file failed")
    }
}
