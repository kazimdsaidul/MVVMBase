package saidul.com.mvvmbase.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import saidul.com.mvvmbase.MainActivity
import saidul.com.mvvmbase.di.annotations.ActivityScope
import saidul.com.mvvmbase.views.main.MainActivityModule

/**
 * Contains all activities to be bound to application dependency graph
 *
 * Created by ankitsharma on 11/01/18.
 */
@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}