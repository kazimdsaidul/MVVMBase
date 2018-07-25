package saidul.com.mvvmbase.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import saidul.com.mvvmbase.views.main.BasicActivity
import saidul.com.mvvmbase.di.annotations.ActivityScope
import saidul.com.mvvmbase.views.main.BasicActivityModule

/**
 * Contains all activities to be bound to application dependency graph
 *
 * Created by ankitsharma on 11/01/18.
 */
@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(BasicActivityModule::class))
    abstract fun bindMainActivity(): BasicActivity
}