package saidul.com.mvvmbase

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import saidul.com.mvvmbase.common.BaseActivity
import saidul.com.mvvmbase.views.main.MainViewModel
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        // observerLoader
        observeLoader(mainViewModel, loaderView)

        observeSearchResults()



        if (mainViewModel.repoList.value == null){


            mainViewModel.searchRepos("android")

        }
    }

    private fun observeSearchResults() {
        mainViewModel.repoList.observe(this, Observer {
            Timber.i("repo count received  ${it?.size}")
            listView.setText(""+it?.toString())
        })
    }
}
