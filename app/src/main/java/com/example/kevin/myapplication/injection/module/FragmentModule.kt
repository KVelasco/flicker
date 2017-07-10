package com.example.kevin.myapplication.injection.module

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import com.example.kevin.myapplication.injection.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    internal fun providesFragment(): Fragment {
        return fragment
    }

    @Provides
    internal fun provideActivity(): Activity {
        return fragment.activity
    }

    @Provides
    @ActivityContext
    internal fun providesContext(): Context {
        return fragment.activity
    }

}