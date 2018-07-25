package saidul.com.mvvmbase.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import saidul.com.mvvmbase.di.annotations.ApplicationScope

/**
 * App level dependencies
 * Created by ankitsharma on 11/01/18.
 */
@Module(includes = arrayOf(NetworkServiceModule::class))
class AppModule {

    @Provides
    @ApplicationScope
    fun provideContext(application: Application): Context = application
}