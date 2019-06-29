package de.hpi.android.feedback.presentation

import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.feedback.data.FeedbackDto
import de.hpi.android.feedback.data.FeedbackRepository
import de.hpi.android.feedback.presentation.utils.asTemporaryFile
import java.io.File
import java.net.URI

class FeedbackViewModel : BaseViewModel() {

    var referringScreen: URI = URI.create("/")
    var screenshot: File? = null

    fun onSend(message: String, includeUser: Boolean, includeDebugData: Boolean) {
        val feedback = FeedbackDto(
            message = message,
            meta = FeedbackDto.Metadata(
                screenUri = referringScreen,
                author = if (includeUser) "User#123" else "Anonymous User",
                log = if (includeDebugData) "log log log" else null
                    screenshot = if (includeDebugData) screenshot else null,
            )
        )
        FeedbackRepository.create(feedback)
    }
}
