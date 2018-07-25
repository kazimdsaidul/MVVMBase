package saidul.com.mvvmbase.common

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import saidul.com.mvvmbase.data.models.ErrorData

/**
 * Created by ankitsharma on 18/01/18.
 */
open class BaseViewModel: ViewModel() {

    val loader: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<ErrorData?> = MutableLiveData()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun displayLoader(isLoading: Boolean) {
        loader.value = isLoading
    }
}