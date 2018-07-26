package saidul.com.mvvmbase.data.repository

import io.reactivex.Observable
import saidul.com.mvvmbase.data.models.RepoSearchResponse
import saidul.com.mvvmbase.data.services.GithubService
import saidul.com.mvvmbase.di.annotations.ApplicationScope
import saidul.com.mvvmbase.views.main.listOfAlbums.model.Datum
import java.net.URI
import javax.inject.Inject

/**
 * Created by ankitsharma on 11/01/18.
 */
@ApplicationScope
class DataRepository @Inject constructor(private val githubService: GithubService) {

    fun getMessage(): String {
        return "hello my message"
    }

    fun searchRepositories(query: String): Observable<RepoSearchResponse> {

        // if check internet connection has than called to Api otherwise it data return from local database
        return githubService.searchRepos(query);
    }

    fun getAlbusList() : Observable<Array<Datum>>? {

        return githubService.getAlbums(URI("https://jsonplaceholder.typicode.com/photos"));
    }


}