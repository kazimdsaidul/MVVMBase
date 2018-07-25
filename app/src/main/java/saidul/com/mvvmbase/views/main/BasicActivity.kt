package saidul.com.mvvmbase.views.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_basic.*
import saidul.com.mvvmbase.R
import saidul.com.mvvmbase.common.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class BasicActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mBasicViewModel: BasicViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        mBasicViewModel = ViewModelProviders.of(this, viewModelFactory).get(BasicViewModel::class.java)

        // observerLoader
        observeLoader(mBasicViewModel, loaderView)

        observeSearchResults()



        if (mBasicViewModel.repoList.value == null){


            mBasicViewModel.searchRepos("android")

        }
    }

    private fun observeSearchResults() {
        mBasicViewModel.repoList.observe(this, Observer {
            Timber.i("repo count received  ${it?.size}")
            listView.setText(""+it?.toString())
        })
    }
}
