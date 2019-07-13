package de.hpi.android.feedback.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseBottomSheepDialogFragment
import de.hpi.android.feedback.R
import de.hpi.android.feedback.databinding.FeedbackDialogFeedbackBinding
import de.hpi.android.feedback.presentation.utils.asTempFile
import de.hpi.android.feedback.presentation.utils.createScreenshot
import de.hpi.android.feedback.presentation.utils.readCurrentLog
import kotlinx.android.synthetic.main.feedback_dialog_feedback.*
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException
import java.net.URI

class FeedbackDialogFragment : BaseBottomSheepDialogFragment<FeedbackDialogFeedbackBinding, FeedbackViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FeedbackViewModel::class.java)
        prepareFeedbackDebugInformation()
    }

    private fun prepareFeedbackDebugInformation() {
        // TODO: get URL of referring screen
        viewModel.referringScreen = URI.create(activity?.toString())
        launch {
            try {
                viewModel.screenshot = activity?.window
                    ?.createScreenshot()
                    ?.asTempFile()
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
    ): FeedbackDialogFeedbackBinding {
        return FeedbackDialogFeedbackBinding.inflate(inflater, container, false)
            .also { it.viewModel = viewModel }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isSent.observe(this, Observer { success ->
            if (success) dismiss()
            Toast.makeText(
                context!!,
                if (success) R.string.feedback_send_successful else R.string.feedback_send_error,
                Toast.LENGTH_SHORT
            ).show()
        })

        message.addTextChangedListener { text -> viewModel.validateMessage(text?.toString()) }
        viewModel.isInvalid.observe(this, Observer { invalid ->
            if (invalid)
                messageWrapper.error = getString(R.string.feedback_message_blank)
            else
                messageWrapper.error = null
        })
    }
}
