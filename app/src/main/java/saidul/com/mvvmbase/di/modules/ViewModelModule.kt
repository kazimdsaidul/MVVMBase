package saidul.com.mvvmbase.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import saidul.com.mvvmbase.common.ViewModelFactory
import saidul.com.mvvmbase.di.annotations.ViewModelKey
import saidul.com.mvvmbase.views.main.BasicViewModel

/**
 * Provides map of all ViewModels and a ViewModelFactory for dependencies
 *
 * Created by ankitsharma on 11/01/18.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BasicViewModel::class)
    abstract fun bindMainViewModel(basicViewModel: BasicViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}