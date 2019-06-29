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

    private val debugSuccess = AtomicBoolean(false)

    override fun create(entity: FeedbackDto): Single<Id<FeedbackDto>> {
        Timber.i(entity.toString())
        //TODO: implement feedback sending
        val id: Id<FeedbackDto> = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE).toString()
        return if (debugSuccess.getAndSet(true)) {
            Single.just(id)
        } else {
            Single.error(IOException("example network error"))
        }
    }

    override fun update(entity: FeedbackDto): Completable {
        throw UnsupportedOperationException();
    }

    override fun delete(id: Id<FeedbackDto>): Completable {
        throw UnsupportedOperationException();
    }
}
