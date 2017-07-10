package com.example.kevin.myapplication.injection.component

import com.example.kevin.myapplication.activity.BaseActivity
import com.example.kevin.myapplication.activity.MainActivity
import com.example.kevin.myapplication.injection.PerActivity
import com.example.kevin.myapplication.injection.module.ActivityModule
import dagger.Component

@PerActivity
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(baseActivity: BaseActivity)
}