package de.hpi.android.resources.data

import androidx.lifecycle.LiveData
import de.hpi.android.core.data.LiveDataCallAdapter
import de.hpi.android.core.data.NetworkDataSource
import de.hpi.android.core.domain.Result
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object NetworkPostDataSource : NetworkDataSource() {
    val api by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapter.Factory())
            .build()
            .create(PostService::class.java)
    }
}

interface PostService {
    @GET("posts/{id}")
    fun getPost(@Path("id") id: String): LiveData<Result<Post>>
}
