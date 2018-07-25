package saidul.com.mvvmbase.di.modules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import saidul.com.mvvmbase.data.services.GithubService
import saidul.com.mvvmbase.di.annotations.ApplicationScope

/**
 * Provides network services for data
 *
 * Created by ankitsharma on 16/01/18.
 */
@Module(includes = arrayOf(NetworkModule::class))
class NetworkServiceModule {

    @Provides
    @ApplicationScope
    fun provideGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }
}