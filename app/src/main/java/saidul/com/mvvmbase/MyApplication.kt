package saidul.com.mvvmbase

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import saidul.com.mvvmbase.di.DaggerAppComponent
import timber.log.Timber


/**
 * Application class that initiates the dependency graph
 *
 * Created by ankitsharma on 11/01/18.
 */
class MyApplication: DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out MyApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}