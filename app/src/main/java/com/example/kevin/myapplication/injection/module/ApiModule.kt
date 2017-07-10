package com.example.kevin.myapplication.injection.module

import com.example.kevin.myapplication.api.FlickerService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = arrayOf(NetworkModule::class))
class ApiModule {

    @Provides
    @Singleton
    internal fun provideFlickerApi(retrofit: Retrofit): FlickerService =
            retrofit.create(FlickerService::class.java)
}