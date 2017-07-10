package com.example.kevin.myapplication.injection.module

import android.app.Application
import android.content.Context
import com.example.kevin.myapplication.injection.ApplicationContext
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(ApiModule::class))
class AppModule(private val mApplication: Application) {

    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return mApplication
    }
}
