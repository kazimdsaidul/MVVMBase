package saidul.com.mvvmbase.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import saidul.com.mvvmbase.MyApplication

import saidul.com.mvvmbase.di.annotations.ApplicationScope
import saidul.com.mvvmbase.di.modules.ActivityBuilderModule
import saidul.com.mvvmbase.di.modules.AppModule
import saidul.com.mvvmbase.di.modules.ViewModelModule



@ApplicationScope
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        ActivityBuilderModule::class))
interface AppComponent: AndroidInjector<MyApplication> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<MyApplication>()
}