package de.hpi.android.feedback.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import de.hpi.android.core.presentation.base.BaseBottomSheepDialogFragment
import de.hpi.android.feedback.databinding.DialogFeedbackBinding

class FeedbackDialogFragment : BaseBottomSheepDialogFragment<DialogFeedbackBinding, FeedbackViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FeedbackViewModel::class.java)
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): DialogFeedbackBinding {
        return DialogFeedbackBinding.inflate(inflater, container, false)
    }
}
