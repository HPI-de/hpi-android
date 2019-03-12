package de.hpi.android.core.data

import com.google.protobuf.Message
import de.hpi.android.core.domain.Result
import io.grpc.stub.AbstractStub
import io.reactivex.Observable

abstract class NetworkDataSource<Stub : AbstractStub<Stub>> {
    abstract val stub: Stub

    fun <M : Message, E : Entity> clientCall(call: () -> M, mapper: (M) -> E): Observable<Result<E>> =
        Observable.fromCallable(call)
            .map<Result<E>> {
                Result.Success(mapper(it))
            }
            .startWith(Result.Loading())
}
