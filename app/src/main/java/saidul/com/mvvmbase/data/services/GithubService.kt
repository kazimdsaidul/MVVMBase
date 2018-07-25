package saidul.com.mvvmbase.data.services

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import saidul.com.mvvmbase.data.models.RepoSearchResponse

/**
 * Created by ankitsharma on 16/01/18.
 */
interface GithubService {

    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String): Observable<RepoSearchResponse>
}