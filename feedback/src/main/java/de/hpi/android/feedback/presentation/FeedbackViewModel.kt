package de.hpi.android.feedback.presentation

import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.feedback.data.FeedbackDto
import de.hpi.android.feedback.domain.SendFeedbackUseCase
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File
import java.net.URI

class FeedbackViewModel : BaseViewModel() {

    var referringScreen: URI = URI.create("/")
    var screenshot: File? = null
    var log: List<String>? = null

    fun onSend(message: String, includeUser: Boolean, includeDebugData: Boolean) {
        launch {
            val feedback = FeedbackDto(
                message = message,
                meta = FeedbackDto.Metadata(
                    screenUri = referringScreen,
                    author = if (includeUser) "User#123" else "Anonymous User",
                    screenshot = if (includeDebugData) screenshot else null,
                    log = if (includeDebugData) log.orEmpty() else emptyList()
                )
            )
            SendFeedbackUseCase(feedback)
                .subscribeBy(
                    onSuccess = {
                        Timber.i("Feedback received as id=$it")
                    },
                    onError = {
                        Timber.w(it, "Sending log failed")
                    }
                )
        }
    }
}
