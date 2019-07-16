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
    var log: File? = null

    val isSending = MutableLiveData<Boolean>().apply { value = false }
    val isMessageInvalid = MutableLiveData<Boolean>().apply { value = false }
    val isSent = SingleLiveEvent<Boolean>()
    var sendingDisposable: Disposable? = null

    fun onSend(message: String, includeUser: Boolean, includeDebugData: Boolean) {
        launch {
            sendFeedback(
                FeedbackDto(
                    message = message,
                    meta = FeedbackDto.Metadata(
                        screenUri = referringScreen,
                        author = "User#123".takeIf { includeUser }, // TODO: use actual username/ID
                        screenshot = screenshot?.takeIf { includeDebugData },
                        log = log?.takeIf { includeDebugData }
                    )
                )
            )
        }
    }

    fun validateMessage(message: String?) {
        isMessageInvalid.value = message.isNullOrBlank()
    }

    private fun sendFeedback(feedback: FeedbackDto) {
        isSending.value = true
        sendingDisposable?.dispose()
        sendingDisposable = SendFeedbackUseCase(feedback)
            .subscribeBy(
                onSuccess = {
                    Timber.i("Feedback sent with ID $it")
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

        if (screenshot?.delete() == false)
            Timber.w("Deleting screenshot file failed")

        if (log?.delete() == false)
            Timber.w("Deleting log file failed")
    }
}
