package saidul.com.mvvmbase.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import saidul.com.mvvmbase.di.annotations.ActivityScope
import saidul.com.mvvmbase.views.main.basic.BasicActivity
import saidul.com.mvvmbase.views.main.basic.BasicActivityModule
import saidul.com.mvvmbase.views.main.listOfAlbums.AlbumsActivityModule
import saidul.com.mvvmbase.views.main.listOfAlbums.ShowListActivity

/**
 * Contains all activities to be bound to application dependency graph
 *
 * Created by ankitsharma on 11/01/18.
 */
@Module
abstract class ActivityBuilderModule {

    // every activity modual must be add in this array list
    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(BasicActivityModule::class, AlbumsActivityModule::class))
    abstract fun bindBasicActivity(): BasicActivity

    @ContributesAndroidInjector
    abstract fun bindAlbumsActivit(): ShowListActivity
}