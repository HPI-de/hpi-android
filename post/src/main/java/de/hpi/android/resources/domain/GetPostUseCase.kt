package de.hpi.android.resources.domain

import de.hpi.android.core.data.Id
import de.hpi.android.core.domain.BaseUseCase
import de.hpi.android.core.domain.Result
import de.hpi.android.resources.data.Post
import de.hpi.android.resources.data.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object GetPostUseCase : BaseUseCase<GetPostUseCase.Params, Post>() {
    data class Params(val id: Id)

    override fun execute(parameters: Params): Post {
        var data: Post? = null
        launch(Dispatchers.Main) {
            PostRepository.get(parameters.id)
                    .observeForever {
                        data = (it as Result.Success<Post>).data
                    }
        }
        Thread.sleep(5000)
        return data!!
    }
}
