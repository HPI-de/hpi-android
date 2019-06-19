package de.hpi.android.feedback.presentation

import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.feedback.data.FeedbackDto
import de.hpi.android.feedback.data.FeedbackRepository
import java.net.URI

class FeedbackViewModel : BaseViewModel() {
    fun onSend(message: String, includeUser: Boolean, includeDebugData: Boolean) {
        val feedback = FeedbackDto(
            message = "asdf",
            meta = FeedbackDto.Metadata(
                screenUri = URI.create("/"),
                author = "DAU",
                log = "404 log not found"
            )
        )
        FeedbackRepository.create(feedback)
    }
}
