package de.hpi.android.feedback.presentation

import android.graphics.Bitmap
import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.feedback.data.FeedbackDto
import de.hpi.android.feedback.data.FeedbackRepository
import de.hpi.android.feedback.presentation.utils.asTemporaryFile
import java.net.URI

class FeedbackViewModel : BaseViewModel() {

    var referringScreen: URI = URI.create("/")
    var screenshot: Bitmap? = null

    fun onSend(message: String, includeUser: Boolean, includeDebugData: Boolean) {
        val feedback = FeedbackDto(
            message = message,
            meta = FeedbackDto.Metadata(
                screenUri = referringScreen,
                author = if (includeUser) "User#123" else "Anonymous User",
                screenshot = if (includeDebugData) screenshot?.asTemporaryFile() else null,
                log = if (includeDebugData) "log log log" else null
            )
        )
        FeedbackRepository.create(feedback)
    }
}
