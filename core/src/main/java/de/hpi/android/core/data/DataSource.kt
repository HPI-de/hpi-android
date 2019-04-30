package de.hpi.android.core.data

import com.google.protobuf.Message
import de.hpi.android.core.domain.Result
import io.grpc.stub.AbstractStub
import io.reactivex.Observable

abstract class NetworkDataSource<Stub : AbstractStub<Stub>> {
    abstract val stub: Stub

    fun <M : Message, E : Entity<E>> clientCall(call: () -> M, mapper: (M) -> E): Observable<Result<E>> =
        Observable.fromCallable(call)
            .map<Result<E>> {
                Result.Success(mapper(it))
            }
            .startWith(Result.Loading())
    fun <M : Message, E : Entity<E>> clientCallList(call: () -> List<M>, mapper: (List<M>) -> List<E>): Observable<Result<List<E>>> =
        Observable.fromCallable(call)
            .map<Result<List<E>>> {
                Result.Success(mapper(it))
            }
            .startWith(Result.Loading())
}
