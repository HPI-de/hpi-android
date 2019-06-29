package de.hpi.android.feedback.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseBottomSheepDialogFragment
import de.hpi.android.feedback.databinding.DialogFeedbackBinding
import de.hpi.android.feedback.presentation.utils.asTemporaryFile
import de.hpi.android.feedback.presentation.utils.createScreenshot
import de.hpi.android.feedback.presentation.utils.readCurrentLog
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException
import java.net.URI

class FeedbackDialogFragment : BaseBottomSheepDialogFragment<DialogFeedbackBinding, FeedbackViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FeedbackViewModel::class.java)
        viewModel.isSent.observe(this, Observer { success ->
            if (success) {
                dismiss()
            }
            Toast.makeText(
                context!!,
                if (success)
                    "Successfully sent feedback" //R.string.feedback_sending_successful
                else
                    "Failed to send feedback", //R.string.feedback_sending_failed,
                Toast.LENGTH_SHORT
            ).show()
        })
        prepareFeedbackDebugInformation()
    }

    private fun prepareFeedbackDebugInformation() {
        viewModel.referringScreen = URI.create(activity?.toString())
        launch {
            try {
                viewModel.screenshot = activity?.window
                    ?.createScreenshot()
                    ?.asTemporaryFile()
            } catch (e: IOException) {
                Timber.w(e, "Error taking screenshot for feedback")
            }
            try {
                viewModel.log = readCurrentLog()
            } catch (e: IOException) {
                Timber.w(e, "Error reading log for feedback")
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
    }
}
