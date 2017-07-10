package com.example.kevin.myapplication

import android.app.Application
import android.content.Context
import com.example.kevin.myapplication.injection.component.AppComponent
import com.example.kevin.myapplication.injection.component.DaggerAppComponent
import com.example.kevin.myapplication.injection.module.AppModule
import com.example.kevin.myapplication.injection.module.NetworkModule

class FlickerApplication : Application() {

    internal var mAppComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
    }

    var component: AppComponent
        get() {
            if (mAppComponent == null) {
                mAppComponent = DaggerAppComponent.builder()
                        .appModule(AppModule(this))
                        .networkModule(NetworkModule("https://api.flickr.com/services/"))
                        .build()
            }
            return mAppComponent as AppComponent
        }
        set(appComponent) {
            mAppComponent = appComponent
        }

    companion object {

        operator fun get(context: Context): FlickerApplication {
            return context.applicationContext as FlickerApplication
        }
    }
}