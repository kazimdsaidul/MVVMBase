package saidul.com.mvvmbase.views.main

import android.arch.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import saidul.com.mvvmbase.common.BaseViewModel
import saidul.com.mvvmbase.common.network.ApiObserver
import saidul.com.mvvmbase.data.models.ErrorData
import saidul.com.mvvmbase.data.models.RepoDTO
import saidul.com.mvvmbase.data.models.RepoSearchResponse
import saidul.com.mvvmbase.data.repository.DataRepository
import javax.inject.Inject


/**
 * Created by ankitsharma on 11/01/18.
 */
class BasicViewModel @Inject constructor(private val dataRepository: DataRepository) : BaseViewModel() {

    private var msg: String = "test"
    var repoList: MutableLiveData<List<RepoDTO>> = MutableLiveData()

    fun getMessage(): String {
        msg = dataRepository.getMessage()
        return msg
    }

    fun searchRepos(query: String){

        displayLoader(true)

        dataRepository.searchRepositories(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : ApiObserver<RepoSearchResponse>(compositeDisposable) {
                    override fun onError(e: ErrorData) {
                        displayLoader(false)
                        error.value = e
                    }

                    override fun onSuccess(data: RepoSearchResponse) {
                        displayLoader(false)
                        repoList.value = data.repoList
                    }
                })
    }


}