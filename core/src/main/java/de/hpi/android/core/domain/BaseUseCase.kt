package de.hpi.android.core.domain

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers

abstract class BaseUseCase<in P, R : Any> {
    protected abstract val subscribeScheduler: Scheduler
    protected open val observeScheduler = AndroidSchedulers.mainThread()

    operator fun invoke(params: P): Observable<Result<R>> =
        executeObservable(params)
            .subscribeOn(subscribeScheduler)
            .observeOn(observeScheduler)

    protected abstract fun executeObservable(params: P): Observable<Result<R>>
}

operator fun <R : Any> BaseUseCase<Unit, R>.invoke() = this(Unit)

abstract class ObservableUseCase<in P, R : Any> : BaseUseCase<P, R>() {
    override fun executeObservable(params: P): Observable<Result<R>> =
        execute(params)

    protected abstract fun execute(params: P): Observable<Result<R>>
}

abstract class SingleUseCase<in P, R : Any> : BaseUseCase<P, R>() {
    override fun executeObservable(params: P): Observable<Result<R>> =
        execute(params)
            .toObservable()

    protected abstract fun execute(params: P): Single<Result<R>>
}

abstract class CompletableUseCase<in P> : BaseUseCase<P, Unit>() {
    override fun executeObservable(params: P): Observable<Result<Unit>> =
        execute(params)
            .toObservable<Result<Unit>>()

    protected abstract fun execute(params: P): Completable
}

abstract class MaybeUseCase<in P, R : Any> : BaseUseCase<P, R>() {
    override fun executeObservable(params: P): Observable<Result<R>> =
        execute(params)
            .toObservable()

    protected abstract fun execute(params: P): Maybe<Result<R>>
}
