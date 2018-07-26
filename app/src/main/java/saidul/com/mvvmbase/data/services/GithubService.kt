package saidul.com.mvvmbase.data.services

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import saidul.com.mvvmbase.data.models.RepoSearchResponse
import saidul.com.mvvmbase.views.main.listOfAlbums.model.Datum
import java.net.URI

/**
 * Created by ankitsharma on 16/01/18.
 */
interface GithubService {

    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String): Observable<RepoSearchResponse>

    @GET("")
    fun getAlbums(@Url url: URI) : Observable<Array<Datum>>
}