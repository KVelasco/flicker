package com.example.kevin.myapplication.injection.component

import android.app.Application
import android.content.Context
import com.example.kevin.myapplication.api.DataManager
import com.example.kevin.myapplication.api.FlickerService
import com.example.kevin.myapplication.injection.ApplicationContext
import com.example.kevin.myapplication.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager

    fun flickerService(): FlickerService
}