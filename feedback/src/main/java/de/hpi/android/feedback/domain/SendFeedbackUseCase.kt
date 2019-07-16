package de.hpi.android.feedback.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.SingleUseCase
import de.hpi.android.feedback.data.FeedbackDto
import de.hpi.android.feedback.data.FeedbackRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

object SendFeedbackUseCase : SingleUseCase<FeedbackDto, Id<FeedbackDto>>() {
    override val subscribeScheduler = Schedulers.io()

    override fun execute(params: FeedbackDto): Single<Id<FeedbackDto>> {
        return FeedbackRepository.create(params)
    }
}
