package com.example.kevin.myapplication.injection.module

import android.app.Activity
import android.content.Context
import com.example.kevin.myapplication.injection.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    internal fun provideActivity(): Activity {
        return mActivity
    }

    @Provides
    @ActivityContext
    internal fun providesContext(): Context {
        return mActivity
    }
}