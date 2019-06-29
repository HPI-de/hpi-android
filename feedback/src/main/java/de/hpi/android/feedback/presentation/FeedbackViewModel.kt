package de.hpi.android.feedback.presentation

import androidx.lifecycle.MutableLiveData
import de.hpi.android.core.presentation.SingleLiveEvent
import de.hpi.android.core.presentation.base.BaseViewModel
import de.hpi.android.feedback.data.FeedbackDto
import de.hpi.android.feedback.domain.SendFeedbackUseCase
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File
import java.net.URI

class FeedbackViewModel : BaseViewModel() {

    var referringScreen: URI = URI.create("/")
    var screenshot: File? = null
    var log: List<String>? = null

    val isSending = MutableLiveData<Boolean>().apply { value = false }
    val isSent = SingleLiveEvent<Boolean>()
    var sendingDisposable: Disposable? = null

    fun onSend(message: String, includeUser: Boolean, includeDebugData: Boolean) {
        launch {
            sendFeedback(
                FeedbackDto(
                    message = message,
                    meta = FeedbackDto.Metadata(
                        screenUri = referringScreen,
                        author = if (includeUser) "User#123" else "Anonymous User",
                        screenshot = if (includeDebugData) screenshot else null,
                        log = if (includeDebugData) log.orEmpty() else emptyList()
                    )
                )
            )
        }
    }

    private fun sendFeedback(feedback: FeedbackDto) {
        isSending.value = true
        sendingDisposable?.dispose()
        sendingDisposable = SendFeedbackUseCase(feedback)
            .subscribeBy(
                onSuccess = {
                    Timber.i("Feedback received as id=$it")
                    launch {
                        isSent.setValue(true)
                    }
                },
                onError = {
                    Timber.w(it, "Sending feedback failed")
                    launch {
                        isSending.value = false
                        isSent.setValue(false)
                    }
                }
            )
    }

    override fun onCleared() {
        super.onCleared()
        sendingDisposable?.dispose()
        clearScreenshotFile()
    }

    private fun clearScreenshotFile() {
        if (screenshot != null)
            if (!screenshot!!.delete())
                Timber.w("Deleting screenshot file failed")
    }
}
