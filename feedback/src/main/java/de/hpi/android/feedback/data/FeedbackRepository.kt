package de.hpi.android.feedback.data

import de.hpi.android.core.data.Id
import de.hpi.android.core.data.MutableRepository
import de.hpi.android.core.domain.Result
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import timber.log.Timber
import java.io.IOException
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.atomic.AtomicBoolean

object FeedbackRepository : MutableRepository<FeedbackDto>() {
    override fun get(id: Id<FeedbackDto>): Observable<Result<FeedbackDto>> {
        throw UnsupportedOperationException();
    }

    override fun getAll(): Observable<Result<List<FeedbackDto>>> {
        throw UnsupportedOperationException();
    }

    override fun create(entity: FeedbackDto): Single<Id<FeedbackDto>> {
        Timber.i(entity.toString())
        //TODO: implement feedback sending
        val id: Id<FeedbackDto> = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE).toString()
        return Single.just(id) // mock succeed
    }

    override fun update(entity: FeedbackDto): Completable {
        throw UnsupportedOperationException();
    }

    override fun delete(id: Id<FeedbackDto>): Completable {
        throw UnsupportedOperationException();
    }
}
