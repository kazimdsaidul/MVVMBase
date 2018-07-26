package saidul.com.mvvmbase.views.main.listOfAlbums

import android.arch.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import saidul.com.mvvmbase.common.BaseViewModel
import saidul.com.mvvmbase.common.network.ApiObserver
import saidul.com.mvvmbase.data.models.ErrorData
import saidul.com.mvvmbase.data.repository.DataRepository
import saidul.com.mvvmbase.views.main.listOfAlbums.model.Datum
import javax.inject.Inject

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/25/18.
 */


class AlbusActivityModel @Inject constructor(private val dataRepository: DataRepository):BaseViewModel(){

    var albusList: MutableLiveData<Array<Datum>> = MutableLiveData();



    fun getAlbusList(){
        dataRepository.getAlbusList()?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : ApiObserver<Array<Datum>>(compositeDisposable){

            override fun onSuccess(data: Array<Datum>) {
                albusList.value = data;

            }

            override fun onError(e: ErrorData) {
                displayLoader(false)
            }
        })

    }


}


