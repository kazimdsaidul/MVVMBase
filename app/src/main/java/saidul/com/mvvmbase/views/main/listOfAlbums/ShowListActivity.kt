package saidul.com.mvvmbase.views.main.listOfAlbums

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.content_show_list.*
import saidul.com.mvvmbase.R
import saidul.com.mvvmbase.common.BaseActivity
import saidul.com.mvvmbase.views.main.listOfAlbums.adapter.ListAdapterRecyclView
import saidul.com.mvvmbase.views.main.listOfAlbums.model.Datum
import javax.inject.Inject


class ShowListActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mAlbumsViewModel:AlbusActivityModel

    companion object {
        var TAG: String = this.javaClass.simpleName;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)
        setToolbar()


        mAlbumsViewModel = ViewModelProviders.of(this, viewModelFactory).get(AlbusActivityModel::class.java)

        observeLoader(mAlbumsViewModel)

        obsereAlbusData();

        if(mAlbumsViewModel.albusList .value == null){
            mAlbumsViewModel.getAlbusList();


        }

    }

    private fun obsereAlbusData() {
        mAlbumsViewModel.albusList.observe(this, Observer {

            if (it != null) {
                generateRecycleView(it)
            };


        })
    }




    private fun generateRecycleView(fromJson: Array<Datum>) {

        Log.d(TAG, fromJson.toString());
        // Creates a vertical Layout Manager
        rv.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)
        // Access the RecyclerView Adapter and load the data into it
        rv.adapter = ListAdapterRecyclView(data = fromJson, context = applicationContext);

    }


}
